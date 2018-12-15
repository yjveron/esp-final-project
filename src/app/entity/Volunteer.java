package app.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
public class Volunteer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long volId;
	
	@Column
	private String volName;
	
	@Column
	private String volCom;
	
	@Column
	private String volSCom;
	
	@Column
	private String volPos;

	public Long getVolId() {
		return volId;
	}

	public void setVolId(Long volId) {
		this.volId = volId;
	}

	public String getVolName() {
		return volName;
	}

	public void setVolName(String volName) {
		this.volName = volName;
	}

	public String getVolCom() {
		return volCom;
	}

	public void setVolCom(String volCom) {
		this.volCom = volCom;
	}

	public String getVolSCom() {
		return volSCom;
	}

	public void setVolSCom(String volSCom) {
		this.volSCom = volSCom;
	}

	public String getVolPos() {
		return volPos;
	}

	public void setVolPos(String volPos) {
		this.volPos = volPos;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void save(Volunteer k) {
		// TODO Auto-generated method stub
		
	}
	
	
}