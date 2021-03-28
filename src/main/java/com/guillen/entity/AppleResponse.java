package com.guillen.entity;

import java.util.List;
import java.util.Map;

public class AppleResponse {

	Integer resultCount;
	List<Map<String, Object>> results;

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	public List<Map<String, Object>> getResults() {
		return results;
	}

	public void setResults(List<Map<String, Object>> results) {
		this.results = results;
	}

}
