package test.app.libai.myapp;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtils02 {
    private static final String TAG = "DBUtils02";

    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载驱动
            conn = DriverManager.getConnection(
                    "jdbc:mysql://47.107.254.199:3306/demo",
                    "root", "yanyuqinghe");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }


    public static ArrayList<Float> getList(String dbname, String canshu) {
        ArrayList<Float> list = new ArrayList<>();
        Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            String sql1 = "SELECT MAX(id) FROM " + dbname + " ;";
            ResultSet res1 = st.executeQuery(sql1);
            if (res1 == null) {
                res1.close();
                st.close();
                conn.close();
                return null;
            } else {
                res1.next();
                int count = res1.getInt(1);
                res1.close();
                for (int i = 24; i >= 1; i--) {
                    String sql = "SELECT(" + canshu + ")" + " from " + dbname + " where id = " + (count - i);
                    ResultSet res = st.executeQuery(sql);
                    res.next();
                    Float f = res.getFloat(1);
                    list.add(f);
                    res.close();
                }
            }
            st.close();
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, " 02数据操作异常");
            return null;
        }

    }
}
