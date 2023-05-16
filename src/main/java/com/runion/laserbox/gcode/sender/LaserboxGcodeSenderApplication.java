package com.runion.laserbox.gcode.sender;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LaserboxGcodeSenderApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LaserboxGcodeSenderApplication.class).headless(false).run(args);
	}

}
