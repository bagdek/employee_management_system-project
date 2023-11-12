package com.projectEMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectEMS.entities.Demo;

public interface DemoRepository extends JpaRepository<Demo, Integer>{

	Demo findByDemoUsernameAndDemoPassword(String demoUsername, String demoPassword);
}

