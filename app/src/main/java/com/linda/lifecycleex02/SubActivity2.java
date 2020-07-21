package com.linda.lifecycleex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity2 extends AppCompatActivity {
    private static final String TAG = "SubActivity2";

    private EditText etNum;
    private Button btnNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        etNum = findViewById(R.id.et_num);
        btnNum = findViewById(R.id.btn_num);
        btnNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("email", etNum.getText().toString());
                setResult(20, intent);
                finish();
            }
        });


    }
}