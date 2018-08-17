package com.palmg.bi.emotionnpl.baidu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

import com.baidu.aip.nlp.AipNlp;

import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScans(@ComponentScan(basePackages = "com.palmg.bi.emotionnpl.baidu", includeFilters = @Filter(type = FilterType.REGEX, pattern = "..*")))
@PropertySource("classpath:com/palmg/bi/emotionnpl/baidu/npl.properties")
public class BaiduConfig {

	@Bean
	public AipNlp aipNlp(@Value("${baidu.npl.id}") String id, 
			@Value("${baidu.npl.key}") String key,
			@Value("${baidu.npl.secret}") String secret) {
		AipNlp client = new AipNlp(id, key, secret);
		System.setProperty("aip.log4j.conf", "log4j2.xml");
		return client;
	}
}
