package app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class LiabEntry {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private Long volId;
	
	@Column
	private Long liabId;
	
	@Column
	private Long dayId;
	
	@Column
	private java.util.Date lienDate;
	
	@Column
	private String lienDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVolId() {
		return volId;
	}

	public void setVolId(Long volId) {
		this.volId = volId;
	}

	public Long getLiabId() {
		return liabId;
	}

	public void setLiabId(Long liabId) {
		this.liabId = liabId;
	}

	public Long getDayId() {
		return dayId;
	}

	public void setDayId(Long dayId) {
		this.dayId = dayId;
	}

	public java.util.Date getLienDate() {
		return lienDate;
	}

	public void setLienDate(java.util.Date lienDate) {
		this.lienDate = lienDate;
	}

	public String getLienDesc() {
		return lienDesc;
	}

	public void setLienDesc(String lienDesc) {
		this.lienDesc = lienDesc;
	}

	@Override
	public String toString() {
		return "LiabEntry [id=" + id + ", volId=" + volId + ", liabId=" + liabId + ", dayId=" + dayId + ", lienDate="
				+ lienDate + ", lienDesc=" + lienDesc + "]";
	}

}
