
package com.latam.pax.nimbus.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import com.lanchile.framework.batch.BatchException;
import com.latam.pax.nimbus.common.util.PropertyUtil;
import com.latam.pax.nimbus.domain.AspectGcpEvaluated;
import com.latam.pax.nimbus.domain.CrewMember;
import com.latam.pax.nimbus.domain.EmailData;
import com.latam.pax.nimbus.domain.Report;
import com.latam.pax.nimbus.domain.ResultGCP4JSB;
import com.latam.pax.nimbus.persistence.services.ReportServices;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * 
 * @author Robregons
 *
 */
public class GenerateReport {
	
	
	private static String language;
	
	private static final String MESSAGEA="No se puede generar el archivo de reporte ";
	private static final String MESSAGEB=" desde el catálogo.";

	private static final String PARAM_GCP_FIRMATC_PT = "param.gcp.firmatcPT";
	private static final String PARAM_GCP_FIRMAJSB_PT = "param.gcp.firmajsbPT";
	private static final String PARAM_GCP_TABLE_EVALUACION_PT = "param.gcp.table.evaluacionPT";
	private static final String PARAM_GCP_TABLE_DETAIL_PT = "param.gcp.table.detailPT";
	private static final String PARAM_GCP_TABLE_COMPETENCIA_PT = "param.gcp.table.competenciaPT";
	private static final String PARAM_GCP_TABLE_COMPETENCIA = "param.gcp.table.competencia";

	private static final String PARAM_GCP_NAMEJSB_PT = "param.gcp.namejsb.pt";
	private static final String PARAM_GCP_NAMEJSB = "param.gcp.namejsb";	
	private static final String PARAM_GCP_FLIGHTPOSITION_PT = "param.gcp.flightpositionPT";
	private static final String PARAM_GCP_BP_PT = "param.gcp.bpPT";
	private static final String PARAM_GCP_NAMETC_PT = "param.gcp.nametc.pt";
	private static final String PARAM_GCP_FLIGHT_PT = "param.gcp.flightPT";
	private static final String PARAM_GCP_TITLE_PT = "param.gcp.titlePT";
	private static final String VALUE_GCP_TABLE_NOTA = "value.gcp.table.nota";
	private static final String VALUE_GCP_TABLE_TPOPREG = "value.gcp.tipopreg";
	private static final String VALUE_GCP_TABLE_ASP = "value.gcp.table.asp";
	private static final String VALUE_GCP_TABLE_COMP = "value.gcp.table.comp";
	private static final String VALUE_GCP_TABLE_PHASE = "value.gcp.phase";
	private static final String VALUE_GCP_TABLE_SECT = "value.gcp.section";
	private static final String VALUE_GCP_NAMEJSB = "value.gcp.namejsb";
	private static final String VALUE_GCP_FLIGHTPOSITION = "value.gcp.flightposition";	
	private static final String VALUE_GCP_NAMETC = "value.gcp.nametc";
	private static final String VALUE_GCP_FLIGHT = "value.gcp.flight";
	private static final String VALUE_GCP_DATE = "value.gcp.date";
	
	private static final String VALUE_GCP_MEJORAS = "value.gcp.mejoras";
	private static final String VALUE_GCP_COMENTARIOS = "value.gcp.comentarios";
	private static final String VALUE_GCP_FORTALEZAS = "value.gcp.fortalezas";
	
	private static final String PARAM_GCP_FIRMATC = "param.gcp.firmatc";
	private static final String PARAM_GCP_FIRMAJSB = "param.gcp.firmajsb";
	private static final String PARAM_GCP_TABLE_EVALUACION = "param.gcp.table.evaluacion";
	private static final String PARAM_GCP_TABLE_DETAIL = "param.gcp.table.detail";	
	private static final String PARAM_GCP_FLIGHTPOSITION = "param.gcp.flightposition";
	private static final String PARAM_GCP_BP = "param.gcp.bp";
	private static final String PARAM_GCP_NAMETC = "param.gcp.nametc";
	private static final String PARAM_GCP_FLIGHT = "param.gcp.flight";
	private static final String PARAM_GCP_DATE = "param.gcp.date";
	private static final String PARAM_GCP_TITLE = "param.gcp.title";
	private static final String VALUE_GCP_TIPO_GAD = "value.gcp.tipo.gad";
	
