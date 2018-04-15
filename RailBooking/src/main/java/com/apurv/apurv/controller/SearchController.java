package com.apurv.apurv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apurv.apurv.Services.TrainSearchService;
import com.apurv.apurv.entities.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
	@Autowired
    TrainSearchService trainSearch;

	@GetMapping(value = "search/{source}/{destination}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map> getListOfTrain(@PathVariable String source, @PathVariable String destination) {

		List<Train> trainList = trainSearch.searchTrain(source, destination);

		Map map = new HashMap();
		map.put("train", trainList);

		return new ResponseEntity<Map>(map, HttpStatus.OK);

	}

}
