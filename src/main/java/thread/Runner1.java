package thread;

import db.MYSQLControl;
import http.URLFecter;
import model.Food;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 16:54 2018/5/16/016
 */
public class Runner1 implements Runnable {
    public void run() {
        HttpClient client = new DefaultHttpClient();
        //美容
        for (int i = 1; i <= 189; i++) {

            String url = "http://www.meishij.net/shiliao.php?st=3&cid=198&sortby=update&page=" + Integer.toString(i);
            //抓取的数据
            List<Food> fooddatas = null;
            try {
                fooddatas = URLFecter.URLParser(client, url);
                //将抓取的数据插入数据库
                try {
                    MYSQLControl.executeInsertAllFood(fooddatas,"meirong");
                } catch (SQLException e) {
                    //e.printStackTrace();
                    continue;
                }
            } catch (Exception e) {
                //e.printStackTrace();
                continue;
            }

        }
    }
}
