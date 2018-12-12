package app.rest;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.RegDayComponent;
import app.entity.RegDay;
import app.repositories.RegDayRepository;

@Component
@Path("/RegDay")
public class RegDayController {
	
	@Autowired
	RegDayComponent regDayService;
	
	@Autowired
	RegDayRepository regDayRepo;
	
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
	
}
