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
		// 1.ģ�����������͵���http������
		String url = "http://www.nfyy.com/xwzx/yyxw";
		Document document = Jsoup.connect(url).get();
		// System.out.println(document);

		// ͨ���ĵ������ȡԪ��
		/**
		 * Element ele = document.getElementById("nav_yyjs"); System.out.println(ele);
		 * //ͨ��Ԫ�ض����Ԫ�� System.out.println(ele.text());
		 * System.out.println(ele.attr("class")); System.out.println(ele.html());
		 **/

		// 2.���ͷ�������Ӧ������

		// 3.��ȡ�����ݿ�

		return article;

	}

	// ��ȡȫ������
	static void getlistUrl(String nextUrl) throws IOException {
		// 1ģ�����������http������֤�룬�ƴ���ƽ̨

		Document document = Jsoup.connect(nextUrl).get();
		Elements select = document.select(".next");
		// ��ȡ��һ��ѡ��class
		Element first = select.first();

		// ��ȡ��һҳ��ַ
		String nextPageUrl = first.attr("href");
		if (!nextPageUrl.equals("javascript:void(0);")) {
			System.out.println(nextPageUrl);
			getlistUrl(nextPageUrl);
			// ͨ���б�ҳ��ַȥ��ȡ����ҳ��ַ
			getArticleUrl(nextPageUrl);
		}

	}

	static void getArticleUrl(String url) throws IOException {

		// 1ģ�����������http������֤�룬�ƴ���ƽ̨
		Document document = Jsoup.connect(url).get();

		// ��ȡ���е�liԪ��
		Elements lilist = document.select(".list_box ul li");
		for (Element item : lilist) {
			// ͨ��ѭ��liԪ�أ�ÿ��li������item����item������Ȼ����ͨ��cssѡ������ѡ�������a��ǩ
			Elements aEle = item.select("a");
			String articleUrl = aEle.attr("href");
			System.out.println(articleUrl);
			// ͨ���б�ҳ��ַȥ��ȡ���µ�ַ
			getContent(articleUrl);

		}
	}

	static void getContent(String articleUrl) throws IOException {
		String url = host + articleUrl;
		Document article = Jsoup.connect(url).get();
		// ��ȡ����
		String title = article.select(".art_box_c h1").first().text();
		// ��ȡ����
		String author = article.select(".remark").first().text();
		Pattern compile = Pattern.compile(".*?��(.*?)����");
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
		// ��ʼ��
		getArticleUrl(listArticleUrl);
		getlistUrl(listArticleUrl);

		/*
		 * 1/������վ 1����Ҫ��ȡʲô���� 2��������ʲôҳ���� 3�������Щҳ��ĵ�ַ 2/��ȡ1��ҳ������� 1��ͨ��ѡ����ѡ�а������ݵ�Ԫ��
		 * 2����ȡԪ�ص��ı�/����/html 3) �����ݴ�������ݿ� 3/��ȡ�б�ҳ������ 1��ͨ��ѡ����ѡ�а������ݵ�Ԫ�� 2����ȡԪ�ص��ı�/����/html
		 * 4/��ȡ��һҳ�ĵ�ַ �ظ���ȡ���Ӧ�����ݼ���
		 * 
		 */

	}
}
