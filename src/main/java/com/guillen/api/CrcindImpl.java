package com.guillen.api;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guillen.entity.Result;
import com.guillen.entity.TvMazeResponse;
import com.guillen.entity.utils.Utils;

@Service
public class CrcindImpl implements TvMazeCtrl{
	
	private final RestTemplate restTemplate;

	public CrcindImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@SuppressWarnings("unchecked")
	public List<Result> search(String term, List<Result> resultList) throws IOException {
		String url = "http://api.tvmaze.com/search/shows?q=%s";

			String urlFilter = String.format(url, term.replace(" ", "+"));
			String response = this.restTemplate.getForObject(urlFilter, String.class);

			ObjectMapper mapper = new ObjectMapper();
			List<TvMazeResponse> list = Arrays.asList(mapper.readValue(response.trim(), TvMazeResponse[].class));

			for (TvMazeResponse det : list) {
				Result result = new Result();
				result.setScore(det.getScore());
				result.setDescription(Utils.getStringFromMap(det.getShow(), "summary"));
				result.setGenders((List<String>) Utils.getListoFromMap(det.getShow(), "genres"));
				result.setName(Utils.getStringFromMap(det.getShow(), "name"));
				result.setOrigin("tvmaze");
				result.setUrl(Utils.getStringFromMap(det.getShow(), "url"));
				result.setKind("show");
				
				resultList.add(result);
			}

		return resultList;
	}
	
}
