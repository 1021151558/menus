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
 * @Date: created in 14:59 2018/5/21/021
 */
public class Runner20 implements Runnable {
    public void run() {
        HttpClient client = new DefaultHttpClient();
        //糖尿病
        for (int i = 1; i <= 121; i++) {

            String url = "https://www.meishij.net/shiliao.php?st=3&cid=161&sortby=update&page=" + Integer.toString(i);
            //抓取的数据
            List<Food> fooddatas = null;
            try {
                fooddatas = URLFecter.URLParser(client, url);
                //将抓取的数据插入数据库
                try {
                    MYSQLControl.executeInsertAllFood(fooddatas,"tangniaobin");
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
