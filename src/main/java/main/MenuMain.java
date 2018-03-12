package main;

import db.MYSQLControl;
import http.URLFecter;
import model.Food;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 18:36 2018/3/11/011
 */
public class MenuMain {

    static final Log logger = LogFactory.getLog(MenuMain.class);


    public static void main(String[] args) throws Exception{
        //初始化一个httpclient
        HttpClient client = new DefaultHttpClient();

        //http://www.meishij.net/chufang/diy/?&page=2
        String url="http://www.meishij.net/chufang/diy/?&page=2";
        //抓取的数据
        List<Food> fooddatas= URLFecter.URLParser(client,url);

        //将抓取的数据插入数据库
        MYSQLControl.executeInsert(fooddatas);
    }

}
