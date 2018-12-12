package app.rest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.RegDayComponent;
import app.entity.LiabEntry;
import app.entity.RegDay;
import app.repositories.RegDayRepository;

@Component
@Path("/RegDay")
public class RegDayController {
	
	@Autowired
	RegDayComponent regDayService;
	
	@Autowired
	RegDayRepository regDayRepo;
	
	
	//Create Reg Day
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RegDay createRegDay(@FormParam("regTitle") String regTitle,
							   @FormParam("type") String dayType,
							   @FormParam("desc") String dayDesc,
							   @FormParam("number") int dayNumber,
							   @FormParam("start") Date timeStart,
							   @FormParam("end") Date timeEnd) {
		
		return regDayService.createRegDay(regTitle, dayType, dayDesc, dayNumber, timeStart, timeEnd);
		
	}
	
	//View
	@GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RegDay> printAllEntries() throws IOException{
	
		return regDayService.getAll();	
	}
	
	
	//Edit regday
	@GET
	@Path("/edit")
	@Produces(MediaType.APPLICATION_JSON)
	public String editEntry(@QueryParam("id") Long id,
			   @QueryParam("type") String dayType,
			   @QueryParam("desc") String dayDesc,
			   @QueryParam("number") int dayNumber,
			   @QueryParam("start") Date timeStart,
			   @QueryParam("end") Date timeEnd) throws IOException{
	
		return regDayService.editRegDay(id, dayType, 
				dayDesc, dayNumber, 
				timeStart, timeEnd);	
	}
	
	//Delete Entry
	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String delVolunteerEntry(@QueryParam("entryId") Long entryId) throws IOException{
	
		return regDayService.delEntry(entryId);	
	}
	
	//View Specific Day
	@GET
	@Path("/viewSpecific")
	@Produces(MediaType.APPLICATION_JSON)
	public RegDay viewEntry(@QueryParam("entryId") Long entryId) throws IOException{
	
		return regDayService.viewSpecEntry(entryId);	
	}
}
