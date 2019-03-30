package br.com.fromnanda.tegravoos.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fromnanda.tegravoos.dto.CriterioBuscaDTO;
import br.com.fromnanda.tegravoos.dto.VooDTO;
import br.com.fromnanda.tegravoos.model.Voo;
import br.com.fromnanda.tegravoos.repository.VooRepository;
import br.com.fromnanda.tegravoos.util.VooFactory;

@Service
public class VooService {

	@Autowired
	private VooRepository vooRepository;

	public List<VooDTO> voosDisponiveis(CriterioBuscaDTO criterioBuscaDTO) throws FileNotFoundException, IOException {

		List<Voo> todosOsVoos = vooRepository.listar();

		List<VooDTO> voosDisponiveis = new ArrayList<VooDTO>();

		voosDisponiveis.addAll(comEscala(criterioBuscaDTO, todosOsVoos));
		voosDisponiveis.addAll(semEscala(criterioBuscaDTO, todosOsVoos));

		voosDisponiveis.sort(Comparator.comparing(VooDTO::getSaida));

		return voosDisponiveis;
	}

	private Collection<? extends VooDTO> semEscala(CriterioBuscaDTO criterioBuscaDTO, List<Voo> todosOsVoos) {
		List<Voo> voosDiretosLista = todosOsVoos.stream().filter(v -> ehVooDireto(v, criterioBuscaDTO))
				.collect(Collectors.toList());
		return VooFactory.formataLista2ListaVooDTO(voosDiretosLista);
	}

	private Collection<? extends VooDTO> comEscala(CriterioBuscaDTO criterioBuscaDTO, List<Voo> todosOsVoos) {

		List<VooDTO> retorno = new ArrayList<VooDTO>();

		todosOsVoos.sort(Comparator.comparing(Voo::getData));

		List<Voo> voosIniciaisEscala = todosOsVoos.stream().filter(v -> ehVooDePartida(criterioBuscaDTO, v))
				.collect(Collectors.toList());
		voosIniciaisEscala.sort(Comparator.comparing(Voo::getData));

		List<Voo> voosFinaisEscala = todosOsVoos.stream().filter(v -> ehVooDeChegada(criterioBuscaDTO, v))
				.collect(Collectors.toList());
		voosFinaisEscala.sort(Comparator.comparing(Voo::getData));

		for (Voo vooInicial : voosIniciaisEscala) {

			List<Voo> escalas = new ArrayList<Voo>();
			escalas.add(vooInicial);

			for (Voo vooFinal : voosFinaisEscala) {

				if (ehUmaEscalaViavel(vooInicial, vooFinal)) {

					VooDTO dto = new VooDTO();
					dto.setChegada(escalas.get(escalas.size() - 1).getChegada());
					dto.setSaida(escalas.get(0).getSaida());

					dto.setOrigem(escalas.get(0).getOrigem());
					dto.setDestino(escalas.get(escalas.size() - 1).getDestino());

					dto.setTrechos(escalas);
				}
			}
		}

		retorno.sort(Comparator.comparing(VooDTO::getSaida));

		return retorno;
	}

	private boolean ehUmaEscalaViavel(Voo vooInicial, Voo vooFinal) {
		return vooInicial.getDestino().equalsIgnoreCase(vooFinal.getOrigem()) && menosDeDozeHoras(vooInicial, vooFinal)
				&& naoEstaVoltandoAoUltimoAeroporto(vooFinal, vooInicial);
	}

	private boolean ehVooDeChegada(CriterioBuscaDTO criterioBuscaDTO, Voo v) {
		return !v.getOrigem().equalsIgnoreCase(criterioBuscaDTO.getOrigem())
				&& v.getDestino().equalsIgnoreCase(criterioBuscaDTO.getDestino());
	}

	private boolean ehVooDePartida(CriterioBuscaDTO criterioBuscaDTO, Voo v) {
		return v.getOrigem().equalsIgnoreCase(criterioBuscaDTO.getOrigem())
				&& v.getData().equals(criterioBuscaDTO.getData())
				&& !v.getDestino().equalsIgnoreCase(criterioBuscaDTO.getDestino());
	}

	private boolean naoEstaVoltandoAoUltimoAeroporto(Voo ultimoVoo, Voo vooAtual) {
		return !(ultimoVoo.getOrigem().equals(vooAtual.getDestino()));
	}

	private boolean menosDeDozeHoras(Voo vooAtual, Voo ultimoVoo) {

		long until = vooAtual.getChegada().until(ultimoVoo.getSaida(), ChronoUnit.HOURS);

		if (until > 0 && until <= 12) {
			return true;
		}

		return false;
	}

	private boolean ehVooDireto(Voo v, CriterioBuscaDTO criterioBuscaDTO) {
		return (v.getOrigem().equals(criterioBuscaDTO.getOrigem()))
				&& (v.getDestino().equals(criterioBuscaDTO.getDestino()))
				&& (v.getData().equals(criterioBuscaDTO.getData()));
	}

}
