package com.latam.pax.nimbus.common.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lanchile.framework.batch.BatchException;
import com.latam.pax.nimbus.domain.EmailData;

/**
 * @author Manuel
 * @version 1.0
 * @created 23-may.-2017 12:06:44
 */
public class ValidateExcel {
	private static final Logger logger = LoggerFactory.getLogger(ValidateExcel.class);
	private static final String EMPTY=" en blanco, ";
	private static final String MANDATORY=" es Mandatorio\n";
	private static final String VALIDATESIZE="validateSize";
	private static final String ERROR="error";

	/**
	 * 
	 */
	private ValidateExcel() {
		 //Constructor to hide implicit public one
	}
	
	/**
	 * Method used to validate the Dates in all the files
	 * @param nameField
	 * @param size
	 */
	public static String validateFieldDate(String field, boolean mandatory, int indexColumn, String columName, String columAbrev){
			StringBuilder error=new StringBuilder();
			if(mandatory && (field.isEmpty() || field.equalsIgnoreCase(ERROR))){
				error.append(indexColumn+", "+columAbrev+", "+columName+EMPTY+columName+MANDATORY);
				return error.toString();
			}
					if(isValidFormatDate("dd-MM-yyyy",field)){
						return error.toString();
					}else{
						error.append(indexColumn+", "+columAbrev+", "+" Formato no válido, El formato es fecha\n");
					}
					return error.toString();
	}
		
	/**
	 * Method to format a date
	 * @param date
	 * @return
	 */
	public static String formatDate(String date)
	{
		String dateFormated="";
		SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
		    try {
		    	dateFormated= myFormat.format(fromUser.parse(date));
			} catch (ParseException e) {
				logger.error(e.getMessage(),e);
			}
			return dateFormated;
		
	}
	
	/**
	 * Method to parse date fields
	 * @param format
	 * @param value
	 * @return
	 */
	public static boolean isValidFormatDate(String format, String value) {
		logger.info("Validando fecha: "+value);
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException e) {
				logger.error("Failed Parsing date");
		}
		return date != null;
	}
	
	/**
	 * Method to validate alpha numeric fields
	 * @param field
	 * @param size
	 * @param mandatory
	 * @param indexColumn
	 * @param columName
	 * @param columAbrev
	 * @return
	 */
	public static String validateFieldAN(String field, int size, boolean mandatory, int indexColumn, String columName, String columAbrev){
		StringBuilder error=new StringBuilder();
			if(mandatory && (field.trim().isEmpty() || field.equalsIgnoreCase(ERROR))){
				error.append(indexColumn+", "+columAbrev+", "+columName+EMPTY+columName+MANDATORY);
				return error.toString();
			}
			if(isAlphaNumeric(field)){
					if(field.trim().length()<=size){
						return error.toString();
					}else{
						error.append(indexColumn+", "+columAbrev+", "+" Formato no válido, La longitud es mayor a la permitida\n");
					}
				}else{
					error.append(indexColumn+", "+columAbrev+", "+" Formato no válido, El formato es alfanumérico\n");
				}
			
		return error.toString();
	}
	
	/**
	 * method to determine if the field is alpha numeric
	 * @param s
	 * @return
	 */
	public static boolean isAlphaNumeric(String s){
		String pattern= "^[a-zA-Z0-9 ]*$";
		return s.matches(pattern);
	}

	
	/**
	 * Method to determine if the field is Double
	 * @param s
	 * @param sizeInt
	 * @param sizeDecimal
	 * @return
	 */
	public static boolean isDouble(String s, int sizeInt, int sizeDecimal){
		if(s.contains(",")){
			String var=s.replace(",", ".");
			logger.info("Variable a splittear: "+var);
			String[] sP=var.split("\\.");
			
			if(sP[0].length()<=sizeInt  && sP[1].length()<=sizeDecimal){
				return true;
			}
		}
		return false;
	}
	/**
	 * Method to validate size of the file
	 * @param nameFile
	 * @throws BatchException 
	 */
	public static boolean validateSize(File fromFile, String maxSize) {
		File nameFile = new File("input/" + fromFile.getPath());
		if(nameFile.exists()){
			Double bytes = (double) nameFile.length();
			Double kilobytes = bytes/1024;
			Double megabytes = kilobytes/1024;
			if(megabytes<Integer.valueOf(maxSize)){
				return true;
			}else if("0".equalsIgnoreCase(String.valueOf(megabytes))){
				logger.error("El archivo esta vacio: "+nameFile);
				EmailData emailData= new EmailData();
				emailData.setDescription("El archivo esta vacio: "+nameFile);
				emailData.setErrorDate(new Date());
				emailData.setMethod(VALIDATESIZE);
				emailData.setModule(VALIDATESIZE);
				emailData.setProcessName("Cargar Diccionarios Transfer Price");
//				SendMail.sendMailErrorMethod(emailData);
				return false;
			}else{
				logger.error("El tamaño de archivo ["+megabytes+"] supera el límite establecido [Tamaño límite "+maxSize+" MB].");
				EmailData emailData= new EmailData();
				emailData.setDescription("El tamaño de archivo ["+megabytes+"] supera el límite establecido [Tamaño límite "+maxSize+" MB].");
				emailData.setErrorDate(new Date());
				emailData.setMethod(VALIDATESIZE);
				emailData.setModule(VALIDATESIZE);
				emailData.setProcessName("Cargar Diccionarios Transfer Price");
//				SendMail.sendMailErrorMethod(emailData);
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Method to validate the Doubles Fields
	 * @param field
	 * @param sizeInt
	 * @param sizeDecimal
	 * @param mandatory
	 * @param indexColumn
	 * @param columName
	 * @param columAbrev
	 * @return
	 */
	public static String validateDouble(String field, int sizeInt, int sizeDecimal, boolean mandatory, int indexColumn, String columName, String columAbrev)
	{
		StringBuilder error=new StringBuilder();
		if(mandatory && (field.trim().isEmpty() || field.equalsIgnoreCase(ERROR))){
			error.append(indexColumn+", "+columAbrev+", "+columName+EMPTY+columName+MANDATORY);
			return error.toString();
		}
		if(isDouble(field,sizeInt,sizeDecimal)){
			return error.toString();
			}else{
				error.append(indexColumn+", "+columAbrev+", "+" Formato no válido, El formato es numérico\n");
			}
		
	return error.toString();
	}
}