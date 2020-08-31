package com.CIS400.fever_detection_app.data;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

public class Student extends BmobObject {
    private String id;
    private String name;
    private String pwd;
    private int age;
    private String gender;
    private String phoneNum;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
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
