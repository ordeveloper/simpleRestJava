package com.s2e.sample;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void calcolaNumeriPrimi(@RequestParam(name="n", required=false, defaultValue="1000000") long n) {
		ArrayList<Integer> setPrimi = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			setPrimi.add(i);
		}
		
		for (Integer i : setPrimi) {
			for (int k = 2*i; k <= n; k += i) {
				setPrimi.remove(new Integer(k));
			}
		}
		log.info("test lettura cpu");
	}

	@RequestMapping(value = "/io", method = RequestMethod.GET)
	@ResponseBody
	// restituisce un grosso messaggio a partire da quello di input
	public String ritornaMexIO(@RequestParam(name="mex", required=false, defaultValue="Hello Test World") String message) {
		String newMessage = message  + " AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
				+ "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"
				+ "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC";
		
		
		log.info("Test trasmissione i/o");
		return newMessage;

	}

	@RequestMapping(value = "/ram", method = RequestMethod.GET)
	@ResponseBody
	// restituisce un grosso vettore pieno e poi vuoto
	public void ritornaVettore(@RequestParam(name="n", required=false, defaultValue="1000") long n) {
		
		ArrayList<Character> vettore = new ArrayList<Character>();
		
		for (int i = 0; i < n ; i++) {
			vettore.add('a');
		}
		
		for (Character i : vettore) {
			vettore.remove(i);
		}
		
		log.info("Test lettura ram");
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