package com.palmg.bi.emotionnpl.verticle.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Verticle {
	/**
	 * verticle对应的工作现成类型.<br>
	 * {@code Main}: 使用主EventLop线程<br>
	 * {@code Worker}: 使用单独的Worker线程<br>
	 * {@code MultiWorker}: 同时使用多个Worker线程
	 * 
	 * @author chenkui
	 */
	public enum ThreadType {
	Main, Worker, MultiWorker
	}

	@AliasFor("name")
	String value() default "";

	/**
	 * verticle的名称
	 * 
	 * @return
	 */
	@AliasFor("value")
	String name() default "";

	/**
	 * 定义线程类型
	 * 
	 * @return
	 */
	ThreadType type() default ThreadType.Main;
}
