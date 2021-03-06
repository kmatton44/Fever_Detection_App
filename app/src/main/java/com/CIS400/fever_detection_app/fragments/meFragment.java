package com.CIS400.fever_detection_app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.CIS400.fever_detection_app.R;
import com.CIS400.fever_detection_app.activity.ContactsLogActivity;
import com.CIS400.fever_detection_app.activity.HeartRateLogActivity;
import com.CIS400.fever_detection_app.activity.LoginActivity;
import com.CIS400.fever_detection_app.activity.MeChangePasswordActivity;
import com.CIS400.fever_detection_app.activity.MeChangePhoneNumActivity;
import com.CIS400.fever_detection_app.data.MyUser;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class meFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        Bmob.initialize(getActivity(), "2de9dc3c787359faf54d36e92a2bbfb0");
        RelativeLayout heart_rate = (RelativeLayout) view.findViewById(R.id.RelativeLayout_Heart_Rate);
        RelativeLayout contacts = (RelativeLayout) view.findViewById(R.id.RelativeLayout_Contacts);
        RelativeLayout change_password = (RelativeLayout) view.findViewById(R.id.RelativeLayout_Change_Password);
        RelativeLayout change_phoneNum = (RelativeLayout) view.findViewById(R.id.RelativeLayout_Change_PhoneNum);
        Button logout  = (Button) view.findViewById(R.id.Button_Logout);
        heart_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), HeartRateLogActivity.class));
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ContactsLogActivity.class));
            }
        });

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MeChangePasswordActivity.class));
            }
        });

        change_phoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MeChangePhoneNumActivity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser.logOut();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                Toast.makeText(getContext() , "You have logged out", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
