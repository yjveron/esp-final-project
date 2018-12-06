package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class RegPeriod {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long RegId;

	@Column
	private String regTitle;
	
	@Column
	private Date startDate;
	
	@Column 
	private Date endDate;

	public Long getRegId() {
		return RegId;
	}

	public void setRegId(Long regId) {
		RegId = regId;
	}

	public String getRegTitle() {
		return regTitle;
	}

	public void setRegTitle(String regTitle) {
		this.regTitle = regTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	//add others
}
