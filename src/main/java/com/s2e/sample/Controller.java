package com.s2e.sample;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.Studente;

@RestController
@RequestMapping("/Controller")
public class Controller {

	private static final Logger log = Logger.getLogger(Controller.class.getName());

	@RequestMapping(value = "/studente", method = RequestMethod.GET)
	@ResponseBody
	public Studente getSudente() {
		Studente a = new Studente();
		return a;
	}

	@RequestMapping(value = "/cpu", method = RequestMethod.GET)
	@ResponseBody
	// restituisce la lista dei numeri primi fino a x milioni
	public void calcolaNumeriPrimi() {

		log.info("test lettura cpu");
	}

	@RequestMapping(value = "/io", method = RequestMethod.GET)
	@ResponseBody
	// restituisce un grosso messaggio a partire da quello di input
	public String ritornaMexIO(String message) {

		log.info("Test trasmissione i/o");

		return null;
	}

	@RequestMapping(value = "/ram", method = RequestMethod.GET)
	@ResponseBody
	// restituisce un grosso vettore pieno e poi vuoto
	public String ritornaVettore() {
		log.info("Test lettura ram");
		return null;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	@ResponseBody
	//genera errore causale
	public HttpStatus generaErrore() {

		// il 5% dei casi ritorna errore altrimento OK
		Double prob = Math.random();
		log.info("probabilita rilevata " + prob.doubleValue());
		if (prob < 0.05) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		} else {
			return HttpStatus.OK;
		}

	}

}