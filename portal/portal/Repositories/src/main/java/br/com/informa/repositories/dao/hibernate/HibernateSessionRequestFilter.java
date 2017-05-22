package br.com.informa.repositories.dao.hibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSessionRequestFilter implements Filter {
	
	protected static final Logger logger = LoggerFactory
			.getLogger(HibernateSessionRequestFilter.class);
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			logger.debug("Starting a database transaction");
			tx = session.beginTransaction();

			// Call the next filter (continue request processing)
			chain.doFilter(request, response);

			// Commit if needed and cleanup
			if (tx.isActive()) {
				logger.debug("Committing the database transaction");
				tx.commit();
			}
			
		} catch (Throwable ex) {
			logger.debug("failed to process the request!", ex);
			if ((tx != null) && tx.isActive())
				tx.rollback();
			if (session.isOpen())
				session.close();
			throw new ServletException(ex);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {}

	public void destroy() {}
}
