package com.palmg.bi.emotionnpl.verticle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VerticleConfig {
	@Bean
	VerticleBeanPostProcessor verticleBeanPostProcessor() {
		return new VerticleBeanPostProcessor();
	}
}
