package com.salim.location.pack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salim.location.pack.entities.Location;
import com.salim.location.pack.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
// Begin Class
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}
	
	@Override
	public Location getLocationById(int id) {
		Location loc = locationRepository.findById(id).get();
		return loc;
	}
	
	@Override
	public Location updateLocation(Location location) {
		return locationRepository.save(location);
	}
	
	@Override
	public void deleteLocation(Location location) {
		locationRepository.delete(location);
	}
	
	@Override
	public List<Location> getAllLocation() {
		return locationRepository.findAll();
	}
	
	public LocationRepository getLocationRepository() {
		return locationRepository;
	}
	
	public void setLocationRepository(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
// End Class
}














