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
	private Long vol_id;
	
	@Column
	private Long liab_id;
	
	@Column
	private Long day_id;
	
	@Column
	private Date lien_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVol_id() {
		return vol_id;
	}

	public void setVol_id(Long vol_id) {
		this.vol_id = vol_id;
	}

	public Long getLiab_id() {
		return liab_id;
	}

	public void setLiab_id(Long liab_id) {
		this.liab_id = liab_id;
	}

	public Long getDay_id() {
		return day_id;
	}

	public void setDay_id(Long day_id) {
		this.day_id = day_id;
	}

	public Date getLien_date() {
		return lien_date;
	}

	public void setLien_date(Date lien_date) {
		this.lien_date = lien_date;
	}

	@Override
	public String toString() {
		return "LiabEntry [id=" + id + ", vol_id=" + vol_id + ", liab_id=" + liab_id + ", day_id=" + day_id
				+ ", lien_date=" + lien_date + "]";
	}
	
}
