package com.apurv.apurv.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apurv.apurv.entities.Passanger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookCont {

	@RequestMapping("/tick")
	public ModelAndView book(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = null;
		Map map = new HashMap();

		RestTemplate restTemplate = new RestTemplate();
		String classs = request.getParameter("clas");

		String url = "http://localhost:8085/ticket/" + classs;
		String date = request.getParameter("date");
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String requestJson = "{\"key\": {\"date\": \"" + date + "\",\"trainno\": " + number
				+ "},\"passanger\": {\"key\": {\"name\": \"" + name + "\",\"date\": \"" + date + "\",\"trainno\": "
				+ number + "},\"seatnumber\": \"-\"}}";
		

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		Passanger passanger = restTemplate.postForObject(url, entity, Passanger.class);
		passanger.getKey().setName(request.getParameter("name"));
		map.put("passanger", passanger);

	

		model = new ModelAndView("ticket", map);
		Passanger seat = passanger;
		request.setAttribute("seat", seat);
		return model;

	}

}
