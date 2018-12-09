package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
public class RegPeriod {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String regTitle;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column 
	@Temporal(TemporalType.DATE)
	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "RegPeriod [id=" + id + ", regTitle=" + regTitle + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	
	
}
