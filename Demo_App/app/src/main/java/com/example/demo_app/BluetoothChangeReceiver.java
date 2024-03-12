package com.example.demo_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class BluetoothChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(isBluetoothModeOn(context.getApplicationContext())){
            Toast.makeText(context,"Bluetooth is on",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Bluethooth is off",Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isBluetoothModeOn(Context context){
        return Settings.System.getInt(context.getContentResolver(),Settings.Global.BLUETOOTH_ON,0)!=0;
    }
}
