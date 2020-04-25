package com.mymovies.service;

import com.mymovies.dto.ListGenresAvailableDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ListGenresAvailableService implements IListGenresAvailableService {

	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(ListGenresAvailableService.class);
	
	private RestTemplate restTemplate = new RestTemplate();

	public ListGenresAvailableDTO getAPI_ListGenresAvailable() {

		ListGenresAvailableDTO listGenresAvailable = null;

		try {
			listGenresAvailable = restTemplate.getForObject(BASE_URL+API_KEY+Language, ListGenresAvailableDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error: getAPI_ListGenresAvailable: " + e);
		}

		return listGenresAvailable;

	}

}
