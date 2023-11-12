package com.projectEMS.service;

import org.springframework.stereotype.Service;

import com.projectEMS.dto.DemoDTO;
import com.projectEMS.entities.Demo;
@Service
public interface DemoService {
	public  Demo login(String demoUsername, String demoPassword);

	public DemoDTO registerDemo(DemoDTO demoDTO);

	
}
