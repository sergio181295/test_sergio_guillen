package com.guillen.api;

import java.io.IOException;
import java.util.List;

import com.guillen.entity.Result;

public interface AppleCtrl {

	public List<Result> search(String term, String kind, List<Result> resultList) throws IOException;
	
}
