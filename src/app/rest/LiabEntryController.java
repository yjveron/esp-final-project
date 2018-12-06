package app.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import app.components.LiabEntryComponent;
import app.components.VolunteerComponent;
import app.entity.Volunteer;
import app.repositories.LiabEntryRepository;
import app.repositories.VolunteerRepository;

@Component
@Path("/Entries")
public class LiabEntryController {

	@Autowired
	LiabEntryComponent Service;
	
	@Autowired
	LiabEntryRepository Repo;
	
	@GET
	@Path("/{student}")
	@Produces(MediaType.APPLICATION_JSON)
	public Volunteer printVolunteer(@PathParam("student") String name) throws IOException{
	
		return Service.getVolunteerLiabs(name);	
	}
}
