package com.salim.location.pack.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salim.location.pack.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
// Begin Interface
	
	@Query("SELECT type,COUNT(type) FROM Location GROUP BY type")
	public abstract List<Object[]> findTypeAndTypeCount(); // method for generating report
	
	@Query("FROM Location WHERE type LIKE :myType")
	public abstract List<Object[]> getLocationsByParam(@Param("myType") String type);
	
// End Interface
}
