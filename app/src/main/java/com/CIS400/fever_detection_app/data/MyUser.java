package com.CIS400.fever_detection_app.data;

import cn.bmob.v3.BmobUser;

public class MyUser extends BmobUser {
    private int age;
    private String gender;
    private String phoneNum;

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
}
