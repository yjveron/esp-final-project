package app.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import app.components.VolunteerComponent;
import app.entity.Volunteer;
import app.repositories.LiabilityRepository;
import app.repositories.VolunteerRepository;

@Component
@Path("/Volunteer")
public class VolunteerController {

	@Autowired
	VolunteerComponent volService;
	
	@Autowired
	VolunteerRepository volRepo;
	
	//View list of volunteers
	@GET
	@Path("/student")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Volunteer> getSeatCount(@QueryParam("name") String name) throws IOException{
	
		return volService.getVolunteer(name);	
	}
	
	//Create a volunteer entry
	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSeatCount(@QueryParam("name") String name, 
			@QueryParam("comm") String comm, @QueryParam("subCom") String subCom, 
			@QueryParam("pos") String pos) throws IOException{
	
		return volService.addVolunteer(name, comm, subCom, pos);	
	}
	
}
