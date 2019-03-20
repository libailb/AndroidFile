package test.app.libai.myapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
   //温度页面按钮
    Button btn_temp;
    //湿度页面按钮
    Button btn_humidity;
    //光照页面按钮
    Button btn_light;
    //压力页面按钮
    Button btn_pressure;


    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            while(true) {
                try {
                    HashMap<String, String> mp =
                            DBUtils.getData();
                    Message msg = new Message();
                    if (mp == null) {
                        msg.what = 0;
                        msg.obj = null;
                        //非UI线程不要试着去操作界面
                    } else {
                        msg.what = 1;
                        msg.obj = mp;
                    }
                    handler.sendMessage(msg);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    };
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            HashMap<String, String> mp =(HashMap<String,String>)message.obj;
            String t=mp.get("temperature");
            String h=mp.get("humidity");
            String l=mp.get("light");
            String p=mp.get("pressure");
            btn_temp.setText("当前温度："+t);
            btn_humidity.setText("当前湿度："+h);
            btn_light.setText("当前光强："+l);
            btn_pressure.setText("当前压力："+p);
//            String str = "查询不存在";
//            if(message.what == 1) str = "查询成功";
//            Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            return false;
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(runnable).start();

        btn_temp=findViewById(R.id.btn_temp);
        btn_temp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,TempActivity.class);
                startActivity(intent);
            }
        });

        btn_humidity=findViewById(R.id.btn_humidity);
        btn_humidity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,HumidityActivity.class);
                startActivity(intent);
            }
        });

        btn_light=findViewById(R.id.btn_light);
        btn_light.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,LightActivity.class);
                startActivity(intent);
            }
        });

        btn_pressure=findViewById(R.id.btn_pressure);
        btn_pressure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,PressureActivity.class);
                startActivity(intent);
            }
        });

                }

            }


