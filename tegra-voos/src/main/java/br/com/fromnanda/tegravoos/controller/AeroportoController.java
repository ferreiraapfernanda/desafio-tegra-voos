package br.com.fromnanda.tegravoos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fromnanda.tegravoos.model.Aeroporto;
import br.com.fromnanda.tegravoos.service.AeroportoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AeroportoController {

	@Autowired
	private AeroportoService service;

	@ApiOperation(value = "Lista todos os aeroportos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso", response = Aeroporto[].class),
			@ApiResponse(code = 204, message = "Sem conteúdo"), @ApiResponse(code = 401, message = "Sem autorização"),
			@ApiResponse(code = 403, message = "Proibido"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor") })
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
