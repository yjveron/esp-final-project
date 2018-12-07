package app.components;

import java.util.List;

import org.springframework.stereotype.Component;

import app.entity.LiabEntry;
import app.entity.Liability;
import app.entity.Volunteer;
import app.repositories.LiabEntryRepository;
import app.repositories.LiabilityRepository;
import app.repositories.VolunteerRepository;

@Component
public class LiabEntryComponent {
	
	VolunteerRepository volRepo;
	LiabEntryRepository repo;
	LiabilityRepository liabRepo;
	//view Liabs of Volunteer function
	public List<LiabEntry> getVolunteerLiabs(String name) 
	{ 
		Volunteer t = volRepo.findByVolName(name);
		
		return repo.findByVolId(t.getVolId());

	}
	
	public Int getVolunteerpoints(String name) 
	{ 
		Volunteer t = volRepo.findByVolName(name);
		
		return repo.findByVolId(t.getVolId());

	}
	//View All entries
	public List<LiabEntry> getVolunteer() 
	{ 
		return repo.findAll();

	}
	
	//Add function
	public String addEntry(String name, String title) 
	{ 
		
		Volunteer t = volRepo.findByVolName(name);
		Liability y = liabRepo.findByTitle(title);
		LiabEntry a = new LiabEntry();
		a.setLiabId(y.getId());
		a.setVolId(t.getVolId());
		repo.save(a);
		
		return "You have given " + name + " a " + title + "liability. Thanks";
	}
	
	//Edit function
	public LiabEntry editEntry(String name, Long id, String title) 
	{ 
		LiabEntry v = repo.findById(id);
		Volunteer t = volRepo.findByVolName(name);
		Liability y = liabRepo.findByTitle(title);
		v.setVolId(t.getVolId());
		v.setLiabId(y.getId());
		return repo.save(v);
		
	}

	//Delete
	public String delEntry(Long entryId) {
		LiabEntry x = repo.findById(entryId);
		repo.delete(x);
		return "You have deleted entry #" + entryId + " Thank you";
	}
}
