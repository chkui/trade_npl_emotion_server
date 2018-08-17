package com.palmg.bi.emotionnpl.baidu;

import org.json.JSONObject;

import com.baidu.aip.nlp.ESimnetType;

public interface CommentEmotionService {
	JSONObject lexer(String comment);
	
	JSONObject commentTag(String comment, ESimnetType miniType);
	
	JSONObject dnnlmCn(String text);
	
	JSONObject sentimentClassify(String text);
}
