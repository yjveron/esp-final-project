package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
public class RegDay {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private Long regId;
	
	@Column
	private String dayType;
	
	@Column
	private String dayDesc;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dayDate;
	
	@Column
	private int dayNumber;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStart;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeEnd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public String getDayType() {
		return dayType;
	}

	public void setDayType(String dayType) {
		this.dayType = dayType;
	}

	public String getDayDesc() {
		return dayDesc;
	}

	public void setDayDesc(String dayDesc) {
		this.dayDesc = dayDesc;
	}

	public Date getDayDate() {
		return dayDate;
	}

	public void setDayDate(Date dayDate) {
		this.dayDate = dayDate;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Override
	public String toString() {
		return "RegDay [id=" + id + ", regId=" + regId + ", dayType=" + dayType + ", dayDesc=" + dayDesc + ", dayDate="
				+ dayDate + ", dayNumber=" + dayNumber + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + "]";
	}

	
	
}
