package com.projectEMS.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectEMS.converter.DemoConverter;
import com.projectEMS.dao.DemoRepository;
import com.projectEMS.dto.DemoDTO;
import com.projectEMS.entities.Demo;
import com.projectEMS.service.DemoService;

@Component
public class DemoServiceImpl implements DemoService{
	@Autowired
	private DemoRepository demoRepository;
	@Autowired
	private DemoConverter demoConverter;
	
	@Override
	public Demo login(String demoUsername, String demoPassword) {
		Demo demo=demoRepository.findByDemoUsernameAndDemoPassword(demoUsername, demoPassword);
		return demo;
	}

	@Override
	public DemoDTO registerDemo(DemoDTO demoDTO) {
		Demo demo = demoConverter.demoDTOToDemo(demoDTO); 
		demo = demoRepository.save(demo);
		return demoConverter.demoToDemoDTO(demo);
	}
}
