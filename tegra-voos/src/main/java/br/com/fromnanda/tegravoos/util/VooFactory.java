package br.com.fromnanda.tegravoos.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import br.com.fromnanda.tegravoos.dto.VooDTO;
import br.com.fromnanda.tegravoos.model.Voo;

public class VooFactory {

	public static Voo uberAirVoo(String[] valoresLinha) {

		Voo voo = new Voo();

		voo.setVoo(valoresLinha[0]);
		voo.setOrigem(valoresLinha[1]);
		voo.setDestino(valoresLinha[2]);

		String data = valoresLinha[3];
		voo.setData(converteData(data));
		voo.setSaida(converteDateEHora(data, valoresLinha[4]));
		voo.setChegada(converteDateEHora(data, valoresLinha[5]));

		voo.setPreco(converteBigDecimal(valoresLinha[6]));

		return voo;
	}

	public static Voo nineNinePlanesVoo(JsonObject jsonObject) {

		Voo voo = new Voo();

		voo.setVoo(jsonObject.get("voo").getAsString());
		voo.setOrigem(jsonObject.get("origem").getAsString());
		voo.setDestino(jsonObject.get("destino").getAsString());

		String dataSaida = jsonObject.get("data_saida").getAsString();
		voo.setData(converteData(dataSaida));
		voo.setSaida(converteDateEHora(dataSaida, jsonObject.get("saida").getAsString()));
		voo.setChegada(converteDateEHora(dataSaida, jsonObject.get("chegada").getAsString()));

		voo.setPreco(converteBigDecimal(jsonObject.get("valor").getAsString()));

		return voo;
	}

	public static List<VooDTO> formataLista2ListaVooDTO(List<Voo> voos) {

		List<VooDTO> vooDTOs = new ArrayList<VooDTO>();

		for (Voo voo : voos) {

			List<Voo> trechos = new ArrayList<Voo>();
			trechos.add(voo);

			VooDTO dto = new VooDTO(voo.getOrigem(), voo.getDestino(), voo.getSaida(), voo.getChegada(), trechos);
			vooDTOs.add(dto);
		}

		return vooDTOs;

	}

	/**
	 * 
	 * @param str
	 * @return
	 * 
	 * @see http://www.java67.com/2016/04/how-to-convert-string-to-localdatetime-in-java8-example.html
	 */
	private static LocalDate converteData(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		LocalDate dateTime = LocalDate.parse(data, formatter);
		return dateTime;
	}

	private static LocalTime converteHora(String horario) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		LocalTime dateTime = LocalTime.parse(horario, formatter);
		return dateTime;
	}

	private static LocalDateTime converteDateEHora(String data, String horario) {

		LocalDate localDate = converteData(data);
		LocalTime localTime = converteHora(horario);

		LocalDateTime dateTime = LocalDateTime.of(localDate, localTime);
		return dateTime;
	}

	private static BigDecimal converteBigDecimal(String str) {
		return new BigDecimal(str).setScale(2, RoundingMode.DOWN);
	}

}
