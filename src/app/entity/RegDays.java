package app.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
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
	private Date time_start;
	
	//or gawing time?
	
	@Column
	private Date time_end;

	//ask sir about Date.java.util, calendar, Date.java.sql
}
