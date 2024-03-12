package com.example.demo_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(isAirPlaneModeOn(context.getApplicationContext())){
            Toast.makeText(context,"AirPlane mode is on",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(context,"AirPlane mode is off",Toast.LENGTH_LONG).show();
        }
    }
    private static boolean isAirPlaneModeOn(Context context){
        return Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0) !=0;
    }

    public static class LoginPresenter {
        public void Login(User user){
            if(user.isValidName() && user.isValidPassword()){

            }
            else{

            }
        }
    }
}
