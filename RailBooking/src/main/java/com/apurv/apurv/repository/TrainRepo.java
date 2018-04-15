package com.apurv.apurv.repository;

import java.util.List;

import com.apurv.apurv.entities.AvailKey;
import com.apurv.apurv.entities.Train;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends CrudRepository<Train, AvailKey>{
 
	@Async
	@Query("select s from train s where s.source=:source AND s.destination=:destination")
	public List<Train> getByPlace(@Param("source") String source , @Param("destination") String destination);
 
 
 
}
