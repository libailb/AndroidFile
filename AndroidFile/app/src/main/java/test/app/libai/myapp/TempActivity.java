package test.app.libai.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 温度显示界面
 */
public class TempActivity extends Activity {
    Button btn_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        btn_main=findViewById(R.id.btn_start_temp);
        btn_main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(TempActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
