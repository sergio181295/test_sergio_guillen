package com.guillen.api;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tempuri.PersonIdentification;
import org.tempuri.PersonIdentificationList;
import org.tempuri.SOAPDemo;
import org.tempuri.SOAPDemoSoap;

import com.guillen.entity.Result;

@Service
public class CrcindImpl implements CrcindCtrl {

	public List<Result> search(String term, List<Result> resultList) throws IOException {

		SOAPDemoSoap soapService = new SOAPDemo().getSOAPDemoSoap();
		PersonIdentificationList list = soapService.getListByName(term);

		for (PersonIdentification det : list.getPersonIdentification()) {
			Result result = new Result();
			result.setName(det.getName());
			result.setOrigin("crcind");
			result.setKind("person");

			resultList.add(result);
		}

		return resultList;
	}

}
