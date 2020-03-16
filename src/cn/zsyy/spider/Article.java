package cn.zsyy.spider;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.zsyy.uit.JDB;

public class Article {

	static String listArticleUrl = "http://www.nfyy.com/xwzx/yyxw";

	static String host = "http://www.nfyy.com";

	static HashMap<String, Object> getArticle() throws IOException {
		HashMap<String, Object> article = new HashMap<>();
		// 1.模拟游览器发送到底http的请求
		String url = "http://www.nfyy.com/xwzx/yyxw";
		Document document = Jsoup.connect(url).get();
		// System.out.println(document);

		// 通过文档对象获取元素
		/**
		 * Element ele = document.getElementById("nav_yyjs"); System.out.println(ele);
		 * //通过元素对象获元素 System.out.println(ele.text());
		 * System.out.println(ele.attr("class")); System.out.println(ele.html());
		 **/

		// 2.解释服务器响应的内容

		// 3.提取到数据库

		return article;

	}

	// 获取全部内容
	static void getlistUrl(String nextUrl) throws IOException {
		// 1模拟浏览器发送http请求，验证码，云打码平台

		Document document = Jsoup.connect(nextUrl).get();
		Elements select = document.select(".next");
		// 获取第一个选中class
		Element first = select.first();

		// 提取下一页地址
		String nextPageUrl = first.attr("href");
		if (!nextPageUrl.equals("javascript:void(0);")) {
			System.out.println(nextPageUrl);
			getlistUrl(nextPageUrl);
			// 通过列表页地址去获取文章页地址
			getArticleUrl(nextPageUrl);
		}

	}

	static void getArticleUrl(String url) throws IOException {

		// 1模拟浏览器发送http请求，验证码，云打码平台
		Document document = Jsoup.connect(url).get();

		// 获取所有的li元素
		Elements lilist = document.select(".list_box ul li");
		for (Element item : lilist) {
			// 通过循环li元素，每隔li对象即是item对象，item对象依然可以通过css选择器，选择里面的a标签
			Elements aEle = item.select("a");
			String articleUrl = aEle.attr("href");
			System.out.println(articleUrl);
			// 通过列表页地址去获取文章地址
			getContent(articleUrl);

		}
	}

	static void getContent(String articleUrl) throws IOException {
		String url = host + articleUrl;
		Document article = Jsoup.connect(url).get();
		// 获取标题
		String title = article.select(".art_box_c h1").first().text();
		// 获取作者
		String author = article.select(".remark").first().text();
		Pattern compile = Pattern.compile(".*?：(.*?)　　");
		Matcher matcher = compile.matcher(author);
		if (matcher.find()) {
			author = matcher.group(1);

		}
		String text = article.select(".art_con").first().html();
		System.out.println(title);
		// System.out.println(author);
		// System.out.println(text);
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("title", title);
		hashMap.put("author", author);
		hashMap.put("content", text);
		int insertObj = JDB.insertObj("artile", hashMap);
	}

	public static void main(String[] args) throws IOException {
		// 初始化
		getArticleUrl(listArticleUrl);
		getlistUrl(listArticleUrl);

		/*
		 * 1/分析网站 1）想要获取什么数据 2）数据在什么页面上 3）如何这些页面的地址 2/获取1个页面的数据 1）通过选择器选中包含数据的元素
		 * 2）获取元素的文本/属性/html 3) 将数据存放至数据库 3/获取列表页的数据 1）通过选择器选中包含数据的元素 2）获取元素的文本/属性/html
		 * 4/获取下一页的地址 重复爬取相对应的数据即可
		 * 
		 */

	}
}
