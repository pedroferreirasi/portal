package br.com.informa.libraries.common;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String getDataAtualSemMascara() {
		DateFormat df = new SimpleDateFormat("ddMMyyyy");
		return df.format(Calendar.getInstance().getTime());		
	}
	
	public static String getDataAtual() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(Calendar.getInstance().getTime());		
	}	
}
