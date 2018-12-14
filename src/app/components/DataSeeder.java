package app.components;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.LiabEntry;
import app.entity.Liability;
import app.entity.Volunteer;
import app.repositories.LiabEntryRepository;
import app.repositories.LiabilityRepository;
import app.repositories.RegDayRepository;

//USED FOR TESTING!!


@Component
public class DataSeeder {
	
	@Autowired
	LiabilityRepository liabRepo;
	
	@Autowired
	RegDayRepository regDayRepo;
	
	@Autowired
	Volunteer volRepo;
	
	@Autowired
	LiabEntryRepository liabEntryRepo;
	
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
		
//		if (liabEntryRepo.count() == 0) {
//			LiabEntry liabEntry = new LiabEntry();
//			DateFormat df = new SimpleDateFormat("yyyy-dd-mm"); 
//			
//			//PROBLEM WITH DATE ONCE INPUT IN SQL
//			liabEntry = makeLiabEntry((long) 1, "Absent", (long) 1, (java.util.Date) df.parse("2018-11-21"), "Hi");
//			liabEntryRepo.save(liabEntry);
//			
//			liabEntry = makeLiabEntry((long) 1, "Late", (long) 1, (java.util.Date) df.parse("2018-11-21"), "Hello");
//			liabEntryRepo.save(liabEntry);
//		}
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
	
	private Liability makeLiability(String title, double points) 
	{
		Liability l = new Liability();
		
		l.setTitle(title);
		l.setPoints(points);
		
		return l;
	}
	private Volunteer makeVolunteer(String name, String volCom, String volSCom, String volPos) 
	{
		Volunteer v = new Volunteer();
		
		v.setVolName(name);
		v.setVolCom(volCom);
		v.setVolSCom(volSCom);
		v.setVolPos(volPos);
		return v;

	}
	
	
/*	private LiabEntry makeLiabEntry(Long volId, String liabTitle, Long dayId, java.util.Date lienDate, String lienDesc) {
		LiabEntry le = new LiabEntry();
		
		Long liabId = liabRepo.findByTitle(liabTitle).getId();
		
		le.setDayId(dayId);
		le.setLiabId(liabId);
		le.setLienDate(lienDate);
		le.setLienDesc(lienDesc);
		le.setVolId(volId);
		
		return le;		
	}*/
}
