package com.example.demo_app;

import android.text.TextUtils;
import android.util.Patterns;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isValidName(){
        return !TextUtils.isEmpty(name) && Patterns.EMAIL_ADDRESS.matcher(name).matches();
    }
    public boolean isValidPassword(){
        return  !TextUtils.isEmpty(password) && password.length() >= 6;
    }
}
