package br.com.fromnanda.tegravoos.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
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
	private VooRepository repository;

	public List<VooDTO> voosDisponiveis(CriterioBuscaDTO criterioBuscaDTO) throws FileNotFoundException, IOException {

		List<Voo> todosOsVoos = repository.listar();

		List<VooDTO> voosDisponiveis = new ArrayList<VooDTO>();

		voosDisponiveis.addAll(comEscala(criterioBuscaDTO, todosOsVoos));
		voosDisponiveis.addAll(semEscala(criterioBuscaDTO, todosOsVoos));

		// TODO ordenar

		return voosDisponiveis;
	}

	private Collection<? extends VooDTO> semEscala(CriterioBuscaDTO criterioBuscaDTO, List<Voo> todosOsVoos) {
		List<Voo> voosDiretosLista = todosOsVoos.stream().filter(v -> possuiTodosOsCriterios(v, criterioBuscaDTO))
				.collect(Collectors.toList());
		return VooFactory.formataLista2ListaVooDTO(voosDiretosLista);
	}

	private Collection<? extends VooDTO> comEscala(CriterioBuscaDTO criterioBuscaDTO, List<Voo> todosOsVoos) {
		List<VooDTO> retorno = new ArrayList<VooDTO>();

		List<Voo> voosOrigem = todosOsVoos.stream().filter(v -> !possuiTodosOsCriterios(v, criterioBuscaDTO))
				.collect(Collectors.toList());
		List<Voo> voosDeEscala = new ArrayList<Voo>(voosOrigem);

		for (Voo vooDeOrigem : voosOrigem) {

			List<Voo> escalas = new ArrayList<Voo>();

			/**
			 * Ponto de partida
			 */
			if (vooDeOrigem.getOrigem().equals(criterioBuscaDTO.getOrigem())
					&& vooDeOrigem.getData().toLocalDate().equals(criterioBuscaDTO.getData().toLocalDate())) {

				escalas.add(vooDeOrigem);

				boolean chegouAoDestino = false;
				int qtdTotalDeVoos = voosDeEscala.size();
				int index = 0;

				while (!chegouAoDestino && index < qtdTotalDeVoos) {
					
					if(index == 0) {
						index++;
						continue;
					}

					Voo vooAtual = voosDeEscala.get(index);
					Voo ultimoVoo = escalas.get(escalas.size() - 1);

					/**
					 * é uma escala viável
					 */
					if (ultimoVoo.getDestino().equals(vooAtual.getOrigem())
							&& naoEstavoltandoAoUltimoAeroporto(ultimoVoo, vooAtual)
							&& menosDeDozeHoras(vooAtual, ultimoVoo)) {
						escalas.add(vooAtual);
					} // TODO validar se essa função está correta

					if (ultimoVoo.getDestino().equals(criterioBuscaDTO.getDestino())) {
						chegouAoDestino = true;
					}

					index++;

				}
				
				VooDTO dto = new VooDTO();
				dto.setChegada(escalas.get(escalas.size()-1).getChegada());
				dto.setSaida(escalas.get(0).getSaida());
				
				dto.setOrigem(criterioBuscaDTO.getOrigem());
				dto.setDestino(criterioBuscaDTO.getDestino());
				
				dto.setTrechos(escalas);
				
				retorno.add(dto);

			}

		}

		return retorno;
	}

	private boolean naoEstavoltandoAoUltimoAeroporto(Voo ultimoVoo, Voo vooAtual) {
		return !(ultimoVoo.getOrigem().equals(vooAtual.getDestino()));
	}

	private boolean menosDeDozeHoras(Voo vooAtual, Voo voo) {

		long until = vooAtual.getChegada().until(voo.getSaida(), ChronoUnit.HOURS);

		if (until > 0 && until <= 12) {
			return true;
		}

		return false;
	}

	private boolean possuiTodosOsCriterios(Voo v, CriterioBuscaDTO criterioBuscaDTO) {
		return (v.getOrigem().equals(criterioBuscaDTO.getOrigem()))
				&& (v.getDestino().equals(criterioBuscaDTO.getDestino()))
				&& (v.getData().toLocalDate().equals(criterioBuscaDTO.getData().toLocalDate()));
	}

}
