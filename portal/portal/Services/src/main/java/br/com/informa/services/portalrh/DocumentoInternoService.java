package br.com.informa.services.portalrh;

import java.util.List; 
import br.com.informa.models.portalrh.DocumentoInterno; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.IDocumentoInternoDao; 
 
public class DocumentoInternoService implements IDocumentoInternoService { 
 
	@Override 
	public void Add(DocumentoInterno entity) { 
		IDocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(DocumentoInterno entity) { 
		IDocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(DocumentoInterno entity) { 
		IDocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		IDocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public DocumentoInterno getById(Integer pk) { 
		IDocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<DocumentoInterno> getListAll() { 
		IDocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		return entityDao.getListAll(); 
	} 
} 
