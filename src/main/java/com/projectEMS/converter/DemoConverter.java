package com.projectEMS.converter;

import org.springframework.stereotype.Component;

import com.projectEMS.dto.DemoDTO;
import com.projectEMS.entities.Demo;
@Component
public class DemoConverter {
	public DemoDTO demoToDemoDTO(Demo demo) {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setDemoId(demo.getDemoId());
        demoDTO.setDemoUsername(demo.getDemoUsername());
        demoDTO.setDemoPassword(demo.getDemoPassword());
    return demoDTO;    
	}
	
	public Demo demoDTOToDemo(DemoDTO demoDTO) {
        Demo demo = new Demo();
        demo.setDemoId(demoDTO.getDemoId());
        demo.setDemoUsername(demoDTO.getDemoUsername());
        demo.setDemoPassword(demoDTO.getDemoPassword());
        return demo;
        }

}
