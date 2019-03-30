package br.com.fromnanda.tegravoos.tegravoosapp.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fromnanda.tegravoos.tegravoosapp.model.Aeroporto;
import br.com.fromnanda.tegravoos.tegravoosapp.model.Voo;
import br.com.fromnanda.tegravoos.tegravoosapp.model.VooDTO;
import br.com.fromnanda.tegravoos.tegravoosapp.service.AeroportoService;
import br.com.fromnanda.tegravoos.tegravoosapp.service.VooService;

@Controller
public class VooController {

	private AeroportoService aeroportoService;
	private List<Aeroporto> aeroportos;
	private List<VooDTO> listaDeVoos = new ArrayList<VooDTO>();

	@Autowired
	public VooController() {

	}

	@GetMapping("/")
	public String voos(Voo voo, Model model) {

		adicionarAeroportos(model);

		return "index";
	}

	private void adicionarAeroportos(Model model) {
		aeroportoService = new AeroportoService();
		aeroportos = aeroportoService.listar();
		model.addAttribute("aeroportos", aeroportos);
	}

	@PostMapping("/")
	public String pesquisar(@Valid Voo voo, BindingResult result, Model model) {

		adicionarAeroportos(model);

		if (result.hasErrors()) {
			return "index";
		}

		VooService service = new VooService();

		try {
			listaDeVoos = service.pesquisar(voo);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		calculaPrecosETemposTotais();

		model.addAttribute("voos", listaDeVoos);
		
		VooDTO v = new VooDTO();
		listaDeVoos.indexOf(v);

		return "index";
	}
	
	@GetMapping("/voo/{index}")
	public String voo(@PathVariable("index") String index, ModelMap model) {
		
		VooDTO voo = listaDeVoos.get(Integer.parseInt(index));
		
		model.addAttribute("vooSelecionado", voo);
		
		return "index :: modal";
	}

	private void calculaPrecosETemposTotais() {
		for (VooDTO voo : listaDeVoos) {
			voo.calculaPrecoTotal();
			voo.calculaTempoTotal();
		}

	}
}
