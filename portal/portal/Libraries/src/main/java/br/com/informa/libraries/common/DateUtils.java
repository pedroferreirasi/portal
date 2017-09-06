package br.com.informa.libraries.common;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	private static final Class FACTORY_CLASS = CommonMethods.class;
	
	private DateUtils()	{ }	
	
	public static DateUtils getInstance()
	{
		try {
			return (DateUtils) FACTORY_CLASS.newInstance();
		} catch (InstantiationException e) {
			Logger.getGlobal().log(Level.SEVERE,"",e);
			throw new RuntimeException();
		} catch (IllegalAccessException e) {
			Logger.getGlobal().log(Level.SEVERE,"",e);
			throw new RuntimeException();
		}
	}
	
	public boolean getDataValida(String strData) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
		    sdf.parse(strData);
		    return true;
		}catch (Exception e){ //n lembro a exceção q dispara qdo formata errado
		    return false;
		}
	}

	public String getDataAtualSemMascara() {
		DateFormat df = new SimpleDateFormat("ddMMyyyy");
		return df.format(Calendar.getInstance().getTime());		
	}
	
	public String getDataAtual() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(Calendar.getInstance().getTime());		
	}	
}
