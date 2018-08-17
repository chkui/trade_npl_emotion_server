package com.palmg.bi.emotionnpl.baidu;

import org.json.JSONObject;

import io.vertx.core.Future;

public interface AsyncCommentEmotionService {
	void lexer(String comment, Future<JSONObject> future);
	
	void commentTag(String comment, Future<JSONObject> future);
	
	void dnnlmCn(String text, Future<JSONObject> future);
	
	void sentimentClassify(String text, Future<JSONObject> future);
}
