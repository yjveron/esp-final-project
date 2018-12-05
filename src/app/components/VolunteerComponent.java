package app.components;

import org.springframework.beans.factory.annotation.Autowired;

import app.entity.Volunteer;
import app.repositories.VolunteerRepository;

public class VolunteerComponent {

	@Autowired
	VolunteerRepository repo;
	
	public Volunteer getVolunteer(String name) 
	{
		//return " dfs ";
	}
}
