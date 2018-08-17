package com.palmg.bi.emotionnpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.palmg.bi.emotionnpl.baidu.CommentEmotionService;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class EmotionNplApp {
	static final Logger logger = LoggerFactory.getLogger(EmotionNplApp.class);
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		logger.info("ctx", ctx);
		CommentEmotionService ces = ctx.getBean(CommentEmotionService.class);
		logger.info("ces", ces);
		
		Vertx vertx = ctx.getBean(Vertx.class);
		EventBus eventBus = ctx.getBean(EventBus.class);
	}

}
