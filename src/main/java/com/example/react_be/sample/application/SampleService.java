package com.example.react_be.sample.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.react_be.sample.domain.SampleDao;
import com.example.react_be.sample.domain.SampleRepository;

@Service
public class SampleService {

	@Autowired
	SampleRepository sampleRepository;

	public List<SampleDao> getSample() {

		List<SampleDao> list = sampleRepository.findAll();

		return list;
	}

	public void addSample(SampleDao sampleDao) {

		sampleRepository.save(sampleDao);
	}
	
	public void delSample(List<SampleDao> sampleDaoList) {
		
		for(int i=0; i< sampleDaoList.size(); i++) {
			sampleRepository.delete(sampleDaoList.get(i));
		}

	}

}
