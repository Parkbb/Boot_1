package com.iu.b1.robot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.head.Header;

@SpringBootTest
class ArmTest {
	
	@Resource(name = "leftArm")
	private Arm arm1;
	
	@Autowired
	private Arm rightArm;
	
	@Autowired
	private Header header;
	

	@Test
	void test() {
		assertNotNull(header);
	}

}
