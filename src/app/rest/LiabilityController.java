package app.rest;

import javax.print.attribute.standard.Media;
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

import app.components.LiabilityComponent;
import app.entity.Liability;
import app.repositories.LiabilityRepository;

@Component
@Path("/liability")
public class LiabilityController {

	//[ ] get all liability entries of a liability using liability
	//[ ] convert liability title to liability id to get list of liability entries
	//[ ] check liab entry repository
	//[x] create new liability
	//[x] view liab
	//[x] edit liab
	
	@Autowired
	LiabilityComponent liabService;
	
	@Autowired
	LiabilityRepository liabRepo;
	
	@GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON)
	public Liability viewLiab(@QueryParam("t") String title) {
		Liability l = liabRepo.findByTitle(title);	
		return l;
	}
	
	
	@POST //done
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Liability createLiab(@FormParam("t") String title,
								@FormParam("p") double points) {
		return liabService.createLiab(title, points);
	}
	
	@POST //done
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String editLiab(@FormParam("ot") String oldTitle,
							  @FormParam("nt") String newTitle,
							  @FormParam("np") double newPoints) {

		return liabService.changeLiab(oldTitle, newTitle, newPoints);
		
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteLiab(@FormParam("t") String title) {

		return liabService.eraseLiab(title);
	}
}
