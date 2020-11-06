package eu.europa.ec.estat.esa.search;

import eu.europa.ec.estat.esa.repository.EsaTextRepository;
import eu.europa.ec.estat.esa.dto.EsaTextDto;
import eu.europa.ec.estat.esa.entity.EsaText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author fabrix
 */
@Component
public class SearchEngineProxy {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchEngineProxy.class);
	private static final String URI = "https://webgate.ec.europa.eu/estat-index-api-sandbox/esa/languages/en";
	private static final String AUTH_KEY = "ebc110ec-80eb-462c-922f-48a21165e6a3";
	private static final HttpHeaders HEADERS = new HttpHeaders();

	@Autowired
	private EsaTextRepository esaTextRepository;

	static {
		HEADERS.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HEADERS.set("X-API-Key", AUTH_KEY);
	}

	public void reindex() {
		Iterable<EsaText> esaTexts = this.esaTextRepository.findAll();
		List<EsaTextDto> lst = new ArrayList<>();
		esaTexts.forEach(et -> {
			lst.add(this.esaTextToEsaTextDto(et));
		});
		delete();
		paginatedPut(lst);
	}

	private void delete() {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<List<EsaText>> entity = new HttpEntity<>(HEADERS);
		try {
			ResponseEntity<String> result = restTemplate.exchange(URI, HttpMethod.DELETE, entity, String.class);
		} catch (RuntimeException error) {
			LOGGER.warn(null, error);
		}
	}

	private void paginatedPut(List<EsaTextDto> esaTexts) {
		int step = 500;
		int to = 0;
		int n = esaTexts.size() / step;
		for (int i = 0; i < n; ++i) {
			int from = i * step;
			to = (i + 1) * step;
			put(esaTexts.subList(from, to));
		}
		put(esaTexts.subList(to, esaTexts.size()));
	}

	private void put(List<EsaTextDto> esaTexts) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<List<EsaTextDto>> entity = new HttpEntity<>(esaTexts, HEADERS);
		ResponseEntity<String> result = restTemplate.exchange(URI, HttpMethod.PUT, entity, String.class);
	}

	private EsaTextDto esaTextToEsaTextDto(EsaText et) {
		EsaTextDto etd = new EsaTextDto();
		etd.setHeading_path_id(et.getHeadingPathId());
		etd.setHeading_path_text(et.getHeadingPathText());
		etd.setId(et.getId());
		etd.setId_type(et.getIdType());
		etd.setText(et.getText());
		return etd;
	}

}
