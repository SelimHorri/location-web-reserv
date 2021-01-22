package com.salim.location.pack.services;

import java.util.List;

import com.salim.location.pack.entities.Location;

public interface LocationService {
// Begin Interface
	
	public abstract Location saveLocation(Location location);
	public abstract Location getLocationById(int id); // for retrieving data before updating
	public abstract Location updateLocation(Location location);
	public abstract void deleteLocation(Location location);
	public abstract List<Location> getAllLocation();
	
// End Interface
}
