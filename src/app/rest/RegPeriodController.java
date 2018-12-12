package app.rest;

import java.util.Date;
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

import app.components.RegPeriodComponent;
import app.entity.RegDay;
import app.entity.RegPeriod;
import app.repositories.RegPeriodRepository;


@Component
@Path("/RegPeriod")
public class RegPeriodController {

	
	@Autowired
	RegPeriodComponent regPeriodService;
	
	@Autowired
	RegPeriodRepository regPeriodRepo;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public RegPeriod createRegPeriod(@FormParam("t") String regTitle,
									 @FormParam("sd") Date startDate,
									 @FormParam("ed") Date endDate) {
		
		return regPeriodService.createRegPeriod(regTitle, startDate, endDate);
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editTitle")
	public String editRegPeriodTitle(@FormParam("ot") String oldTitle,
									 @FormParam("nt") String newTitle) {
		
		return regPeriodService.changeRegPeriodTitle(oldTitle, newTitle);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editPeriod")
	public String editRegPeriodDate(@FormParam("t") String title,
									@FormParam("sd") Date newStartDate,
									@FormParam("ed") Date newEndDate) {
		
		return regPeriodService.changeRegPeriodDate(title, newStartDate, newEndDate);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public String deleteRegPeriod(@FormParam("t") String title) {
		
		return regPeriodService.deleteRegPeriod(title);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/view")
	public List<RegPeriod> viewAllRegPeriod(){
		
		return regPeriodService.viewAllRegPeriod();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{t}")
	public RegPeriod viewRegPeriod(@PathParam("t") String title) {
		
		return regPeriodService.viewRegPeriod(title);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/viewRegDays")
	public List<RegDay> viewAllRegDays(@QueryParam("t") String title){
		
		return regPeriodService.viewAllRegDaysUnderRegPeriod(title);
	}
}
