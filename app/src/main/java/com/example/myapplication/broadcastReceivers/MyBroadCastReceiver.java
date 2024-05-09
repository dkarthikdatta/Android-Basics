package com.example.myapplication.broadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Objects;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentPackage = intent.getPackage();

        if(!isTrustedPackage(intentPackage)){
            return;
        }
        if(Objects.equals(intent.getAction(), "android.intent.action.AIRPLANE_MODE")){
            System.out.println("Airplane mode changed");
        }
    }

    private boolean isTrustedPackage(String intentPackage) {
        return Objects.equals(intentPackage, "MyTrustedPackage");
    }
}
