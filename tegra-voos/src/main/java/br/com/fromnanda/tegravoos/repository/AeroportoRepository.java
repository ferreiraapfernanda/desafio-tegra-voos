package br.com.fromnanda.tegravoos.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fromnanda.tegravoos.model.Aeroporto;
import br.com.fromnanda.tegravoos.util.FileUtil;

@Repository
public class AeroportoRepository {

	public List<Aeroporto> listar() throws FileNotFoundException, IOException {
		List<Aeroporto> aeroportos = new ArrayList<Aeroporto>();
		
		aeroportos = FileUtil.lerJsonAeroportos(getClass());

		return aeroportos;
	}

}
