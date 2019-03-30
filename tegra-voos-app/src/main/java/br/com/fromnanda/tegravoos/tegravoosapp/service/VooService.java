package br.com.fromnanda.tegravoos.tegravoosapp.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fromnanda.tegravoos.tegravoosapp.model.Voo;
import br.com.fromnanda.tegravoos.tegravoosapp.model.VooDTO;

@Service
public class VooService {

	private static final String URL_API_BACKEND = "http://172.18.0.22:8080";
	private HttpHeaders headers;
	private UriComponentsBuilder builder;

	private RestTemplate restTemplate;
	private ResponseEntity<VooDTO[]> response;

	public VooService() {
		this.headers = new HttpHeaders();
		this.restTemplate = new RestTemplate();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		builder = UriComponentsBuilder.fromHttpUrl(URL_API_BACKEND);
	}

	public List<VooDTO> pesquisar(Voo voo) throws URISyntaxException {
		builder.path("/voos-disponiveis");
		RequestEntity<?> res = RequestEntity.post(new URI(builder.toUriString())).accept(MediaType.APPLICATION_JSON)
				.body(voo);

		response = restTemplate.exchange(res, VooDTO[].class);

		return Arrays.asList(response.getBody());

	}
}
