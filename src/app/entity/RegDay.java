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
public class RegDay {
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getTime_start() {
		return time_start;
	}

	public void setTime_start(Date time_start) {
		this.time_start = time_start;
	}

	public Date getTime_end() {
		return time_end;
	}

	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}

	@Override
	public String toString() {
		return "RegDay [id=" + id + ", type=" + type + ", desc=" + desc + ", day=" + day + ", number=" + number
				+ ", time_start=" + time_start + ", time_end=" + time_end + "]";
	}
	
	
}
