package test.app.libai.myapp;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.mikephil.charting.data.Entry;

/**
 * git status
 */
public class DBUtils {
    private static final String TAG = "DBUtils";

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

    public static List<HashMap<String, Float>> getData() throws SQLException {
        Connection conn = getConnection();
        List<HashMap<String, Float>> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            String sql1 = "SELECT * FROM aliyun1 WHERE id = (SELECT MAX(id) FROM aliyun1);";
            String sql2 = "SELECT * FROM aliyun2 WHERE id = (SELECT MAX(id) FROM aliyun2);";
            String sql3 = "SELECT * FROM aliyun3 WHERE id = (SELECT MAX(id) FROM aliyun3);";
            String sql4 = "SELECT * FROM aliyun4 WHERE id = (SELECT MAX(id) FROM aliyun4);";
            ResultSet res1 = st.executeQuery(sql1);
            if (res1 == null) {
                res1.close();
                st.close();
                conn.close();
                return null;
            } else {
                HashMap<String, Float> map = new HashMap<>();
                res1.next();
                map.put("temp", res1.getFloat("temp"));
                map.put("humi", res1.getFloat("humi"));
                list.add(map);
            }
            res1.close();
            ResultSet res2 = st.executeQuery(sql2);
            if (res2 == null) {
                res2.close();
                st.close();
                conn.close();
                return null;
            } else {
                HashMap<String, Float> map = new HashMap<>();
                res2.next();
                map.put("temp", res2.getFloat("temp"));
                map.put("humi", res2.getFloat("humi"));
                list.add(map);
            }
            res2.close();
            ResultSet res3 = st.executeQuery(sql3);
            if (res3 == null) {
                res3.close();
                st.close();
                conn.close();
                return null;
            } else {
                HashMap<String, Float> map = new HashMap<>();
                res3.next();
                map.put("temp", res3.getFloat("temp"));
                map.put("humi", res3.getFloat("humi"));
                list.add(map);
            }
            res3.close();
            ResultSet res4 = st.executeQuery(sql4);
            if (res4 == null) {
                res4.close();
                st.close();
                conn.close();
                return null;
            } else {
                HashMap<String, Float> map = new HashMap<>();
                res4.next();
                map.put("temp", res4.getFloat("temp"));
                map.put("humi", res4.getFloat("humi"));
                list.add(map);
            }
            res4.close();
            st.close();
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, " 数据操作异常");
            return null;
        }
    }


}

