package com.example.hello_world;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;


public class MainActivity extends AppCompatActivity {

    private  int a = 0 ;
    private String name ="liudehua";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    protected void onResume() {
        super.onResume();

        Observable<String> sender = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("Hi，Weavey！");  //发送数据"Hi，Weavey！"
            }
        });


        Observer<String> receiver = new Observer<String>() {
            @Override
            public void onCompleted() {

                //数据接收完成时调用
                Log.d("rx"," -------onCompleted!");
                Toast.makeText(MainActivity.this," -------onCompleted!",Toast.LENGTH_LONG ).show();
            }

            @Override
            public void onError(Throwable e) {

                //发生错误调用
                Log.d("rx"," -------onError!");
                Toast.makeText(MainActivity.this," -------onError!",Toast.LENGTH_LONG ).show();
            }

            @Override
            public void onNext(String s) {

                //正常接收数据调用
                Log.d("rx","----------"+s);//将接收到来自sender的问候"Hi，Weavey！"
                Toast.makeText(MainActivity.this,"---"+s,Toast.LENGTH_LONG ).show();
            }
        };

        sender.subscribe(receiver);
    }


    /*public void tx_Rxjava(){



        Observer<String> observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                Log.d("rxjava", "onNext!");
            }

            @Override
            public void onCompleted() {
                Log.d("rxjava", "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("rxjava", "Error!");
            }
        };

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(observer);
    }*/
}
