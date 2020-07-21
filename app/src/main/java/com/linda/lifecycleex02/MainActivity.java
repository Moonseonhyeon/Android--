package com.linda.lifecycleex02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    private Context mContext = MainActivity.this; //Avtivity마다 context가지고 있다. 이게 MainActivity의 context!
    // 혹시 다음에 다른 곳으로 내 Activity를 가져가거나 할때 도 쓰임.

    private Button btnNum, btnEmail;
    private TextView tvNum, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNum = findViewById(R.id.btn_num);
        btnEmail = findViewById(R.id.btn_email);
        tvNum = findViewById(R.id.tv_num);
        tvEmail = findViewById(R.id.tv_email);

        btnNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SubActivity.class);
                //startActivity(intent); //그냥 이동
                startActivityForResult(intent, 1); // 콜백. intent의 목적지인 SubActivity꺼지면 이 MainActivity로 돌아옴. 아래에 onActivityResult함수 오버라이드 하기
                //서브액티비티2를 누가 켰는지 알게 하려고 위에 requestCode를 남겨놓는 거다.
                //웹으로 생각해보면 http header에 레퍼럴 이라는 속성이 있음. 이전 페이지가 뭔지 알 수 있다.
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SubActivity2.class);
                startActivityForResult(intent, 1);
            }
        });

    }

        // 콜백함수 : 어디서 콜백시켜주는 거냐면 어떤 화면이 딱 꺼지면 아래에에 인수 3개를 받아온다.
    @Override    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==1){//내가 요청해서 받은 게 맞는지 확인하기
            if(resultCode == 10){
                tvNum.setText(data.getStringExtra("number")); //(내가 요청해서 받아 온 데이터의 키값.)
            }else if(resultCode == 20){
                tvEmail.setText(data.getStringExtra("email"));
            }
        }
        Log.d(TAG, "onActivityResult: 콜백받음");
    }


}