package com.example.hello_world;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BinderServiceMode extends Service {
    private static final String TAG = "BinderServiceMode" ;

    public MyBinder myBinder = new MyBinder();

    public BinderServiceMode() {
    }

    class MyBinder extends Binder {

        public void setmyBinderValue(String name){
            Log.d(TAG,"name="+name);
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder ;
        //throw new UnsupportedOperationException("Not yet implemented");

    }
}
