package com.eya.pays.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PaysController {
	@RequestMapping("/myView")
	public String myView()
	{
	return "myView";
	}


}