	private static final String PARAM_GCP_FORTALEZAS_TITLE = "param.gcp.fortalezas.title";
	private static final String PARAM_GCP_FORTALEZAS_TITLE_PT = "param.gcp.fortalezas.title.pt";
	private static final String PARAM_GCP_MEJORAS_TITLE = "param.gcp.mejoras.title";
	private static final String PARAM_GCP_MEJORAS_TITLE_PT= "param.gcp.mejoras.title.pt";
	private static final String PARAM_GCP_COMENTARIOS_TITLE= "param.gcp.comentarios.title";
	private static final String PARAM_GCP_COMENTARIOS_TITLE_PT= "param.gcp.mejoras.title.pt";
	
	

	private static final String PARAM_GCP_PROCESO_TITLE = "param.gcp.proceso.title";
	private static final String PARAM_GCP_GUIA_TITLE = "param.gcp.guia.title";
	private static final String PARAM_GCP_PREGUNTAS_TITLE = "param.gcp.preguntas.title";
	private static final String PARAM_GCP_EVALUACION_TITLE = "param.gcp.evaluacion.title";
	
	private static final String PARAM_GCP_PROCESO_TITLE_PT = "param.gcp.proceso.title.pt";
	private static final String PARAM_GCP_GUIA_TITLE_PT = "param.gcp.guia.title.pt";
	private static final String PARAM_GCP_PREGUNTAS_TITLE_PT = "param.gcp.preguntas.title.pt";
	private static final String PARAM_GCP_EVALUACION_TITLE_PT = "param.gcp.evaluacion.title.pt";
	
	private static final String VALUE_GCP_SINGJSB = "value.gcp.SingJSB";
	private static final String VALUE_GCP_SINGTC = "value.gcp.SingTC";
	private static final String PARAM_PUNTAJE = "param.gcp.puntaje";
	private static final String PARAM_PUNTAJE_PT = "param.gcp.puntaje.pt";	
	private static final String VALUE_PROMEDIO = "value.gcp.prom";
	private static final String SUBREPORT_GCP = "SUBREPORT_PRE_IFE_MSFAIL_IFEMSV";
	private static final String ROUTE_SUB_REPORT = "route.subreport";
	
	private static final String FOLDER_JASPER = "route.folder.jasper";
	private static final String JASPER_REPORT_NB = "/"+ "reporteNbGCPRegional.jasper";
	
	private static final String JASPER_REPORT_WB = "/"+ "reporteWbGCP.jasper";
	
	private static final String JASPER_REPORT_DM = "/"+ "reporteDMGCP.jasper";
	
	private static final String FOLDER_PDF = "route.folder.pdf";
	private static final String NAME_PDF = "Guia de Confirmacion-";	
	private static final String EXTENSION_PDF = ".pdf";
	private static final String NA = "NA";
	
	public static final String SPANISH = "es";
	private static final String DEFAULT_LANGUAGE = SPANISH;
	private static final String[] VALID_LANGUAGES_ARRAY = {"es", "pt" };
	private static final Set<String> VALID_LANGUAGES = new HashSet<>(Arrays.asList(VALID_LANGUAGES_ARRAY));
	
	private static final Logger logger = Logger.getLogger(GenerateReport.class);
	
	private GenerateReport() {
		//This is a constructor
	}
	
	/**
	 * Method used to generate the report depending of the file processed
	 * @param format
	 * @param prop
	 * @param processed
	 * @throws BatchException
	 */
	public static List<Report> generateReport() throws BatchException{
		ReportServices rptServ= new ReportServices();
		List<Report> listToBd = rptServ.getReport();
		generateData(listToBd);
		return listToBd;
		
	}
	
