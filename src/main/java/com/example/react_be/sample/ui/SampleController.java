package com.example.react_be.sample.ui;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.react_be.sample.application.SampleService;
import com.example.react_be.sample.domain.SampleDao;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	SampleService sampleService;

	@RequestMapping("/getSample")
	public ResponseEntity<HashMap<String, Object>> getSample() {

		ResponseEntity<HashMap<String, Object>> entity;

		HashMap<String, Object> resMap = new HashMap<String, Object>();

		try {
			resMap.put("list", sampleService.getSample());

			entity = new ResponseEntity<HashMap<String, Object>>(resMap, HttpStatus.OK);

		} catch (Exception e) {
			entity = new ResponseEntity<HashMap<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping("/addSample")
	public ResponseEntity<HashMap<String, Object>> addSample(@RequestBody SampleDao sampleDao) {

		ResponseEntity<HashMap<String, Object>> entity;

		HashMap<String, Object> resMap = new HashMap<String, Object>();

		try {
			
			sampleService.addSample(sampleDao);

			entity = new ResponseEntity<HashMap<String, Object>>(resMap, HttpStatus.OK);

		} catch (Exception e) {
			entity = new ResponseEntity<HashMap<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping("/delSample")
	public ResponseEntity<HashMap<String, Object>> delSample(@RequestBody List<SampleDao> sampleDaoList) {

		ResponseEntity<HashMap<String, Object>> entity;

		HashMap<String, Object> resMap = new HashMap<String, Object>();

		try {
			
			sampleService.delSample(sampleDaoList);

			entity = new ResponseEntity<HashMap<String, Object>>(resMap, HttpStatus.OK);

		} catch (Exception e) {
			entity = new ResponseEntity<HashMap<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
