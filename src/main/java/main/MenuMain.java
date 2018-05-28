package main;

import db.MYSQLControl;
import db.MyDataSourse;
import http.URLFecter;
import model.Food;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import thread.*;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 18:36 2018/3/11/011
 */
public class MenuMain {

    static DataSource ds = MyDataSourse.getDataSource("jdbc:mysql://127.0.0.1:3306/healthy?characterEncoding=utf-8&useSSL=false");

    public static void main(String[] args) throws Exception {
        //初始化一个httpclient
        HttpClient client = new DefaultHttpClient();

        Runner1 r1 = new Runner1();

        Thread t1 = new Thread(r1);
        t1.start();

        Runner2 r2 = new Runner2();

        Thread t2 = new Thread(r2);
        t2.start();

        Runner3 r3 = new Runner3();

        Thread t3 = new Thread(r3);
        t3.start();

        Runner4 r4 = new Runner4();

        Thread t4 = new Thread(r4);
        t4.start();

        Runner5 r5 = new Runner5();

        Thread t5 = new Thread(r5);
        t5.start();

        Runner6 r6 = new Runner6();

        Thread t6 = new Thread(r6);
        t6.start();

        Runner7 r7 = new Runner7();

        Thread t7 = new Thread(r7);
        t7.start();

        Runner8 r8 = new Runner8();

        Thread t8 = new Thread(r8);
        t8.start();




        Runner9 r9 = new Runner9();

        Thread t9 = new Thread(r9);
        t9.start();

        Runner10 r10 = new Runner10();

        Thread t10 = new Thread(r10);
        t10.start();


        Runner11 r11 = new Runner11();

        Thread t11 = new Thread(r11);
        t11.start();


        Runner12 r12 = new Runner12();

        Thread t12 = new Thread(r12);
        t12.start();


        Runner13 r13 = new Runner13();

        Thread t13 = new Thread(r13);
        t13.start();


        Runner14 r14 = new Runner14();

        Thread t14 = new Thread(r14);
        t14.start();


        Runner15 r15 = new Runner15();

        Thread t15 = new Thread(r15);
        t15.start();

        Runner16 r16 = new Runner16();

        Thread t16 = new Thread(r16);
        t16.start();

        Runner17 r17 = new Runner17();

        Thread t17 = new Thread(r17);
        t17.start();

        Runner18 r18 = new Runner18();

        Thread t18 = new Thread(r18);
        t18.start();

        Runner19 r19 = new Runner19();

        Thread t19 = new Thread(r19);
        t19.start();

        Runner20 r20 = new Runner20();

        Thread t20 = new Thread(r20);
        t20.start();

        Runner21 r21 = new Runner21();

        Thread t21 = new Thread(r21);
        t21.start();


        //营养不良
        for (int i = 1; i <= 299; i++) {

            String url = "http://www.meishij.net/shiliao.php?st=3&cid=216&sortby=update&page=" + Integer.toString(i);
            //抓取的数据
            try{
                List<Food> fooddatas = URLFecter.URLParser(client, url);
                //将抓取的数据插入数据库
                MYSQLControl.executeInsertAllFood(fooddatas,"yingyang");
            }catch (Exception e) {
//                e.printStackTrace();
                continue;
            }


        }

    }

}