	private static void generateData(List<Report> data){	
		int cont = 1;
		for (Report report : data) {			
			buildReport(report.getReportId(),cont++);
		}
	}
	
	private static void buildReport(String reportId,int cont){
		ReportServices rptServ= new ReportServices();
		try {			
			ResultGCP4JSB gcp = rptServ.detailGcp(reportId);
			
			CrewMember crewMember = new CrewMember();
			crewMember.setBp(gcp.getAppraisee().getBp());
			crewMember.setActiveRank(gcp.getAppraisee().getActiveRank());
			
			gcp.setAppraisee(rptServ.getCrewByBp2(crewMember));
			gcp.getAppraisee().setActiveRank(crewMember.getActiveRank());
						
			crewMember.setBp(gcp.getAppraiser().getBp());
			gcp.setAppraiser(rptServ.getCrewByBp2(crewMember));
						
			List<AspectGcpEvaluated> listQuestionsAnswered = rptServ.getQuestionGCPAnswered(gcp.getAppraisee().getBp());
			gcp.setAssessments(listQuestionsAnswered);				
			buildReportBusiness(gcp,cont);
			
		} catch (BatchException e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	/**
	 * Method used to build the Business Report File
	 * @param line
	 * @param format
	 * @param prop
	 * @throws BatchException
	 */
	private static void buildReportBusiness(ResultGCP4JSB gcp, int cont) throws BatchException{
		PropertyUtil propUtil  = PropertyUtil.getInstance();
		Properties paramsProp=propUtil.getPropertiesFile();
		final Map<String, Object> parameters = getPdfGcp(gcp);		
		String fileName = "";
		try {	  
			if (gcp.getType().getCode() == 1){
				fileName = paramsProp.getProperty(FOLDER_JASPER) + JASPER_REPORT_NB;				
			}else if (gcp.getType().getCode() == 2){
				fileName = paramsProp.getProperty(FOLDER_JASPER) + JASPER_REPORT_WB;								
			}else{ 				
				fileName = paramsProp.getProperty(FOLDER_JASPER) + JASPER_REPORT_DM;				
			}	
	      
	      JasperPrint print = JasperFillManager.fillReport(fileName, parameters, new JREmptyDataSource());			      		 	      
	      JasperExportManager.exportReportToPdfFile(print, paramsProp.getProperty(FOLDER_PDF) + NAME_PDF + cont + EXTENSION_PDF);	      	      
	    }catch (Exception e) {			        
	    	logger.error(e.getMessage(),e);
	    }		
	}

	private static void getLoadDataForm(final Map<String, Object> parameters) {
		PropertyUtil propUtil  = PropertyUtil.getInstance();
		Properties paramsProp=propUtil.getPropertiesFile();
		parameters.put(
				PARAM_GCP_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_TITLE),
						paramsProp.getProperty(PARAM_GCP_TITLE_PT)));
		
		parameters.put(
				PARAM_GCP_FLIGHTPOSITION,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_FLIGHTPOSITION),
						paramsProp.getProperty(PARAM_GCP_FLIGHTPOSITION)));
		parameters.put(
				PARAM_GCP_MEJORAS_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_MEJORAS_TITLE),
						paramsProp.getProperty(PARAM_GCP_MEJORAS_TITLE_PT)));
		parameters.put(
				PARAM_GCP_FORTALEZAS_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_FORTALEZAS_TITLE),
						paramsProp.getProperty(PARAM_GCP_FORTALEZAS_TITLE_PT)));
		parameters.put(
				PARAM_GCP_COMENTARIOS_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_COMENTARIOS_TITLE),
						paramsProp.getProperty(PARAM_GCP_COMENTARIOS_TITLE_PT)));
		
		parameters.put(
				PARAM_GCP_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_TITLE),
						paramsProp.getProperty(PARAM_GCP_TITLE_PT)));
		parameters.put(
				PARAM_GCP_PROCESO_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_PROCESO_TITLE),
						paramsProp.getProperty(PARAM_GCP_PROCESO_TITLE_PT)));
		parameters.put(
				PARAM_GCP_GUIA_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_GUIA_TITLE),
						paramsProp.getProperty(PARAM_GCP_GUIA_TITLE_PT)));
		parameters.put(
				PARAM_GCP_PREGUNTAS_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_PREGUNTAS_TITLE),
						paramsProp.getProperty(PARAM_GCP_PREGUNTAS_TITLE_PT)));
		parameters.put(
				PARAM_GCP_EVALUACION_TITLE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_EVALUACION_TITLE),
						paramsProp.getProperty(PARAM_GCP_EVALUACION_TITLE_PT)));
		parameters.put(
				PARAM_GCP_FLIGHT,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_FLIGHT),
						paramsProp.getProperty(PARAM_GCP_FLIGHT_PT)));
		parameters.put(
				PARAM_GCP_DATE,
						paramsProp.getProperty(PARAM_GCP_DATE));
		
		parameters.put(PARAM_GCP_NAMETC,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_NAMETC),
						paramsProp.getProperty(PARAM_GCP_NAMETC_PT)));		
		parameters.put(
				PARAM_GCP_BP,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_BP),
						paramsProp.getProperty(PARAM_GCP_BP_PT)));
		parameters.put(
				PARAM_GCP_FLIGHTPOSITION,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_FLIGHTPOSITION),
						paramsProp.getProperty(PARAM_GCP_FLIGHTPOSITION_PT)));
		parameters.put(
				PARAM_GCP_NAMEJSB,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_NAMEJSB),
						paramsProp.getProperty(PARAM_GCP_NAMEJSB_PT)));
		parameters.put(
				PARAM_GCP_TABLE_COMPETENCIA,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_TABLE_COMPETENCIA),
						paramsProp.getProperty(PARAM_GCP_TABLE_COMPETENCIA_PT)));
		parameters.put(
				PARAM_GCP_TABLE_DETAIL,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_TABLE_DETAIL),
						paramsProp.getProperty(PARAM_GCP_TABLE_DETAIL_PT)));
		parameters.put(
				PARAM_GCP_TABLE_EVALUACION,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_TABLE_EVALUACION),
						paramsProp.getProperty(PARAM_GCP_TABLE_EVALUACION_PT)));
		parameters.put(
				PARAM_GCP_FIRMAJSB,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_FIRMAJSB), 
						paramsProp.getProperty(PARAM_GCP_FIRMAJSB_PT)));
		parameters.put(
				PARAM_GCP_FIRMATC,
				getValueIdiom(
						paramsProp.getProperty(PARAM_GCP_FIRMATC),
						paramsProp.getProperty(PARAM_GCP_FIRMATC_PT)));
		parameters.put(PARAM_PUNTAJE,
				getValueIdiom(
						paramsProp.getProperty(PARAM_PUNTAJE),
						paramsProp.getProperty(PARAM_PUNTAJE_PT)));
	}
	
	private static void getLoadValueForm(final Map<String, Object> parameters,ResultGCP4JSB gcp){
		parameters.put(
				VALUE_GCP_MEJORAS,
				gcp.getImprovements());
		parameters.put(
				VALUE_GCP_COMENTARIOS,
				gcp.getAppraiseeComments());
		parameters.put(
				VALUE_GCP_FORTALEZAS,
				gcp.getStrengths());
		
		parameters.put(
				VALUE_GCP_TIPO_GAD,
				gcp.getType().getTypeGadDescription());
		
		parameters.put(VALUE_GCP_NAMETC, gcp.getAppraisee().getFirstName()
				+ " " + gcp.getAppraisee().getLastName());
		parameters.put(VALUE_GCP_FLIGHTPOSITION, gcp.getAppraisee()
				.getActiveRank());
		parameters.put(VALUE_GCP_NAMEJSB, gcp.getAppraiser().getFirstName()
				+ " " + gcp.getAppraiser().getLastName());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");		
		parameters.put(
				VALUE_GCP_DATE,
				sdf.format(gcp.getFlightDate()));
		parameters.put(
				VALUE_GCP_FLIGHT,
				gcp.getFlight().getAirlineCode()+String.valueOf(gcp.getFlight().getFlightNumber()));		
	}
	
	private static void getLoadSign(final Map<String, Object> parameters, ResultGCP4JSB gcp) {
		try {
			if (gcp.getAppraiseeFile().getFilePath() != null){
				parameters.put(VALUE_GCP_SINGJSB, FtpConnection.getInputStream(gcp.getAppraiseeFile().getFilePath()));	
			}else{
				logger.error("Error to get the signatures without path in db, appraisee");
			}
			if (gcp.getReviewerFile().getFilePath() != null){
				parameters.put(VALUE_GCP_SINGTC, FtpConnection.getInputStream(gcp.getReviewerFile().getFilePath()));
			}else{
				logger.error("Error to get the signatures without path in db, reviewer");
			}
		} catch (IOException e) {
			logger.error("Error to get the signatures of the ftp");
		}
	}
	
	
	private static Map<String, Object> getPdfGcp(ResultGCP4JSB gcp){
		final Map<String, Object> parameters = new HashMap<>();
		PropertyUtil propUtil  = PropertyUtil.getInstance();
		Properties paramsProp=propUtil.getPropertiesFile();
		// PARAMETROS FORMULARIO
		getLoadDataForm(parameters);		
		// VALORES FORMULARIO
		getLoadValueForm(parameters, gcp);
		
		getLoadSign(parameters,gcp);

		List<AspectGcpEvaluated>  listQuestionsAdhoc = new ArrayList<>();
		List<AspectGcpEvaluated>  listQuestionsGcp = new ArrayList<>();
		for (int j = 0; j < gcp.getAssessments().size(); j++) {
			if(gcp.getAssessments().get(j).getCodePhase() == 10){
				listQuestionsAdhoc.add(gcp.getAssessments().get(j));
			}else{
				listQuestionsGcp.add(gcp.getAssessments().get(j));
			}			
		}
		
		getLoadTable(parameters,listQuestionsGcp);

		try {
			File f = new File(paramsProp.getProperty(ROUTE_SUB_REPORT));
			InputStream is = new FileInputStream(f);
			parameters.put(SUBREPORT_GCP,is);
			} catch (Exception e) {
			logger.error(e.getMessage(), e);
			}

			parameters.put("PRE_IFE_MSFAIL_IFEMSV", "Preguntas Adhoc");
			List<Map<String, Object>> contentList = getLoadContentList(listQuestionsAdhoc);
			
			parameters.put(
					"PRE_IFE_MSFAIL_IFEMSV_LIST", contentList);
		
		return parameters;
	}
	
	private static void getLoadTable(final Map<String, Object> parameters, List<AspectGcpEvaluated>  listQuestionsGcp){
		int numPhase = 1;
		int numSection = 1;
		float puntaje = 0;
		int cantidadPreguntas = 0;
		for (int i = 0; i < listQuestionsGcp.size(); i++) {
				int numAssess = i + 1;	
				if(i > 0){
					if(!listQuestionsGcp.get(i-1).getSection().equals(listQuestionsGcp.get(i).getSection())){						
						parameters.put(
								VALUE_GCP_TABLE_SECT + numSection,
								getValueIdiom(listQuestionsGcp.get(i).getSection(), listQuestionsGcp.get(i).getSection()));
						numSection = numSection + 1;
					}
					
					if(!listQuestionsGcp.get(i-1).getPhase().equals(listQuestionsGcp.get(i).getPhase())){
						parameters.put(
								VALUE_GCP_TABLE_PHASE + numPhase,
								getValueIdiom(listQuestionsGcp.get(i).getPhase(), listQuestionsGcp.get(i).getPhase()));
						numPhase = numPhase + 1;
					}
				}else{
					parameters.put(
							VALUE_GCP_TABLE_SECT + numSection,
							getValueIdiom(listQuestionsGcp.get(i).getSection(), listQuestionsGcp.get(i).getSection()));
					numSection = numSection + 1;
					parameters.put(
							VALUE_GCP_TABLE_PHASE + numPhase,
							getValueIdiom(listQuestionsGcp.get(i).getPhase(), listQuestionsGcp.get(i).getPhase()));
					numPhase = numPhase + 1;
				}
				
				parameters.put(
						VALUE_GCP_TABLE_COMP + numAssess,
						getValueIdiom(listQuestionsGcp.get(i).getAspect(), listQuestionsGcp.get(i).getAspectPT()));
				
				parameters.put(
						VALUE_GCP_TABLE_ASP + numAssess, listQuestionsGcp.get(i).getAverage());
				
				parameters.put(
						VALUE_GCP_TABLE_NOTA + numAssess, Float.toString(listQuestionsGcp.get(i).getAverageTotal()));
				
				parameters.put(
						VALUE_GCP_TABLE_TPOPREG + numAssess, listQuestionsGcp.get(i).getTypeQuestion());
				
				if(!listQuestionsGcp.get(i).getPhase().equals("10")){
					if(!listQuestionsGcp.get(i).getAverage().equals(NA)){
						cantidadPreguntas += 1; 
					}
					puntaje = puntaje + listQuestionsGcp.get(i).getAverageTotal();
				}
					
				
		}
		String data;
		if(cantidadPreguntas == 0){
			data = "0";
		}else{
			puntaje = (int)((puntaje/cantidadPreguntas)*100);
			data = Float.toString(puntaje) + "";
			data = data.replace(".0", "");
		}
		
		parameters.put(
				VALUE_PROMEDIO, data+"%");
	}
	
	private static List<Map<String, Object>> getLoadContentList(
			List<AspectGcpEvaluated> listQuestionsAdhoc) {
		List<Map<String, Object>> contentList = new ArrayList<>();
		Map<String, Object> contentMap;

		for (int k = 0; k < listQuestionsAdhoc.size(); k++) {
				contentMap = new HashMap<>();			
				contentMap.put("value1", listQuestionsAdhoc.get(k).getAspect());				
				contentMap.put("value2", listQuestionsAdhoc.get(k).getAverage());
				contentMap.put("value3", Float.toString(listQuestionsAdhoc.get(k).getAverageTotal()));
				contentList.add(k,contentMap);								
		}
		return contentList;
	}
	
	private static String getValueIdiom(String spanish, String portuguese) {
		return getValueLanguage(language, spanish, portuguese);
	}
	
	
	public static String getValueLanguage(String language, String spanish, String portuguese) {
		String propertiesLanguage = getPropertiesLanguage(language);
		if (SPANISH.equals(propertiesLanguage)) {
			return spanish;
		} else {
			return portuguese;
		}
	}
	
	public static String getPropertiesLanguage(String language) {
		if(language != null){
			if (VALID_LANGUAGES.contains(language.toLowerCase())) {
				return language;
			} else {
				return DEFAULT_LANGUAGE;
			}
		}else{
			return DEFAULT_LANGUAGE;
		}		
	}
	/**
	 * Method used to build the error message
	 * @param method
	 * @param dateFormated
	 * @param fileName
	 * @param extension
	 */
	protected static void sendMailError(String method, String dateFormated, String fileName, String extension) {
		EmailData emailData= new EmailData();
		emailData.setDescription(MESSAGEA+fileName+dateFormated+extension+MESSAGEB);
		emailData.setErrorDate(new Date());
		emailData.setMethod(method);
		emailData.setModule(method);
		emailData.setProcessName("Envio correo");
		//SendMail.sendMailErrorMethod(emailData);
	}
}
