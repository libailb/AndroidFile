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
    Button btn_temp;
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
            ((TextView)findViewById(R.id.temperature)).setText("温度："+t);
            ((TextView)findViewById(R.id.humidity)).setText("湿度："+h);
            ((TextView)findViewById(R.id.light)).setText("光强："+l);
            ((TextView)findViewById(R.id.pressure)).setText("压力："+p);
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

        btn_temp=findViewById(R.id.btn_start_temp);
        btn_temp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,TempActivity.class);
                startActivity(intent);
            }
        });


                }

            }


