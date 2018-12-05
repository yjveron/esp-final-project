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
	
	public String addVolunteer(String name, String comm, String subCom, String pos) 
	{ 
		Volunteer t = makeVolunteer(name, comm, subCom, pos);
		repo.save(t);
		
		return "You have Created a new Volunteer. Thanks";
	}

	private Volunteer makeVolunteer(String volName, String volComm, String volSCom, String volPos) {
		Volunteer v = new Volunteer();
		v.setVolName(volName);
		v.setVolCom(volComm);
		v.setVolSCom(volSCom);
		v.setVolPos(volPos);
		
		return v;
	}
}
