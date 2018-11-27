package app.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Component
public class RegDays {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String type;
	
	@Column
	private String desc;
	
	@Column
	private Date day;
	
	@Column
	private int number;
	
	@Column
	private Time time_start;
	
	@Column
	private Time time_end;
	
	//ask sir about Date.java.util, calendar, Date.java.sql
}
