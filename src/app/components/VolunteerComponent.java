package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.LiabEntry;
import app.entity.Volunteer;
import app.repositories.LiabEntryRepository;
import app.repositories.VolunteerRepository;

@Component
public class VolunteerComponent {

	@Autowired
	VolunteerRepository repo;
	
	@Autowired
	LiabEntryRepository lerepo;
	
	//View All Volunteers function
	public List<Volunteer> getVolunteer() 
	{ 
		return repo.findAll();

	}
	
	//view Specific Volunteer function
	public Volunteer getSpecVolunteer(String name) 
	{ 
		return repo.findByVolName(name);
	}
	
	//Add function
	public String addVolunteer(String name, String comm, String subCom, String pos) 
	{ 
		if (name == repo.findByVolName(name).getVolName()) {
			return "That volunteer exists";
		}
		else {
			Volunteer t = makeVolunteer(name, comm, subCom, pos);
			repo.save(t);
			
			return "You have Created a new Volunteer. Thanks";
		}
	}
	
	//Edit function
	public String editVolunteer(String name, String comm, String subCom, String pos) 
	{ 
		Volunteer t = updateVolunteer(name, comm, subCom, pos);
		repo.save(t);
		
		return "You have updated " + name + "'s information Thanks";
	}
	
	//Delete function
	public String delVolunteer(String name) 
	{ 
		
		Volunteer x = repo.findByVolName(name);
		repo.delete(x);
		return "You have Deleted " + name + ". Thanks";
	}

	//Internal add function
	private Volunteer makeVolunteer(String volName, String volComm, String volSCom, String volPos) {
		Volunteer v = new Volunteer();
		v.setVolName(volName);
		v.setVolCom(volComm);
		v.setVolSCom(volSCom);
		v.setVolPos(volPos);
		
		return v;
	}
	
	//Internal Edit Function
	private Volunteer updateVolunteer(String volName, String volComm, String volSCom, String volPos) {
		Volunteer v = repo.findByVolName(volName);
		v.setVolCom(volComm);
		v.setVolSCom(volSCom);
		v.setVolPos(volPos);
		return repo.save(v);
	}
}
