package app.components;

import java.util.List;

import org.springframework.stereotype.Component;

import app.entity.LiabEntry;
import app.entity.Volunteer;
import app.repositories.LiabEntryRepository;
import app.repositories.VolunteerRepository;

@Component
public class LiabEntryComponent {
	
	VolunteerRepository volRepo;
	LiabEntryRepository repo;
	
	//view Liabs of Volunteer function
	public List<LiabEntry> getVolunteerLiabs(String name) 
	{ 
		//Find later
		Volunteer t = volRepo.findByVolName(name);
		
		return repo.findByVolId(t.getVolId());

	}
}
