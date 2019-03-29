package br.com.fromnanda.tegravoos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fromnanda.tegravoos.dto.CriterioBuscaDTO;
import br.com.fromnanda.tegravoos.dto.VooDTO;
import br.com.fromnanda.tegravoos.service.VooService;

@RestController
public class VooController {

	@Autowired
	private VooService service;

	@PostMapping("/voos-disponiveis")
	public List<VooDTO> voosDisponiveis(@RequestBody CriterioBuscaDTO criterioBuscaDTO) {

		List<VooDTO> voosDisponiveis = new ArrayList<VooDTO>();

		try {
			voosDisponiveis = service.voosDisponiveis(criterioBuscaDTO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return voosDisponiveis;
	}

}
