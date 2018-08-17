package com.palmg.bi.emotionnpl.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScans(@ComponentScan(basePackages = "com.palmg.bi.emotionnpl.web", includeFilters = @Filter(type = FilterType.REGEX, pattern = "..*")))
public class WebConfig {
	
}
