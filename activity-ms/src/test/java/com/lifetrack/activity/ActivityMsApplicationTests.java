package com.lifetrack.activity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ActivityMsApplicationTests {

	@Test
	void contextLoads() {
	}

}
