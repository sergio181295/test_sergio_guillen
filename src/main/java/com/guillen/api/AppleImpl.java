package com.guillen.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guillen.entity.AppleResponse;
import com.guillen.entity.Result;
import com.guillen.entity.utils.Utils;

@Service
public class AppleImpl implements AppleCtrl{
	
	private final RestTemplate restTemplate;

	public AppleImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public List<Result> search(String term, String kind, List<Result> resultList) throws IOException {
		String url = "https://itunes.apple.com/search?term=%s&media=%s";

		if (kind.equals("all")) {

			// GET MUSIC
			String urlFilter = String.format(url, term.replace(" ", "+"), "music");
			String response = this.restTemplate.getForObject(urlFilter, String.class);

			ObjectMapper mapper = new ObjectMapper();
			AppleResponse appleRes = mapper.readValue(response.trim(), AppleResponse.class);

			for (Map<String, Object> det : appleRes.getResults()) {
				resultList.add(buildAppleResult(det, "music"));
			}

			// GET MOVIES
			urlFilter = String.format(url, term.replace(" ", "+"), "movie");
			response = this.restTemplate.getForObject(urlFilter, String.class);

			mapper = new ObjectMapper();
			appleRes = mapper.readValue(response.trim(), AppleResponse.class);

			for (Map<String, Object> det : appleRes.getResults()) {
				resultList.add(buildAppleResult(det, "movie"));
			}

		} else {
			String urlFilter = String.format(url, term.replace(" ", "+"), kind);
			String response = this.restTemplate.getForObject(urlFilter, String.class);

			ObjectMapper mapper = new ObjectMapper();
			AppleResponse appleRes = mapper.readValue(response.trim(), AppleResponse.class);

			for (Map<String, Object> det : appleRes.getResults()) {
				resultList.add(buildAppleResult(det, kind));
			}
		}

		return resultList;
	}

	private Result buildAppleResult(Map<String, Object> map, String kind){
		Result result = new Result();
		result.setDescription(Utils.getStringFromMap(map, "shortDescription"));
		List<String> genderList = new ArrayList<>();
		genderList.add(Utils.getStringFromMap(map, "primaryGenreName"));
		result.setGenders(genderList);
		result.setName(Utils.getStringFromMap(map, "trackName"));
		result.setArtistName(Utils.getStringFromMap(map, "artistName"));
		result.setPrice(Utils.getDoubleFromMap(map, "trackPrice"));
		result.setUrl(Utils.getStringFromMap(map, "trackViewUrl"));
		result.setOrigin("apple");
		result.setKind(kind);
		
		return result;
	}
	
}
