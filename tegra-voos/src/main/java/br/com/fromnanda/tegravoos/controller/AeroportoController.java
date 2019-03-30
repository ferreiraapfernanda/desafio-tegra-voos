package br.com.fromnanda.tegravoos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fromnanda.tegravoos.model.Aeroporto;
import br.com.fromnanda.tegravoos.service.AeroportoService;

@RestController
public class AeroportoController {

	@Autowired
	private AeroportoService service;

	@GetMapping("/aeroportos")
	public List<Aeroporto> todosOsAeroportos() {

		List<Aeroporto> aeroportos = new ArrayList<>();
		
		try {
			aeroportos = service.todosOsAeroportos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aeroportos;
	}
}
