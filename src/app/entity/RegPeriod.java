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
	
	@Column Date endDate;
	//add others
}
