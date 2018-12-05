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
	
	@Column
	private Long regId;
	//Foreign key from registration period
}