package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.entity.Volunteer;
import app.repositories.VolunteerRepository;

public class VolunteerComponent {

	@Autowired
	VolunteerRepository repo;
	
	public List<Volunteer> getVolunteer(String name) 
	{ 
		return repo.findByVolName(name);

	}
}
