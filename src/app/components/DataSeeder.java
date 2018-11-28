package app.components;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.LiabEntry;
import app.entity.Liability;
import app.repositories.LiabEntryRepository;
import app.repositories.LiabilityRepository;

//USED FOR TESTING!!


@Component
public class DataSeeder {
	
	//==== AUTOWIRED CONTENT ====//
	@Autowired
	Liability liab;
	
	@Autowired
	LiabilityRepository liabRepo;
	
	@Autowired
	LiabEntry liabEntry;
	
	@Autowired
	LiabEntryRepository liabEntryRepo;
	
	
	//==== INITIALIZATION ====//
	
	@PostConstruct
	public void init() throws ParseException {
		if (liabRepo.count() == 0) {
			Liability liability = new Liability();
			
			liability = makeLiability("Absent", 3);
			liabRepo.save(liability);
			
			liability = makeLiability("Late", 1.5);
			liabRepo.save(liability);
			
			liability = makeLiability("No ID", 1);
			liabRepo.save(liability);
			
		}
		
		if (liabEntryRepo.count() == 0) {
			LiabEntry liabEntry = new LiabEntry();
			DateFormat df = new SimpleDateFormat("yyyy-dd-mm"); 
			
			//PROBLEM WITH DATE ONCE INPUT IN SQL
			liabEntry = makeLiabEntry((long) 1, "Absent", (long) 1, (java.util.Date) df.parse("2018-11-21"), "Hi");
			liabEntryRepo.save(liabEntry);
			
			liabEntry = makeLiabEntry((long) 1, "Late", (long) 1, (java.util.Date) df.parse("2018-11-21"), "Hello");
			liabEntryRepo.save(liabEntry);
		}
		
	}
	
	//==== SET METHODS ====//
	
	private Liability makeLiability(String title, double points) {
		Liability l = new Liability();
		
		l.setTitle(title);
		l.setPoints(points);
		
		return l;
	}
	
	private LiabEntry makeLiabEntry(Long volId, String liabTitle, Long dayId, java.util.Date lienDate, String lienDesc) {
		LiabEntry le = new LiabEntry();
		
		Long liabId = liabRepo.findByTitle(liabTitle).getId();
		
		le.setDayId(dayId);
		le.setLiabId(liabId);
		le.setLienDate(lienDate);
		le.setLienDesc(lienDesc);
		le.setVolId(volId);
		
		return le;		
	}
}
