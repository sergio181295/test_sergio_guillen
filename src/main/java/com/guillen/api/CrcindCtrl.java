package com.guillen.api;

import java.io.IOException;
import java.util.List;

import com.guillen.entity.Result;

public interface CrcindCtrl {

	public List<Result> search(String term, List<Result> resultList) throws IOException;
	
}
