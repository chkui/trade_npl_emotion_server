package com.palmg.bi.emotionnpl.baidu.impl;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.palmg.bi.emotionnpl.baidu.AsyncCommentEmotionService;
import com.palmg.bi.emotionnpl.baidu.CommentEmotionService;

import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;

public class AsyncCommentEnotionService implements AsyncCommentEmotionService {
	
	@Autowired
	private EventBus eventBus;
	
	@PostConstruct
	public void init(){
		JSONObject json = new JSONObject();
	}

	@Override
	public void lexer(String comment, Future<JSONObject> future) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commentTag(String comment, Future<JSONObject> future) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dnnlmCn(String text, Future<JSONObject> future) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sentimentClassify(String text, Future<JSONObject> future) {
		// TODO Auto-generated method stub
		
	}

}
