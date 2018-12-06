package app.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.RegPeriodComponent;
import app.repositories.RegPeriodRepository;


@Component
@Path("/RegPeriod")
public class RegPeriodController {

	
	@Autowired
	RegPeriodComponent regPeriodService;
	
	@Autowired
	RegPeriodRepository regPeriodRepo;
	
	
}
