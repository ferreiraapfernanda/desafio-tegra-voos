package br.com.fromnanda.tegravoos.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fromnanda.tegravoos.model.Voo;
import br.com.fromnanda.tegravoos.util.FileUtil;

@Repository
public class VooRepository {

	public List<Voo> listar() throws FileNotFoundException, IOException {

		List<Voo> passagens = new ArrayList<Voo>();

		passagens.addAll(dadosUberAir());
		passagens.addAll(dados99Planes());

		return passagens;
	}

	private List<Voo> dadosUberAir() throws FileNotFoundException, IOException {

		List<Voo> dadosUberAir = new ArrayList<Voo>();
		dadosUberAir = FileUtil.lerCsv(getClass());

		return dadosUberAir;
	}

	private List<Voo> dados99Planes() throws FileNotFoundException, IOException {

		List<Voo> dados99Planes = new ArrayList<Voo>();
		dados99Planes = FileUtil.lerJson(getClass());

		return dados99Planes;
	}

}
