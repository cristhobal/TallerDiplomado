package com.latam.pax.nimbus.domain;

import java.io.Serializable;

/**
 * 
 * @author Robregons
 *
 */
public class Question implements Serializable {
	
	private static final long serialVersionUID = 625446132340553538L;
	
	private String questionId;
	private String questionSpa;
	private String questionPor;
	private String typeAirplane;
	private String reportDoc;
	private String typeQuestion;
	
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionSpa() {
		return questionSpa;
	}
	public void setQuestionSpa(String questionSpa) {
		this.questionSpa = questionSpa;
	}
	public String getQuestionPor() {
		return questionPor;
	}
	public void setQuestionPor(String questionPor) {
		this.questionPor = questionPor;
	}
	
	public String getTypeAirplane(){
		return typeAirplane;
	}
	public void setTypeAirplane(String typeAirplane){
		this.typeAirplane = typeAirplane;
	}
	
	public String getReportDoc(){
		return reportDoc;
	}
	public void setReportDoc(String reportDoc){
		this.reportDoc = reportDoc;
	}
	public String getTypeQuestion() {
		return typeQuestion;
	}
	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result + ((questionSpa == null) ? 0 : questionSpa.hashCode());
		result = prime * result + ((questionPor == null) ? 0 : questionPor.hashCode());
		result = prime * result + ((typeAirplane == null) ? 0 : typeAirplane.hashCode());
		result = prime * result + ((reportDoc == null) ? 0 : reportDoc.hashCode());
		result = prime * result + ((typeQuestion == null) ? 0 : typeQuestion.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionSpa.equals(other.questionSpa))
			return false;
		if (questionPor == null) {
			if (other.questionPor != null)
				return false;
		} 
		return true;
	}
	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionSpa=" + questionSpa
				+ ", questionPor=" + questionPor + ", typeAirplane=" + typeAirplane
				+ ", reportDoc=" + reportDoc + ", typeQuestion=" + typeQuestion + "]";
	}
	

}
