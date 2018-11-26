package com.latam.pax.nimbus.business;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import com.latam.pax.nimbus.common.util.PropertyUtil;
import com.latam.pax.nimbus.domain.Document;
import com.latam.pax.nimbus.domain.FtpHGSAB;

public class FtpConnection {

	private static final String FTP_HOSTNAME = "ftp.hostname";
	private static final String FTP_PORT = "ftp.port";
	private static final String FTP_USERNAME = "ftp.username";
	private static final String FTP_PASSW = "ftp.password";
	
	private static final String CONNECT_ERROR_POSITIVE_COMPLETION_NATIVE_MESSAGE  = "Connect failed to ftp";
	private static final String LOGIN_ERROR_NATIVE_MESSAGE  = "Could not login to the server";	
	
	private static final Logger logger = Logger.getLogger(GenerateReport.class);
	
	private FtpConnection() {
		//This is a constructor
	}
	
	public static FtpHGSAB connetToFtp() throws IOException {
		PropertyUtil propUtil  = PropertyUtil.getInstance();
		Properties paramsProp=propUtil.getPropertiesFile();
		
		String hostname = paramsProp.getProperty(FTP_HOSTNAME);
		int port = Integer.parseInt(paramsProp.getProperty(FTP_PORT));
		String username = paramsProp.getProperty(FTP_USERNAME);
		String password = paramsProp.getProperty(FTP_PASSW);		
		return connection(username, password, hostname, port);
	}
	
	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				logger.debug("SERVER: " + aReply);
			}
		}
	}
	
	public static FtpHGSAB connection(final String user, final String pass,
			final String hostname, final int port) throws IOException {
		logger.debug("connecting to the ftp ");
		FtpHGSAB ftpHGSAB;
		FTPClient ftp;
		ftp = new FTPClient();
		ftpHGSAB = new FtpHGSAB();
		ftp.connect(hostname, port);
		showServerReply(ftp);
		int replyCode = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(replyCode)) {
			logger.error(CONNECT_ERROR_POSITIVE_COMPLETION_NATIVE_MESSAGE);
			logger.error("ftp hostname port "+hostname+"/"+port);
			throw new IOException(CONNECT_ERROR_POSITIVE_COMPLETION_NATIVE_MESSAGE + " ["+hostname+","+ port+"]");
		}
		boolean success = ftp.login(user, pass);
		if (!success) {
			logger.error(LOGIN_ERROR_NATIVE_MESSAGE);
			throw new IOException(LOGIN_ERROR_NATIVE_MESSAGE + " ["+user+"]");
		}
		showServerReply(ftp);
		ftpHGSAB.setFtp(ftp);
		return ftpHGSAB;
	}
	
	public static ByteArrayInputStream getInputStream(String filePath) throws IOException{
		Document doc = getDocument(connetToFtp(), filePath);
		if (doc.getFile() != null){
			return new ByteArrayInputStream(doc.getFile());
		}else{
			logger.error("Error to get the signatures, file is null "+filePath);
		}
		return null;
	}
	
	public static Document getDocument(FtpHGSAB ftpHGSAB, String pathFile)
			throws IOException {	
		FTPClient ftp = null;
		
		if (ftpHGSAB.getFtp() instanceof FTPClient) {
			ftp = (FTPClient) ftpHGSAB.getFtp();
		} else {
			logger.error("FTP error org.apache.commons.net.ftp.FTPClient");
		}
		
		if(ftp != null){
			ftp.enterLocalPassiveMode();

			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			FTPFile[] files = ftp.listFiles(pathFile);
			if (files.length != 1) {
				logger.error("en el path [" + pathFile + "] se encontraron ["
						+ files.length + "] archivos");
			}
		
			InputStream inputStream = ftp.retrieveFileStream(pathFile);
			Document document = new Document();
			if(inputStream != null){
				try {
					document.setFile(IOUtils.toByteArray(inputStream));	
				}finally{
					closed("getDocument() inputStream.close()", inputStream);
				}
				if (ftp.completePendingCommand()) {
					logger.debug("File #2 has been downloaded successfully, name : "+pathFile);
				}else{
					logger.error("File #2 downloaded failure!.");
				}
			}
			return document;
		}else{			
			return new Document();
		}				
	}
	
	private static void closed(String msg, Closeable c){
		try {
			if(c != null){
				c.close();
			}
		} catch (IOException e) {
			logger.error("IOException, closed() " +msg, e);
		}
	}
}
