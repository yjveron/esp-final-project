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
	private string volName;
	
	@Column
	private string volCom;
	
	@Column
	private string volSCom;
	
	@Column
	private string volPos;
	
	@Column
	private Long regId;
	//Foreign key from reg period
}