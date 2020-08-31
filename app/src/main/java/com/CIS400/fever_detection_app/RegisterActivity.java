package com.CIS400.fever_detection_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.CIS400.fever_detection_app.data.Student;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.FindListener;

public class RegisterActivity extends BaseActivity {

    private static final String TAG = "RegisterActivity";
    private EditText nameText, uidText, pwdText, rpwdText, ageText, phoneText;
    private String gender;
    private Button createBtn;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String pwd1, pwd2;
    private String UidString, pwdString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bmob.initialize(this, "2de9dc3c787359faf54d36e92a2bbfb0");
        nameText = (EditText) findViewById(R.id.input_name);
        uidText = (EditText) findViewById(R.id.input_id);
        pwdText = (EditText) findViewById(R.id.input_password);
        rpwdText = (EditText) findViewById(R.id.input_reEnterPassword);
        ageText = (EditText) findViewById(R.id.input_age);
        phoneText = (EditText) findViewById(R.id.input_mobile);
        radioGroup = (RadioGroup) findViewById(R.id.radioSex);
        int selectedID = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedID);
        gender = radioButton.getText().toString();
        createBtn = (Button) findViewById(R.id.btn_signup);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pwd1 = pwdText.getText().toString().trim();
                pwd2 = rpwdText.getText().toString().trim();

                if (TextUtils.isEmpty(nameText.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Name cannot be empty", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(uidText.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Net ID cannot be empty", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(ageText.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Age cannot be empty", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(phoneText.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Phone number cannot be empty", Toast.LENGTH_SHORT).show();
                }

                if (gender.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please select your gender", Toast.LENGTH_SHORT).show();
                }
                if (pwd1.equals("") || pwd2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (pwd1.equals(pwd2)) {
                    isRegistered();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else if (pwd1.compareTo(pwd2) != 0) {
                    Toast.makeText(getApplication(), "Two password inputs are not same, Please retry", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void doRegistration() {
        BmobQuery<Student> query = new BmobQuery<Student>();
        Student std = new Student();
        std.setName(nameText.getText().toString());
        std.setId(uidText.getText().toString());
        std.setPwd(pwdText.getText().toString());
        std.setAge(Integer.parseInt(ageText.getText().toString()));
        std.setPhoneNum(phoneText.getText().toString());
        std.setGender(gender);
        std.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Toast.makeText(getApplicationContext(),"Registration succeeded", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void isRegistered(){
        BmobQuery<Student> query = new BmobQuery<Student>();
        query.addWhereEqualTo("id", uidText.getText().toString());
        query.setLimit(1);
        query.findObjects(new FindListener<Student>() {
            @Override
            public void done(List<Student> list, BmobException e) {
                if(e == null){
                    if(list == null || list.size() == 0){
                        doRegistration();
                    }else{
                        Toast.makeText(getApplicationContext(), "This user has registered", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}