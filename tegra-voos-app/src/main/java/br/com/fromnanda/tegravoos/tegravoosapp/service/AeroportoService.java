package br.com.fromnanda.tegravoos.tegravoosapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fromnanda.tegravoos.tegravoosapp.model.Aeroporto;

@Service
public class AeroportoService {

	private static final String URL_API_BACKEND = "http://172.18.0.22:8080";
	private HttpHeaders headers;
	private UriComponentsBuilder builder;

	private RestTemplate restTemplate;
	private ResponseEntity<Aeroporto[]> response;

	public AeroportoService() {
		this.headers = new HttpHeaders();
		this.restTemplate = new RestTemplate();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		builder = UriComponentsBuilder.fromHttpUrl(URL_API_BACKEND);
	}

	public List<Aeroporto> listar() {
		builder.path("/aeroportos");
		response = restTemplate.getForEntity(builder.toUriString(), Aeroporto[].class);
		return Arrays.asList(response.getBody());
	}
}
