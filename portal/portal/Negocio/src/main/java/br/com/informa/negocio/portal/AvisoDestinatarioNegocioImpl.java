package br.com.informa.negocio.portal;

import java.util.List; 
import br.com.informa.models.portalrh.AvisoDestinatario; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.AvisoDestinatarioDao; 
 
public class AvisoDestinatarioNegocioImpl implements AvisoDestinatarioNegocio { 
 
	@Override 
	public void Add(AvisoDestinatario entity) { 
		AvisoDestinatarioDao entityDao = FactoryDao.getFactory().getAvisoDestinatarioDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(AvisoDestinatario entity) { 
		AvisoDestinatarioDao entityDao = FactoryDao.getFactory().getAvisoDestinatarioDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(AvisoDestinatario entity) { 
		AvisoDestinatarioDao entityDao = FactoryDao.getFactory().getAvisoDestinatarioDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		AvisoDestinatarioDao entityDao = FactoryDao.getFactory().getAvisoDestinatarioDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public AvisoDestinatario getById(Integer pk) { 
		AvisoDestinatarioDao entityDao = FactoryDao.getFactory().getAvisoDestinatarioDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<AvisoDestinatario> getListAll() { 
		AvisoDestinatarioDao entityDao = FactoryDao.getFactory().getAvisoDestinatarioDao(); 
		return entityDao.getListAll(); 
	} 
 
	@Override
	public Boolean validacao(AvisoDestinatario entity) {
		// TODO Auto-generated method stub 
		return true; 
 }

	@Override
	public List<AvisoDestinatario> getAvisosPorUsuario(Integer pk) {
		AvisoDestinatarioDao entityDao = FactoryDao.getFactory().getAvisoDestinatarioDao(); 
		return entityDao.getAvisosPorUsuario(pk);
	}
} 
