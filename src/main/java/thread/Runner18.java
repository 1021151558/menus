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
 * @Date: created in 14:37 2018/5/21/021
 */
public class Runner18 implements Runnable {
    public void run() {
        HttpClient client = new DefaultHttpClient();
        //接触化学毒素人员
        for (int i = 1; i <= 79; i++) {

            String url = "https://www.meishij.net/shiliao.php?st=3&cid=265&sortby=update&page=" + Integer.toString(i);
            //抓取的数据
            List<Food> fooddatas = null;
            try {
                fooddatas = URLFecter.URLParser(client, url);
                //将抓取的数据插入数据库
                try {
                    MYSQLControl.executeInsertAllFood(fooddatas,"dusu");
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
