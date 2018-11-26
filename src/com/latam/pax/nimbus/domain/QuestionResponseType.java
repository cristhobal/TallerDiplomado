package com.latam.pax.nimbus.domain;

import java.io.Serializable;

/**
 * Class Type Report Bean Type
 * @author TCS
 * @author pedro.vargas@tcs.com
 */

public class QuestionResponseType implements Serializable {
	
	private static final long serialVersionUID = 625446132340553538L;
	private String questionId;
	private String questionSpa;
	private String questionPor;
	private Integer phase;
	private Integer section;
	private Integer questionType;
	private String score;
	
	
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
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Integer getPhase() {
		return phase;
	}
	public void setPhase(Integer phase) {
		this.phase = phase;
	}
	public Integer getSection() {
		return section;
	}
	public void setSection(Integer section) {
		this.section = section;
	}
	public Integer getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phase == null) ? 0 : phase.hashCode());
		result = prime * result
				+ ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result
				+ ((questionPor == null) ? 0 : questionPor.hashCode());
		result = prime * result
				+ ((questionSpa == null) ? 0 : questionSpa.hashCode());
		result = prime * result
				+ ((questionType == null) ? 0 : questionType.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		QuestionResponseType other = (QuestionResponseType) obj;
		if (phase == null) {
			if (other.phase != null)
				return false;
		} else if (!phase.equals(other.phase))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		if (questionPor == null) {
			if (other.questionPor != null)
				return false;
		} else if (!questionPor.equals(other.questionPor))
			return false;
		if (questionSpa == null) {
			if (other.questionSpa != null)
				return false;
		} else if (!questionSpa.equals(other.questionSpa))
			return false;
		if (questionType == null) {
			if (other.questionType != null)
				return false;
		} else if (!questionType.equals(other.questionType))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "QuestionResponseType [questionId=" + questionId
				+ ", questionSpa=" + questionSpa + ", questionPor="
				+ questionPor + ", phase="
				+ phase + ", section=" + section + ", questionType="
				+ questionType + ", score=" + score + "]";
	}

}
