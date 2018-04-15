package com.apurv.apurv.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.apurv.apurv.entities.AvailKey;
import com.apurv.apurv.entities.Available;

import com.apurv.apurv.repository.AvailRepo;

@Service
public class TrainAvailableService {

	@Autowired
	AvailRepo availrepo;

	public Optional<Available> getAvailable(final AvailKey key) {
	    Optional<AvailKey> availKey = Optional.ofNullable(key);
	
	    Optional<Available> available = Optional.empty();
	    if(availKey.isPresent())
		available = availrepo.findById(key);
	   
	    return available ;
	}

}
