package com.example.demo_app;

public class LoginPresenter {
    private final LoginInterface mloginInterface;

    public LoginPresenter(LoginInterface mloginInterface) {
        this.mloginInterface = mloginInterface;
    }

    public void Login(User user){
        if(user.isValidName() && user.isValidPassword()){
            mloginInterface.loginSuccess();
        }
        else{
            mloginInterface.loginError();
        }
    }
}
