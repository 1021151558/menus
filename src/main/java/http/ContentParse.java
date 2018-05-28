package http;

import model.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:41 2018/5/16/016
 */
public class ContentParse {
    public static Content getData (String html) throws Exception{
        Content data = new Content();

        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("div[class=measure]");
        for (Element element : elements){
            String content = element.html();

            data.setContent(content);
        }
        return data;
    }
}
