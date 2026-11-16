package com.lifetrack.activity;

import org.springframework.boot.SpringApplication;

public class TestActivityMsApplication {

	public static void main(String[] args) {
		SpringApplication.from(ActivityMsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
