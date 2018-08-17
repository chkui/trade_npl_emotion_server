package com.palmg.bi.emotionnpl.baidu.impl;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;
import com.palmg.bi.emotionnpl.EmotionNplApp;
import com.palmg.bi.emotionnpl.baidu.CommentEmotionService;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

@Service
public class StandardCommentEmotionService implements CommentEmotionService {
	static final Logger logger = LoggerFactory.getLogger(StandardCommentEmotionService.class);
	@Autowired
	private AipNlp aipNlp;
	
	private HashMap<String, Object> AipOptions = null;

	@Override
	public JSONObject commentTag(String comment, ESimnetType miniType) {
		JSONObject response = aipNlp.commentTag(comment, ESimnetType.CAR, AipOptions);
		return response;
	}

	@Override
	public JSONObject dnnlmCn(String text) {
		JSONObject response = aipNlp.dnnlmCn(text, AipOptions);
		return response;
	}

	@Override
	public JSONObject sentimentClassify(String text) {
		return aipNlp.sentimentClassify(text, AipOptions);
	}

	@Override
	public JSONObject lexer(String comment) {
		return aipNlp.lexer(comment, AipOptions);
	}
}
