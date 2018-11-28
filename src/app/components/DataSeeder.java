package app.components;

import java.sql.Date;
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
		}
		
	}
	
	//==== SET METHODS ====//
	
	private Liability makeLiability(String title, double points) {
		Liability l = new Liability();
		
		l.setTitle(title);
		l.setPoints(points);
		
		return l;
	}
	
	private LiabEntry makeLiabEntry(Long vol_id, String liab_title, Long day_id, java.util.Date lien_date, String lien_desc) {
		LiabEntry le = new LiabEntry();
		
		Long liab_id = liabRepo.findByTitle(liab_title).getId();
		
		le.setDay_id(day_id);
		le.setLiab_id(liab_id);
		le.setLien_date(lien_date);
		le.setLien_desc(lien_desc);
		le.setVol_id(vol_id);
		
		return le;		
	}
}
