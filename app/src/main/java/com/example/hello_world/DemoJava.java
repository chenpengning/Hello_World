package com.example.hello_world;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by ChenPengNing on 2018/1/9.
 */
public class DemoJava {
    //Observable<String> send = null ;
    public static void main(String[] args) {

        Observable<String> send = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("--------this is onNext()");
                subscriber.onCompleted();

            }
        });
        send.subscribe(recever);
    }

    private static Observer<String> recever = new Observer<String>() {
        @Override
        public void onCompleted() {
            System.out.println("----------onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            System.out.println("----------onError");
        }

        @Override
        public void onNext(String o) {
            System.out.println("----------onNext");
        }
    };


}
