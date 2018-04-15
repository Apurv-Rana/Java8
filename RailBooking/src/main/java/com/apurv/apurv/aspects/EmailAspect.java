package com.apurv.apurv.aspects;

import javax.servlet.http.HttpServletRequest;

import com.apurv.apurv.entities.Passanger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import com.apurv.controller.*;
import com.apurv.apurv.utility.SendMail;
@Aspect
@Component
public class EmailAspect {

	
	@After("execution(* com.apurv.controller.BookCont.book(..))")
	public void sendEmail(JoinPoint joinpoint)
	{
		Object[] a = joinpoint.getArgs();
	
		
		HttpServletRequest request = (HttpServletRequest) a[0];
		String email = request.getParameter("email");
	Passanger passanger =(Passanger) request.getAttribute("seat");
	String msg ="<html>\r\n" + 
			"<head>\r\n" + 
			"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
			"<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n" + 
			"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n" + 
			"</head>\r\n" + 
			"<body >\r\n" + 
			"</body>\r\n" + 
			"<div class=\"card\" style=\"width: 18rem; border:2px solid black; padding:10px; box-shadow: 5px 10px #888888; \">\r\n" + 
			"  <img src=\"https://images7.alphacoders.com/661/661783.jpg\" class=\"card-img-top\" style=\"width:100%;\"alt=\"...\">\r\n" + 
			"  <div class=\"card-body\">\r\n" + 
			"    <h2 class=\"card-title\"> train Booking Detail</h2><hr/>\r\n" + 
			"    <p class=\"card-text\">passanger name :"+passanger.getKey().getName()+"</p>\r\n" + 
			" <p class=\"card-text\">date :"+passanger.getKey().getDate()+" </p>\r\n" + 
			" <p class=\"card-text\">train no: "+passanger.getKey().getTrainno()+"</p>\r\n" + 
			" <p class=\"card-text\">seat : "+passanger.getSeatnumber()+" </p>\r\n" + 
			"    &copy; design and developed by Apurv \r\n" + 
			"  </div>\r\n" + 
			"</div>\r\n" + 
			"</html>";
	SendMail.send(email,"Train Booking",msg,"hotelcolosseumserver@gmail.com","colosseum");
	}
}
