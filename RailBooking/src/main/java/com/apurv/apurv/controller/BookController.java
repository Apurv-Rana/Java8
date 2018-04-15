package com.apurv.apurv.controller;

import com.apurv.apurv.entities.Passanger;
import com.apurv.apurv.utility.RequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.apurv.apurv.Services.PassangerBookService;

@RestController
public class BookController {
	@Autowired
	PassangerBookService book;

	@PostMapping(value = "ticket/{clas}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Passanger> book(@RequestBody RequestWrapper request, @PathVariable String clas) {

		boolean status = book.book(request.getKey(), request.getPassanger(), clas);

		if (status)
			return new ResponseEntity<Passanger>(request.getPassanger(), HttpStatus.OK);
		else

			return new ResponseEntity<Passanger>(HttpStatus.BAD_REQUEST);
	}
}
