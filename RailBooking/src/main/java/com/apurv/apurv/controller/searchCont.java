package com.apurv.apurv.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchCont {

	@Autowired
	RestTemplate template;

	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response)

	{
		ModelAndView model = null;
		System.out.println("hello all ");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		Map map = template.getForObject("http://localhost:8085/search/" + source + "/" + destination, Map.class);

		System.out.println(map);

		model = new ModelAndView("search", map);

		return model;

	}
}
