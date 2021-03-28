package com.guillen.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.ArrayOfPersonIdentificationPersonIdentification;
import org.tempuri.SOAPDemo;
import org.tempuri.SOAPDemoSoap;

import com.guillen.api.AppleCtrl;
import com.guillen.api.TvMazeCtrl;
import com.guillen.entity.Result;
import com.guillen.entity.SearchResponse;


@RestController
@RequestMapping("/search")
public class SearchService {

	
	@Autowired
	private AppleCtrl appleCtrl;
	
	@Autowired
	private TvMazeCtrl tvmazeCtrl;
	

	@GetMapping
	public SearchResponse prueba(@RequestParam(required = false) String term, @RequestParam(required = false) String kind) throws IOException {
		try {
			if (kind == null || kind.isEmpty()) {
				kind = "all";
			}

			//APPLE
			List<Result> resultList = new ArrayList<>();
			
			switch (kind) {
			case "music":
			case "movie":
				appleCtrl.search(term, kind, resultList);
				break;
			case "show":
				tvmazeCtrl.search(term, resultList);
				break;
			case "person":
				SOAPDemoSoap demo = new SOAPDemo().getSOAPDemoSoap();
				ArrayOfPersonIdentificationPersonIdentification result = demo.getListByName("John");
				resultList.add(new Result());
				break;
			default:
				appleCtrl.search(term, kind, resultList);
				tvmazeCtrl.search(term, resultList);
				break;
			}
			
			
			SearchResponse searchResponse = new SearchResponse();
			searchResponse.setCount(resultList.size());
			searchResponse.setResultList(resultList);
			
			return searchResponse;
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	
}
