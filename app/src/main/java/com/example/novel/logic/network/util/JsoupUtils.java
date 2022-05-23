package com.example.novel.logic.network.util;

import com.example.novel.logic.model.Catalog;
import com.example.novel.logic.model.Chapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;

public class JsoupUtils {
    private static final String TAG = "JsoupUtils";

    public static Chapter toChapter(String html) {
        Document parse = Jsoup.parse(html);
        String title = parse.selectFirst("#title").text();
        String content = parse.selectFirst("body > div.chapterlist > div.Readarea").text();
        String[] s1 = content.split(" ");
        Chapter chapter = new Chapter();
        chapter.setTitle(title);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(s1));
        chapter.setContent(list);
        return chapter;
    }

    public static Catalog toCatalog(String html) {
        Document parse = Jsoup.parse(html);
        String title = parse.selectFirst("body > div.chapterlist > h2 > strong").text();
        Elements elements = parse.select("#myarticle > table > tbody > tr > td > a");
        ArrayList<Chapter> chapterlist = new ArrayList<>();
        for (Element element : elements) {
            String title1 = element.text();
            String href = ConstantUtils.BASE_URL + element.attr("href");
            Chapter chapter = new Chapter();
            chapter.setTitle(title1);
            chapter.setHref(href);
            chapterlist.add(chapter);
        }
        Catalog catalog = new Catalog();
        catalog.setTitle(title);
        catalog.setChapterList(chapterlist);
        return catalog;
    }
}
