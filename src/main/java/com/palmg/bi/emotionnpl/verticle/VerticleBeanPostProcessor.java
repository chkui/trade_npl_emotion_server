package com.palmg.bi.emotionnpl.verticle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.palmg.bi.emotionnpl.verticle.stereotype.Verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class VerticleBeanPostProcessor implements BeanPostProcessor {
	@Autowired
	private Vertx vertx;

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Verticle annot = bean.getClass().getAnnotation(Verticle.class);
		if (null != annot) {
			DeploymentOptions options = new DeploymentOptions().setInstances(1);
			if (Verticle.ThreadType.Worker == annot.type()) {
				options.setWorker(true);
			} else if (Verticle.ThreadType.MultiWorker == annot.type()) {
				options.setMultiThreaded(true);
			}
			vertx.deployVerticle((AbstractVerticle)bean, options);
		}
		return bean;
	}
}
