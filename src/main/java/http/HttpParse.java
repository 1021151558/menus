package http;



import model.Food;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:45 2018/3/7/007
 */
public class HttpParse {
    public static List<Food> getData (String html) throws Exception{
        //获取的数据，存放在集合中
        List<Food> data = new ArrayList<Food>();
        //采用Jsoup解析
        Document doc = Jsoup.parse(html);
        //获取html标签中的内容
        Elements elements=doc.select("div[class=listtyle1_list clearfix]")
                .select("div[class=listtyle1]")
                .select("a[class=big]");
        for (Element ele:elements) {
            String foodName=ele.select("div[class=i_w]")
                    .select("div[class=i]")
                    .select("div[class=c1]")
                    .select("strong").text();
            String foodPopularity=ele.select("div[class=i_w]")
                    .select("div[class=i]")
                    .select("div[class=c1]")
                    .select("span").text();;
            String foodwork=ele.select("strong[class=gx]").select("span").text();
            //创建一个对象
            Food food=new Food();
            //对象的值
            food.setFoodName(foodName);
            food.setFoodPopularity(foodPopularity);
            food.setFoodWork(foodwork);
            //将每一个对象的值，保存到List集合中
            data.add(food);
        }
        //返回数据
        return data;
    }
}
