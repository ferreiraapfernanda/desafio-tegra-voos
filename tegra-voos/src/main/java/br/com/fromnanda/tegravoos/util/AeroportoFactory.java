package br.com.fromnanda.tegravoos.util;

import com.google.gson.JsonObject;

import br.com.fromnanda.tegravoos.model.Aeroporto;

public class AeroportoFactory {

	public static Aeroporto createFrom(JsonObject jsonObject) {
		Aeroporto aeroporto = new Aeroporto();

		aeroporto.setNome(jsonObject.get("nome").getAsString());
		aeroporto.setSigla(jsonObject.get("aeroporto").getAsString());
		aeroporto.setCidade(jsonObject.get("cidade").getAsString());

		return aeroporto;
	}

}
