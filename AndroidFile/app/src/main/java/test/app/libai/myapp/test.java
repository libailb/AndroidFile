package test.app.libai.myapp;

import com.github.mikephil.charting.data.Entry;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
        DBUtils.getData();
       List<Float> y = DBUtils02.getList("aliyun1","temp");
        System.out.println(y);
        System.out.println(y.size());
        System.out.println();
        ArrayList<Entry> y2 = new ArrayList<Entry>();
        for (int i = 0; i <24; i++) {
            float val = (float) (Math.random() * 100);
            Entry entry = new Entry(val, i);
            y2.add(entry);
        }
        System.out.println(y2);
    }
}
