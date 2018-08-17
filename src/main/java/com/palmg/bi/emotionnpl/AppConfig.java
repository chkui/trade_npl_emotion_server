package com.palmg.bi.emotionnpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.palmg.bi.emotionnpl.baidu.BaiduConfig;
import com.palmg.bi.emotionnpl.verticle.VerticleConfig;
import com.palmg.bi.emotionnpl.web.WebConfig;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;

@Configuration
@Import({WebConfig.class, BaiduConfig.class, VerticleConfig.class})
public class AppConfig {
	
	@Bean
	public VertxOptions vertxOptions() {
		return new VertxOptions().setWorkerPoolSize(40);
	}
	
	@Bean
	public Vertx vertx(VertxOptions options) {
		return Vertx.vertx();
	}
	
	@Bean
	public EventBus EventBus(Vertx vertx) {
		return vertx.eventBus();
	}
}
