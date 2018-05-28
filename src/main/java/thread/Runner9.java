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
 * @Date: created in 14:11 2018/5/21/021
 */
public class Runner9 implements Runnable {
    public void run() {
        HttpClient client = new DefaultHttpClient();
        //孕妇
        for (int i = 1; i <= 266; i++) {

            String url = "https://www.meishij.net/shiliao.php?st=3&cid=253&sortby=update&page=" + Integer.toString(i);
            //抓取的数据
            List<Food> fooddatas = null;
            try {
                fooddatas = URLFecter.URLParser(client, url);
                //将抓取的数据插入数据库
                try {
                    MYSQLControl.executeInsertAllFood(fooddatas,"yunfu");
                } catch (SQLException e) {
                    System.out.println(e);
                    continue;
                }
            } catch (Exception e) {
                System.out.println(e);
                continue;

            }

        }
    }
}
