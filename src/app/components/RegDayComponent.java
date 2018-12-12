package app.components;

import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.LiabEntry;
import app.entity.RegDay;
import app.repositories.RegDayRepository;
import app.repositories.RegPeriodRepository;

@Component
public class RegDayComponent 
{
	// Get which reg period it's a part off
	
	@Autowired
	RegDayRepository regDayRepo;
	
	@Autowired
	RegPeriodRepository regPeriodRepo;
	
	//Create
	public RegDay createRegDay(String regTitle, String dayType, String dayDesc, int dayNumber, Date timeStart, Date timeEnd) 
	{
		//Put to component
		RegDay r = new RegDay();
		r.setRegId(regPeriodRepo.findByRegTitle(regTitle).getId());
		r.setDayType(dayType);
		r.setDayDesc(dayDesc);
		r.setDayNumber(dayNumber);
		r.setTimeStart(timeStart);
		r.setTimeEnd(timeEnd);
		regDayRepo.save(r);
		
		//https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/temporal-annotation.html
		
		return r;
	}
	
	//View all reg days
	public List<RegDay> getAll() 
	{

		return regDayRepo.findAll();
	}

	
	//Edit
	public String editRegDay(Long id, String dayType, String dayDesc, int dayNumber, Date timeStart, Date timeEnd) 
	{
		RegDay r = regDayRepo.findBySpecRegDay(id);
		r.setDayType(dayType);
		r.setDayDesc(dayDesc);
		r.setDayNumber(dayNumber);
		r.setTimeStart(timeStart);
		r.setTimeEnd(timeEnd);
		return "You have edited the regday. Thank you";
	}
	
	//Delete
	public String delEntry(Long id) {
		RegDay x = regDayRepo.findBySpecRegDay(id);
		regDayRepo.delete(x);
		return "You have deleted " + id + " Thank you";
	}

	public RegDay viewSpecEntry(Long entryId) {
		return regDayRepo.findBySpecRegDay(entryId);
	}
}
