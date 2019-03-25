package test.app.libai.myapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

   //温度页面按钮
    Button btn_temp1;
    //湿度页面按钮
    Button btn_humidity1;

    Button btn_temp2;
    Button btn_humidity2;

    Button btn_temp3;
    Button btn_humidity3;

    Button btn_temp4;
    Button btn_humidity4;

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            while(true) {
                try {
                    List< HashMap<String, Float>> list =DBUtils.getData();
                    Message msg = new Message();
                    if (list == null) {
                        msg.what = 0;
                        msg.obj = null;
                        //非UI线程不要试着去操作界面
                    } else {
                        msg.what = 1;
                        msg.obj = list;
                    }
                    handler.sendMessage(msg);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    };
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            List<HashMap<String,Float>> list=(List<HashMap<String,Float>>)message.obj;
            HashMap<String, Float> mp1 =list.get(0);
                if(mp1 == null){
                    btn_temp1.setText("温度获取失败");
                    btn_humidity1.setText("湿度获取失败");
                } else{
               Float t=mp1.get("temp");
               Float h=mp1.get("humi");
                btn_temp1.setText(t+"℃");
                btn_humidity1.setText(h+"%");
            }
            HashMap<String, Float> mp2 =list.get(1);
            if(mp2 == null){
                btn_temp2.setText("温度获取失败");
                btn_humidity2.setText("湿度获取失败");
            } else{
                Float t=mp2.get("temp");
                Float h=mp2.get("humi");
                btn_temp2.setText(t+"℃");
                btn_humidity2.setText(h+"%");
            }
            HashMap<String, Float> mp3 =list.get(2);
            if(mp3 == null){
                btn_temp3.setText("温度获取失败");
                btn_humidity3.setText("湿度获取失败");
            } else{
                Float t=mp3.get("temp");
                Float h=mp3.get("humi");
                btn_temp3.setText(t+"℃");
                btn_humidity3.setText(h+"%");
            }
            HashMap<String,  Float> mp4 =list.get(3);
            if(mp4 == null){
                btn_temp4.setText("温度获取失败");
                btn_humidity4.setText("湿度获取失败");
            } else{
                Float t=mp4.get("temp");
                Float h=mp4.get("humi");
                btn_temp4.setText(t+"℃");
                btn_humidity4.setText(h+"%");
            }

            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(runnable).start();

        btn_temp1=findViewById(R.id.btn_temp1);
        btn_temp1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,TempActivity1.class);
                startActivity(intent);
            }
        });

        btn_humidity1=findViewById(R.id.btn_humidity1);
        btn_humidity1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,HumidityActivity1.class);
                startActivity(intent);
            }
        });

        btn_temp2=findViewById(R.id.btn_temp2);
        btn_temp2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,TempActivity1.class);
                startActivity(intent);
            }
        });

        btn_humidity2=findViewById(R.id.btn_humidity2);
        btn_humidity2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,HumidityActivity1.class);
                startActivity(intent);
            }
        });

        btn_temp3=findViewById(R.id.btn_temp3);
        btn_temp3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,TempActivity1.class);
                startActivity(intent);
            }
        });

        btn_humidity3=findViewById(R.id.btn_humidity3);
        btn_humidity3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,HumidityActivity1.class);
                startActivity(intent);
            }
        });

        btn_temp4=findViewById(R.id.btn_temp4);
        btn_temp4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,TempActivity1.class);
                startActivity(intent);
            }
        });

        btn_humidity4=findViewById(R.id.btn_humidity4);
        btn_humidity4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,HumidityActivity1.class);
                startActivity(intent);
            }
        });



                }

            }


