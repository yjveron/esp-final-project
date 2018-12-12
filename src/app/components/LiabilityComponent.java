package app.components;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Liability;
import app.repositories.LiabEntryRepository;
import app.repositories.LiabilityRepository;
import app.repositories.VolunteerRepository;

@Component
public class LiabilityComponent {
	
	@Autowired
	LiabilityRepository liabRepo;
	
	@Autowired
	LiabEntryRepository liabEntryRepo;
	
	@Autowired
	VolunteerRepository volRepo;
	
	//Create
	public Liability createLiab(String title, double points) {
		Liability l = new Liability();
		l.setTitle(title);
		l.setPoints(points);
		liabRepo.save(l);
		return l;
	}
	
	//Update
	public String changeLiab(String oldTitle, String newTitle, double newPoints) {
		Liability l = liabRepo.findByTitle(oldTitle);
		String oldT = l.getTitle();
		double oldP = l.getPoints();
		
		l.setTitle(newTitle);
		l.setPoints(newPoints);
		liabRepo.save(l);
		
		return "Old Title: " + oldT + " | " + "New Title: " + l.getTitle() + " | " + "Old Points: " + oldP + " | " + "New Points: " + l.getPoints();
	}
	
	//Delete
	public String eraseLiab(String title) {
		Liability l = liabRepo.findByTitle(title);
		liabRepo.delete(l);
		
		if (liabRepo.findByTitle(title) == null) {
			return l.getTitle() + " successfully deleted.";
		}
		
		else {
			return "Unable to delete " + l.getTitle();
		}
	}
}
