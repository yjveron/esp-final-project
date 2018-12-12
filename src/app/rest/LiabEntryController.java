package app.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.LiabEntryComponent;
import app.components.VolunteerComponent;
import app.entity.LiabEntry;
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
	
	//View all liabilities specific to student
	@GET
	@Path("/{student}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LiabEntry> printVolunteer(@PathParam("student") String name) throws IOException{
		return Service.getVolunteerLiabs(name);	
	}
	
	//View all liabilities entered
	@GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LiabEntry> printAllEntries() throws IOException{
	
		return Service.getAllEntries();	
	}
	
	//create a liability entry 
	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public String createVolunteerEntry(@QueryParam("name") String name, 
			@QueryParam("liability") String liability) throws IOException{
	
		return Service.addEntry(name, liability);	
	}
	
	//Edit liability entry
	@GET
	@Path("/edit")
	@Produces(MediaType.APPLICATION_JSON)
	public LiabEntry createVolunteerEntry(@QueryParam("name") String name, 
			@QueryParam("liability") String liability, 
			@QueryParam("entryId") Long entryId) throws IOException{
	
		return Service.editEntry(name, entryId, liability);	
	}
	
	//Delete a volunteer entry
	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String delVolunteerEntry(@QueryParam("entryId") Long entryId) throws IOException{
	
		return Service.delEntry(entryId);	
	}
}
