package com.eya.pays.restcontrollers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eya.pays.entities.Classification;
import com.eya.pays.repos.ClassificationRepository;
@RestController
@RequestMapping("/api/class")
@CrossOrigin("*")
public class ClassificationRESTController {






	@Autowired
	ClassificationRepository classRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Classification> getAllMarques()
	{
	return classRepository.findAll();
	}
	@RequestMapping(value="/class/{id}",method = RequestMethod.GET)
	public Classification getClassificationById(@PathVariable("id") Long id) {
		return classRepository.findById(id).get();
	}
	
	
	
}
