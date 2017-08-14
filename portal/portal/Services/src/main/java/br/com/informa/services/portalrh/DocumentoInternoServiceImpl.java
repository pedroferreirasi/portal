package br.com.informa.services.portalrh;

import java.util.Date;
import java.util.List; 
import br.com.informa.models.portalrh.DocumentoInterno; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.DocumentoInternoDao;
import br.com.informa.services.exception.CampoObrigatorioNullException; 
 
public class DocumentoInternoServiceImpl implements DocumentoInternoService { 
 
	@Override 
	public void Add(DocumentoInterno entity) { 
		DocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao();
		entity.setDataCadastro(new Date());
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(DocumentoInterno entity) { 
		DocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(DocumentoInterno entity) { 
		DocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		DocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public DocumentoInterno getById(Integer pk) { 
		DocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<DocumentoInterno> getListAll() { 
		DocumentoInternoDao entityDao = FactoryDao.getFactory().getDocumentoInternoDao(); 
		return entityDao.getListAll(); 
	}

	@Override
	public Boolean validacao(DocumentoInterno entity) {
		Boolean resultado = true;

		if (entity.getTipoDocumentoInterno() == null) {
			resultado = false;
			throw new CampoObrigatorioNullException("Descrição");
		}

		if (entity.getTipoDocumentoInterno().equals("")) {
			resultado = false;
			throw new CampoObrigatorioNullException("Descrição");
		}

		return resultado;
	} 
} 
