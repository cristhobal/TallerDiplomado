package com.latam.pax.nimbus.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.lanchile.framework.batch.BatchException;
import com.latam.pax.nimbus.business.GenerateReport;
import com.latam.pax.nimbus.domain.Report;




public class SendMail {
	private static final Logger logger = Logger.getLogger(SendMail.class);
	private static final String FORMATDATE="dd/MM/yyyy";
	private static final String BR="<br/>";
	private static final String TEXTHTML="text/html";
	private static final String SUBJECT="config.mail.subject.correct";
	private static final String FROMPROP="config.mail.from";
	private static final String SMTPHOSTPROP="config.mail.smtpHost";
	private static final String SMTPPRO="config.mail.smtp";
	private static final String TDTR="</td></tr>";
	private static final String FOLDER_PDF = "route.folder.pdf";
	private static final String NAME_PDF = "Guia de Confirmacion-";
	private static final String EXTENSION_PDF = ".pdf";
	private static final String NAME_PDF_ADJUNTO = "Guia de Confirmacion.pdf";
	private static List<Report> reports;
	/**
	 * 
	 */
	private SendMail() {
		//Constructor to hide implicit public one
	}

	/**
	 * Build the error message in case of fail in the methods of the process
	 * @param emailData
	 */
	public static void sendMailGcp(){
		PropertyUtil propUtil  = PropertyUtil.getInstance();
		Properties paramsProp=propUtil.getPropertiesFile();
		reports = new ArrayList<>();
		try {
			reports = GenerateReport.generateReport();
			
		} catch (BatchException e) {
			logger.error(e.getMessage(),e);
		}
		for(int i = 0; i < reports.size();i++){

		Report report = reports.get(i);
		
		final String from = paramsProp.getProperty(FROMPROP);
			
		final String smtphost = paramsProp.getProperty(SMTPHOSTPROP); 

		final String smtp = paramsProp.getProperty(SMTPPRO); 
		Date dToday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATDATE);
		final String subject = paramsProp.getProperty(SUBJECT) + " " + report.getOperator()+report.getFligthCode()+ " " + sdf.format(dToday) + " " + report.getAirportOriginCode() + " - " + report.getAirportDestinationCode();

//		final String to = paramsProp.getProperty("config.mails.to");
		
		String to = report.getMail();		
		if(to == null){
			to = paramsProp.getProperty("config.mails.to");
		}
		
		String myMsg=  "Buenas noches,"
				+ BR
				+ BR
				+ "Resultado obtenido a la hora de haberse realizado su evaluación de la guía de confirmación de procesos (GCP), la misma fue realizada por "
				+ report.getJsbName()
				+ TDTR 
				+ BR
				+ "Correspondiente al vuelo " + report.getOperator() + report.getFligthCode() + " de " + report.getFligthDate() + " de " + report.getAirportOriginCode() + " - " + report.getAirportDestinationCode()
				+ BR
				+ BR
				+ BR
				+ "Adjunto GCP" 
				+ BR
				+ BR
				+ "Saludos";
		Properties propiedades = System.getProperties();
		String de = from;
		String host = smtphost;
		propiedades.setProperty(smtp, host);
		Session sesion = Session.getDefaultInstance(propiedades);
		try{
			

			MimeMultipart multiParte = new MimeMultipart();
			MimeMessage mensaje = new MimeMessage(sesion);
			BodyPart texto = new MimeBodyPart();			
			BodyPart adjunto = new MimeBodyPart();			
			adjunto.setDataHandler(new DataHandler(new FileDataSource(paramsProp.getProperty(FOLDER_PDF) + NAME_PDF +(i+1)+ EXTENSION_PDF)));
			adjunto.setFileName(NAME_PDF_ADJUNTO);
			multiParte.addBodyPart(adjunto);
			multiParte.addBodyPart(texto);			
			texto.setContent(myMsg, TEXTHTML);
			mensaje.setContent(myMsg,TEXTHTML);
			mensaje.setSubject(subject);
			mensaje.setFrom(new InternetAddress(de));
			mensaje.setContent(multiParte);
			mensaje.addRecipients(Message.RecipientType.TO, to);

			Transport.send(mensaje);
			logger.info("Mensaje enviado correctamente.");
		} catch (MessagingException e) {
			logger.error(e.getMessage(), e);
		}

		}
	}
	
}
