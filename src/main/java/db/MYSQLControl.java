package db;


import model.Food;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


/**
 * @Author: kong
 * @Descripton:Mysql操作的QueryRunner方法
 * 一个数据库操作类，别的程序直接调用即可
 * @Date: created in 14:44 2018/3/7/007
 */
    public class MYSQLControl {
    //根据自己的数据库地址修改
    static DataSource ds = MyDataSourse.getDataSource("jdbc:mysql://127.0.0.1:3306/fooddata");
    static QueryRunner qr = new QueryRunner(ds);
    //第一类方法
    public static void executeUpdate(String sql){
        try {
            qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //第二类数据库操作方法
    public static void executeInsert(List<Food> data) throws SQLException {
        /*
         * 定义一个Object数组，行列
         * 3表示列数，根据自己的数据定义这里面的数字
         * params[i][0]等是对数组赋值，这里用到集合的get方法
         *
         */
        Object[][] params = new Object[data.size()][3];
        for ( int i=0; i<params.length; i++ ){
            params[i][0] = data.get(i).getFoodName();
            params[i][1] = data.get(i).getFoodPopularity();
            params[i][2] = data.get(i).getFoodWork();
        }
        qr.batch("insert into menu (food_name, food_popularity, food_work)"
                + "values (?,?,?)", params);
        System.out.println("执行数据库完毕！"+"成功插入数据："+data.size()+"条");

    }
}
