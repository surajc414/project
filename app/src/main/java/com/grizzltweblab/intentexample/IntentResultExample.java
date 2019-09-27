package com.grizzltweblab.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentResultExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result_example);

        Button b1=findViewById(R.id.btn4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str=((EditText)findViewById(R.id.et1)).getText().toString();

                Intent intent=new Intent();
                intent.putExtra("msg",str);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
