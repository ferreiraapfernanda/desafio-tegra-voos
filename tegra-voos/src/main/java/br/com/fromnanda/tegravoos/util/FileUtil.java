package br.com.fromnanda.tegravoos.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.fromnanda.tegravoos.model.Aeroporto;
import br.com.fromnanda.tegravoos.model.Voo;

public class FileUtil {

	private static final String PRIMEIRO_CAMPO_UBERAIR = "numero_voo";
	private static final String UBER_AIR_CSV = "uberair.csv";
	private static final String NINE_NINE_PLANES_JSON = "99planes.json";
	private static final String AEROPORTOS_JSON = "aeroportos.json";

	public static boolean isCabecalhoUberAir(String[] values) {
		return values[0].equals(PRIMEIRO_CAMPO_UBERAIR);
	}

	public static List<Voo> lerCsv(Class<?> classe) throws IOException, FileNotFoundException {

		List<Voo> dadosUberAir = new ArrayList<Voo>();
		InputStreamReader file = criaArquivoUberAirCsv(classe);

		try (BufferedReader br = new BufferedReader(file);) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				if (FileUtil.isCabecalhoUberAir(values)) {
					continue;
				}

				dadosUberAir.add(VooFactory.uberAirVoo(values));
			}
		}

		return dadosUberAir;
	}

	public static List<Voo> lerJson(Class<?> classe) throws FileNotFoundException, IOException {

		List<Voo> dados99Planes = new ArrayList<Voo>();
		InputStreamReader file = criaArquivo99PlanesJson(classe);

		try (BufferedReader br = new BufferedReader(file);) {
			Gson gson = new Gson();

			JsonArray json = gson.fromJson(br, JsonArray.class);

			for (JsonElement jsonElement : json) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				dados99Planes.add(VooFactory.nineNinePlanesVoo(jsonObject));
			}

		}

		return dados99Planes;
	}

	public static List<Aeroporto> lerJsonAeroportos(Class<?> classe) throws FileNotFoundException, IOException {

		List<Aeroporto> aeroportos = new ArrayList<Aeroporto>();
		InputStreamReader file = criaArquivoAeroportosJson(classe);

		try (BufferedReader br = new BufferedReader(file);) {
			Gson gson = new Gson();

			JsonArray json = gson.fromJson(br, JsonArray.class);

			for (JsonElement jsonElement : json) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				aeroportos.add(AeroportoFactory.createFrom(jsonObject));
			}

		}

		return aeroportos;
	}

	private static InputStreamReader criaArquivoAeroportosJson(Class<?> classe) throws IOException {
		return criaArquivo(classe, AEROPORTOS_JSON);
	}

	private static InputStreamReader criaArquivo99PlanesJson(Class<?> classe) throws IOException {
		return criaArquivo(classe, NINE_NINE_PLANES_JSON);
	}

	private static InputStreamReader criaArquivoUberAirCsv(Class<?> classe) throws IOException {
		return criaArquivo(classe, UBER_AIR_CSV);
	}

	private static InputStreamReader criaArquivo(Class<?> classe, String nomeArquivo) throws IOException {
		// File file = new
		// File(classe.getClassLoader().getResource(nomeArquivo).getFile());

		Resource resource = new ClassPathResource(nomeArquivo);

		return new InputStreamReader(resource.getInputStream());
	}

}
