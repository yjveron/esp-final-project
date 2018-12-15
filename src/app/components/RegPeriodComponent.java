package app.components;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.RegDay;
import app.entity.RegPeriod;
import app.repositories.RegDayRepository;
import app.repositories.RegPeriodRepository;

@Component
public class RegPeriodComponent {
	// get all reg period that are a part of it
	
	@Autowired
	RegPeriodRepository regPeriodRepo;
	
	@Autowired
	RegDayRepository regDayRepo;
	
	//Create
	public RegPeriod createRegPeriod(String regTitle, Date startDate, Date endDate) {
		RegPeriod rp = new RegPeriod();
		rp.setRegTitle(regTitle);
		rp.setStartDate(startDate);
		rp.setEndDate(endDate);
		regPeriodRepo.save(rp);
	
		return rp;
	}
	//Edit title
	public String changeRegPeriodTitle(String oldRegTitle, String newRegTitle) {
		RegPeriod rp = regPeriodRepo.findByRegTitle(oldRegTitle);
		rp.setRegTitle(newRegTitle);
		regPeriodRepo.save(rp);
		
		return "Changed title from " + oldRegTitle + " to " + newRegTitle;
	}
	
	//edit date
	public String changeRegPeriodDate(String regTitle, Date newStartDate, Date newEndDate) {
		RegPeriod rp = regPeriodRepo.findByRegTitle(regTitle);
		Date oldStartDate = rp.getStartDate();
		Date oldEndDate = rp.getEndDate();
		rp.setStartDate(newStartDate);
		rp.setEndDate(newEndDate);
		regPeriodRepo.save(rp);
		
		return "Changed " + regTitle + "'s " + " date period. " + "| Old Period: " + oldStartDate.toString() + " - " + oldEndDate.toString() + " | New Period: " + rp.getStartDate() + " - " + rp.getEndDate();
	}
	
	
	//Delete
	public String deleteRegPeriod(String regTitle) {
		RegPeriod rp = regPeriodRepo.findByRegTitle(regTitle);
		regPeriodRepo.delete(rp);
		
		return "Deleted Reg Period: " + regTitle;
	}
	
	//View All Reg Periods
	public List<RegPeriod> viewAllRegPeriod() {
		return regPeriodRepo.findAll();
	}
	
	public RegPeriod viewRegPeriod(String title) {
		return regPeriodRepo.findByRegTitle(title);
	}
	
	//View all Reg Days
	public List<RegDay> viewAllRegDaysUnderRegPeriod(String title){
		return regDayRepo.findByRegPeriodId(regPeriodRepo.findByRegTitle(title).getId());
	}
}
