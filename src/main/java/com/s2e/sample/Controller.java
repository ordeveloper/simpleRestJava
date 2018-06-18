package com.s2e.sample;


import org.springframework.http.HttpStatus;
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
	
	@RequestMapping(value = "/cpu", method = RequestMethod.GET)
	@ResponseBody
    public void calcolaNumeriPrimi() {
       // restituisce la lista dei numeri primi fino a x milioni
    }
	
	@RequestMapping(value = "/io", method = RequestMethod.GET)
	@ResponseBody
    public String ritornaMexIO(String message) {
       // restituisce un grosso messaggio a partire da quello di input
		return null;
    }
	
	@RequestMapping(value = "/ram", method = RequestMethod.GET)
	@ResponseBody
    public String ritornaVettore() {
       // restituisce un grosso vettore pieno e poi vuoto
		return null;
    }
	
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	@ResponseBody
    public HttpStatus generaErrore() {
       
		// il 5% dei casi ritorna errore altrimento OK
		Double prob = Math.random();
		if (prob < 0.05) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}else {
			return HttpStatus.OK;
		}
		
		
    }
	
}