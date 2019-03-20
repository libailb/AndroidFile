package test.app.libai.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PressureActivity extends Activity {
    Button btn_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        btn_main=findViewById(R.id.btn_start_temp);
        btn_main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在这里转到对应的Activity
                Intent intent = new Intent();
                intent.setClass(PressureActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
