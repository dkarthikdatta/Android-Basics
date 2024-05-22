package com.example.myapplication.sdk;

import android.content.Context;

public class MYSDK {

    private static volatile MYSDK INSTANCE;

    private MYSDK() {

    }
    private static MyDb myDb;
    private static EventProcessor eventProcessor;

    public static MYSDK getINSTANCE(Context context) {
        if (INSTANCE == null) {
            synchronized (MyDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MYSDK();
                    myDb = new MyDb(context);
                    eventProcessor = new EventProcessor(myDb);
                }
            }
        }
        return INSTANCE;
    }

    public void sendEvent(String studentName, int id){
        eventProcessor.processEvent(new Student(id, studentName), id);
    }
}
