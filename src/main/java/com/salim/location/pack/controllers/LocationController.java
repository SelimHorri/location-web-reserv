package com.salim.location.pack.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.salim.location.pack.entities.Location;
import com.salim.location.pack.repos.LocationRepository;
import com.salim.location.pack.services.LocationService;
import com.salim.location.pack.util.EmailUtil;
import com.salim.location.pack.util.ReportUtil;

@Controller
public class LocationController {
// Begin Class
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping(value = "/showCreate")
	public String showCreate() {
		return "create-location";
	}
	
	@PostMapping(value = "/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, Model model) {
	// Begin saveLocation()
		
		/*
		if (location == null) {
			
		}
		*/
		
		Location loc = locationService.saveLocation(location);
		String msg = "Location saved with id : " + loc.getId() + "\n";
		model.addAttribute("msg", msg);
		
		final String EMAIL_ADR = "springabcxyzboot@gmail.com";
		final String SUBJ = "Location saved";
		final String MSG_BODY = "Hello Mr "+ EMAIL_ADR.substring(0, EMAIL_ADR.indexOf("@")) +",\nLocation created successfully.\\nThankyou";
		
		emailUtil.sendEmail(EMAIL_ADR, SUBJ, MSG_BODY);
		
		return "create-location";
	// End saveLocation()
	}
	
	@GetMapping(value = "/displayLocations")
	public String displayLocations(Model model) {
	// Begin displayLocations()
		
		List<Location> list = locationService.getAllLocation();
		model.addAttribute("locations", list);
		
		return "display-locations";
	// End displayLocations()
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, Model model) {
	// Begin showUpdate()
		
		Location location = locationService.getLocationById(id);
		model.addAttribute("location", location);
		
		return "edit-location";
	// End showUpdate()
	}
	
	@PostMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, Model model) {
	// Begin updateLocation()
		
		locationService.updateLocation(location);
		/*List<Location> list = locationService.getAllLocation();
		model.addAttribute("locations", list);*/
		
		return "redirect:/displayLocations";
	// End updateLocation()
	}
	
	@GetMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, Model model) {
	// Begin deleteLocation()
		
		Location location = locationService.getLocationById(id);
		locationService.deleteLocation(location);
		
		/*List<Location> list = locationService.getAllLocation();
		model.addAttribute("locations", list);*/
		
		return "redirect:/displayLocations";
	// End deleteLocation()
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
	// Begin generateReport()
		
		String path = servletContext.getRealPath("/");
		
		List<Object[]> dataList = locationRepository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, dataList);
		
		return "report";
	// End generateReport()
	}
	
	// New lines *************************
	
	@ResponseBody
	@RequestMapping("/getMsg")
	public String displayMsg() {
		return "hello my dear";
	}
	
// End Class
}











