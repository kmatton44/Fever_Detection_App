package com.CIS400.fever_detection_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.CIS400.fever_detection_app.data.Student;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;

public class MainActivity extends BaseActivity {
    private EditText uidText, pwdText;
    private Button btnLogin, btnRegister;
    public String result, is;
    private String UidString, pwdString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "2de9dc3c787359faf54d36e92a2bbfb0");
        uidText = (EditText) findViewById(R.id.text_userid);
        pwdText = (EditText) findViewById(R.id.text_userpwd);
        btnLogin = (Button)  findViewById(R.id.button1);
        btnRegister = (Button) findViewById(R.id.button2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //doL
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}