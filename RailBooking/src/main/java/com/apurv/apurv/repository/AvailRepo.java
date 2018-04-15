package com.apurv.apurv.repository;

import com.apurv.apurv.entities.AvailKey;
import com.apurv.apurv.entities.Available;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apurv.entities.*;
@Repository
public interface AvailRepo extends CrudRepository<Available, AvailKey> {
	
	
	

}
