package app.components;

import java.util.List;

import org.springframework.stereotype.Component;

import app.entity.LiabEntry;
import app.repositories.VolunteerRepository;

@Component
public class LiabEntryComponent {
	
	VolunteerRepository volRepo;
	LiabEntryRepository repo;
	//view Liabs of Volunteer function
	public List<LiabEntry> getVolunteerLiabs(String name) 
	{ 
		//Find later
		Long t = volRepo.findByVolName(name);

		
		return repo.findByVolId(t);

	}
}
