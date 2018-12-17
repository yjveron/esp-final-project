package app.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	//View All Volunteers
	@GET
	@Path("/students")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Volunteer> printAllVolunteer() throws IOException{
	
		return volService.getVolunteer();	
	}
	
	//View Specific Volunteer
	@GET
	@Path("/{student}")
	@Produces(MediaType.APPLICATION_JSON)
	public Volunteer printVolunteer(@PathParam("student") String name) throws IOException{
	
		return volService.getSpecVolunteer(name);	
	}
	
	//Create a volunteer entry
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String createVolunteerEntry(@FormParam("name") String name, 
			@FormParam("comm") String comm, @FormParam("subCom") String subCom, 
			@FormParam("pos") String pos) throws IOException{
	
		return volService.addVolunteer(name, comm, subCom, pos);	
	}
	
	//Update a volunteer entry
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String delVolunteerEntry(@FormParam("name") String name, 
			@FormParam("comm") String comm, @FormParam("subCom") String subCom, 
			@FormParam("pos") String pos) throws IOException{
	
		return volService.editVolunteer(name, comm, subCom, pos);	
	}
	
	//Delete a volunteer entry
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String delVolunteerEntry(@FormParam("name") String name) throws IOException{
	
		return volService.delVolunteer(name);	
	}
	
	//Print Liability points of volunteer "Link only in 
	//volunteer component" but link to repositories of entry/ liab / and volunteer
}
