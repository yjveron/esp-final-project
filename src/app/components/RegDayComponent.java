package app.components;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.RegDay;
import app.repositories.RegDayRepository;
import app.repositories.RegPeriodRepository;

@Component
public class RegDayComponent {
	// Get which reg period it's a part off
	
	@Autowired
	RegDayRepository regDayRepo;
	
	@Autowired
	RegPeriodRepository regPeriodRepo;
	
	public RegDay createRegDay(String regTitle, String dayType, String dayDesc, int dayNumber, Date timeStart, Date timeEnd) {
		//Put to component
		RegDay r = new RegDay();
		r.setRegId(regPeriodRepo.findByRegTitle(regTitle).getId());
		r.setDayType(dayType);
		r.setDayDesc(dayDesc);
		r.setDayNumber(dayNumber);
		r.setTimeStart(timeStart);
		r.setTimeEnd(timeEnd);
		
		//https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/temporal-annotation.html
		
		return r;
	}
	
//	public RegDay editRegDay(Long regId, String dayType, String dayDesc, int dayNumber, Date timeStart, Date timeEnd) {
//		RegDay r =
//	}
}
