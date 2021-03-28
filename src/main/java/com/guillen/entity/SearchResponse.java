package com.guillen.entity;

import java.util.List;

public class SearchResponse {

	Integer count;

	List<Result> resultList;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Result> getResultList() {
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}
}
