package com.grizzltweblab.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), IntentExternalExample.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), IntentInternalExample.class);
                startActivity(intent);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), IntentResultExample.class);
                startActivityForResult(intent, 420);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, ""+requestCode, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+resultCode, Toast.LENGTH_SHORT).show();
//        if(requestCode==420 && Activity.RESULT_OK==resultCode){
//
//            Toast.makeText(this, "Return Valued : "+data.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
//        }




    }

    public void openSettings(View view) {

        Intent intent=new Intent(getApplicationContext(), SettingExample.class);
        startActivity(intent);
    }
}
