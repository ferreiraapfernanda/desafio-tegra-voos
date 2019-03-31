package br.com.fromnanda.tegravoos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fromnanda.tegravoos.dto.CriterioBuscaDTO;
import br.com.fromnanda.tegravoos.dto.VooDTO;
import br.com.fromnanda.tegravoos.service.VooService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "API REST Voo")
@RestController
@RequestMapping("/voos-disponiveis")
public class VooController {

	@Autowired
	private VooService service;

	@ApiOperation(value = "Retorna uma lista de voos disponíveis a partir do critério de busca especificado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso", response = VooDTO[].class),
			@ApiResponse(code = 204, message = "Sem conteúdo"), @ApiResponse(code = 401, message = "Sem autorização"),
			@ApiResponse(code = 403, message = "Proibido"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no servidor") })
	@PostMapping()
	public List<VooDTO> voosDisponiveis(@RequestBody CriterioBuscaDTO criterioBuscaDTO) {

		List<VooDTO> voosDisponiveis = new ArrayList<VooDTO>();

		try {
			voosDisponiveis = service.voosDisponiveis(criterioBuscaDTO);
		} catch (IOException e) {
			e.printStackTrace();
			// TODO Exibir erro
		}

		return voosDisponiveis;
	}

}
