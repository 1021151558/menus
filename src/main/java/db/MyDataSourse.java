package db;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:44 2018/3/7/007
 */
public class MyDataSourse {
    public static DataSource getDataSource(String connectURI){
        BasicDataSource ds = new BasicDataSource();
        //MySQL的jdbc驱动
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");              //所要连接的数据库名
        ds.setPassword("A15180396064");                //MySQL的登陆密码
        ds.setUrl(connectURI);
        return ds;
    }
}
