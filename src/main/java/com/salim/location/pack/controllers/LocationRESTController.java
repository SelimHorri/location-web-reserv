package com.salim.location.pack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salim.location.pack.entities.Location;
import com.salim.location.pack.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {
// Begin Class
	
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping("/getLocations")
	public List<Location> getLocations() {
		return locationRepository.findAll();
	}
	
	@PostMapping("/createLocation")
	public Location createLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@PutMapping("/updateLocation")
	public Location updateLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@DeleteMapping("/deleteLocation/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationRepository.deleteById(id);
	}
	
	@GetMapping("/getLocation/{id}")
	public Location getLocation(@PathVariable("id") int id) {
		return locationRepository.findById(id).get();
	}
	
	// New lines *********************************************
	
	/*@ResponseBody
	@GetMapping(value = "/getLocationByState", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })*/
	@GetMapping(value = "/getLocationByState", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Object[]> extractLocationsByState() {
		return locationRepository.getLocationsByParam("low");
	}
	
// End Class
}













