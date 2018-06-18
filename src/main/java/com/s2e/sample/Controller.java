package com.s2e.sample;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.Studente;

@RestController
@RequestMapping("/Controller")
public class Controller {

    
	@RequestMapping(value = "/studente", method = RequestMethod.GET)
	@ResponseBody
    public Studente getSudente() {
      Studente a = new Studente();
      return a;
    }
	
	
	
}