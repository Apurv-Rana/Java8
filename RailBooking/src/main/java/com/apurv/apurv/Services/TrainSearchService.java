package com.apurv.apurv.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apurv.apurv.entities.Train;
import com.apurv.apurv.repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apurv.entities.*;
import com.apurv.repository.*;

@Component
public class TrainSearchService {

	
	@Autowired
    TrainRepo trainrepo;

	public List<Train> searchTrain(final String source, final String destination) {
	List<Train> trainlist = new ArrayList();
	    Optional<String> src =  Optional.ofNullable(source);
		Optional<String> dest =Optional.ofNullable(destination);


if(src.isPresent() && dest.isPresent())
trainlist=trainrepo.getByPlace(source, destination);

return trainlist;

	}

}
