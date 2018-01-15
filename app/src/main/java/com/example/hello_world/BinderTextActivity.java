package com.example.hello_world;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BinderTextActivity extends AppCompatActivity {

    public BinderServiceMode.MyBinder myBinder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_text);

        Button button = (Button) findViewById(R.id.bindButton);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(null != myBinder){
                        myBinder.setmyBinderValue("this binder text ....");
                    }

                }
            });
        }


        Intent intent = new Intent(BinderTextActivity.this,BinderServiceMode.class);
        bindService(intent,con, Service.BIND_AUTO_CREATE);
    }

    public ServiceConnection con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder =(BinderServiceMode.MyBinder)service;

            if(null != myBinder){
                Log.d("tag","---onCreate---recevice binder infomation ...!");
                myBinder.setmyBinderValue("this is text binderService...");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
