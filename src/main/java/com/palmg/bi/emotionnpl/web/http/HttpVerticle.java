package com.palmg.bi.emotionnpl.web.http;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.aip.nlp.ESimnetType;
import com.palmg.bi.emotionnpl.EmotionNplApp;
import com.palmg.bi.emotionnpl.baidu.CommentEmotionService;
import com.palmg.bi.emotionnpl.verticle.stereotype.Verticle;
import com.palmg.bi.emotionnpl.verticle.stereotype.Verticle.ThreadType;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;

@Verticle(name = "Http Verticle", type = ThreadType.Worker)
public class HttpVerticle extends AbstractVerticle {
	static final Logger logger = LoggerFactory.getLogger(EmotionNplApp.class);

	@Autowired
	private CommentEmotionService commentEmotionService;

	public void start(Future<Void> future) {

		HttpServer server = vertx.createHttpServer();

		Router router = Router.router(vertx);

		router.route("/npl/comment-tag/:comment").handler(routeCtx -> {

			String comment = routeCtx.request().getParam("comment");
			System.out.println(comment);

			// This handler will be called for every request
			HttpServerResponse response = routeCtx.response();
			response.putHeader("content-type", "application/json;charset=utf-8");

			// Write to the response and end it
			JSONObject json = new JSONObject();
			json.put("汽车维度评论", commentEmotionService.commentTag(comment, ESimnetType.CAR));
			json.put("3C维度评论", commentEmotionService.commentTag(comment, ESimnetType._3C));
			json.put("购物维度评论", commentEmotionService.commentTag(comment, ESimnetType.SHOPPING));
			json.put("生活维度评论", commentEmotionService.commentTag(comment, ESimnetType.LIFE));
			// json.put("dnn", commentEmotionService.dnnlmCn(comment));
			json.put("情感倾向", commentEmotionService.sentimentClassify(comment));
			// json.put("语法分析&分词", commentEmotionService.lexer(comment));

			response.end(json.toString());
		});

		server.requestHandler(router::accept).listen(8080, res -> {
			if (res.succeeded()) {
				future.complete();
			} else {
				future.fail(res.cause());
			}
		});
	}
}
