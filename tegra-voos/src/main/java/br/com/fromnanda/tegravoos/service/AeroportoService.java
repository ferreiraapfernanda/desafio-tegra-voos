package br.com.fromnanda.tegravoos.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fromnanda.tegravoos.model.Aeroporto;
import br.com.fromnanda.tegravoos.repository.AeroportoRepository;

@Service
public class AeroportoService {

	@Autowired
	private AeroportoRepository aeroportoRepository;

	public List<Aeroporto> todosOsAeroportos() throws FileNotFoundException, IOException {
		List<Aeroporto> todosOsAeroportos = aeroportoRepository.listar();
		return todosOsAeroportos;
	}
}
