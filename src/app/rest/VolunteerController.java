package app.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import app.components.VolunteerComponent;
import app.entity.Volunteer;
import app.repositories.LiabilityRepository;
import app.repositories.VolunteerRepository;

public class VolunteerController {

	@Autowired
	VolunteerComponent volService;
	
	@Autowired
	VolunteerRepository volRepo;
	
	@GET
	@Path("/volunteer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Volunteer> getSeatCount(@QueryParam("name") String name) throws IOException{

		
		return volService.getVolunteer(name);
		
		
	}
	
	
}
