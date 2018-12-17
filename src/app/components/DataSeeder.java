package app.components;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.LiabEntry;
import app.entity.Liability;
import app.entity.RegPeriod;
import app.entity.Volunteer;
import app.repositories.LiabEntryRepository;
import app.repositories.LiabilityRepository;
import app.repositories.RegDayRepository;
import app.repositories.RegPeriodRepository;
import app.repositories.VolunteerRepository;

//USED FOR TESTING!!


@Component
public class DataSeeder {
	
	@Autowired
	LiabilityRepository liabRepo;
	
	@Autowired
	RegDayRepository regDayRepo;
	
	@Autowired
	VolunteerRepository volRepo;
	
	@Autowired
	LiabEntryRepository liabEntryRepo;
	
	@Autowired
	RegPeriodRepository regPeriodRepo;
	
	@PostConstruct
	public void init() throws ParseException {
		
		if (liabRepo.count() == 0) {
			Liability liability = new Liability();
			
			liability = makeLiability("Excused Late", 0.25);
			liabRepo.save(liability);
			
			liability = makeLiability("Late", 0.5);
			liabRepo.save(liability);
			
			liability = makeLiability("No ID", 1);
			liabRepo.save(liability);
			
			liability = makeLiability("Absent", 1);
			liabRepo.save(liability);
			
			liability = makeLiability("Excused Absent", 0.5);
			liabRepo.save(liability);
			
			liability = makeLiability("Misdem", 2);
			liabRepo.save(liability);
			
		}

		if (volRepo.count() == 0 )
		{
			Volunteer k1 = makeVolunteer("Kyle", "Logistics", "Membership", "Head");
			volRepo.save(k1);
			Volunteer k11 = makeVolunteer("Ken", "Logistics", "Promos", "Member");
			volRepo.save(k11);
			Volunteer k2 = makeVolunteer("Sab", "Secretariat", "Supplies", "Head");
			volRepo.save(k2);
			Volunteer k3 = makeVolunteer("Veron", "Logistics", "Web", "Head");
			volRepo.save(k3);
			Volunteer k4 = makeVolunteer("Bob", "Secretariat", "Web", "Head");
			volRepo.save(k4);
		}
		
	}
	
	//==== SET METHODS ====//
	
	public Liability makeLiability(String title, double points) 
	{
		Liability l = new Liability();
		
		l.setTitle(title);
		l.setPoints(points);
		
		return l;
	}
	public Volunteer makeVolunteer(String name, String volCom, String volSCom, String volPos) 
	{
		Volunteer v = new Volunteer();
		
		v.setVolName(name);
		v.setVolCom(volCom);
		v.setVolSCom(volSCom);
		v.setVolPos(volPos);
		return v;

	}
	
	public RegPeriod makeRegPeriod(String regTitle, Date startDate, Date endDate) {
		
		RegPeriod rp = new RegPeriod();
		
		rp.setRegTitle(regTitle);
		rp.setStartDate(startDate);
		rp.setEndDate(endDate);
		
		return rp;
	}
}
