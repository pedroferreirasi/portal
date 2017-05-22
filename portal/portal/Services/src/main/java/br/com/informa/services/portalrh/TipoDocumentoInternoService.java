package br.com.informa.services.portalrh;

import java.util.List; 
import br.com.informa.models.portalrh.TipoDocumentoInterno; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.ITipoDocumentoInternoDao; 
 
public class TipoDocumentoInternoService implements ITipoDocumentoInternoService { 
 
	@Override 
	public void Add(TipoDocumentoInterno entity) { 
		ITipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(TipoDocumentoInterno entity) { 
		ITipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(TipoDocumentoInterno entity) { 
		ITipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		ITipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public TipoDocumentoInterno getById(Integer pk) { 
		ITipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<TipoDocumentoInterno> getListAll() { 
		ITipoDocumentoInternoDao entityDao = FactoryDao.getFactory().getTipoDocumentoInternoDao(); 
		return entityDao.getListAll(); 
	} 
} 
