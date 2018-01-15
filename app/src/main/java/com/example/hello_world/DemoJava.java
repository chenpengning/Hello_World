package com.example.hello_world;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.Subject;

/**
 * Created by ChenPengNing on 2018/1/9.
 */
public class DemoJava {
    //Observable<String> send = null ;

    private static String[]  strs = new String[]{"aad","ber","cdf","ddf","pcf","pcf","zzvg"};

    private static List<String> lisStrs = new ArrayList<String>();




    public static void main(String[] args) {

        /*Observable<String> send = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("--------this is onNext()");
                subscriber.onCompleted();
            }
        });*/
        //send.subscribe(recever);

        /*测试集合过滤代码*/
        //filterText();
        /*测试选取开始take或者结尾takelast几个对象过滤代码*/
        //filterTake();


        //sampleText();





    }

    private static void sampleText() {

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                int count = 10 ;

                while (count > 0){

                    try {



                        Thread.sleep(601);
                        System.out.println("---6-onCompleted=");
                        subscriber.onNext(count+10000);

                        Thread.sleep(500);
                        System.out.println("--4--onCompleted=");
                        subscriber.onNext(count+10000);

                        Thread.sleep(700);
                        System.out.println("---8-onCompleted=");
                        subscriber.onNext(count+10000);
                        count--;

                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                }



            }
        }).sample(600,TimeUnit.MILLISECONDS).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("----onCompleted=");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("----onError=");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("----integer="+integer);
            }
        });

    }


    private static void filterTake() {
        /*测试延时发送sample()*/
        Observable.from(strs).throttleFirst(1, TimeUnit.HOURS).subscribe(new Observer<String>() {

        /*测试选取elementAtOrDefault()*/
        //Observable.from(strs).elementAtOrDefault(12,"5").subscribe(new Observer<String>() {

        /*测试选取first() and last()*/
       // Observable.from(strs).first().subscribe(new Observer<String>() {

            /*测试选取distinctUntilChanged()
        /*Observable.from(strs).distinctUntilChanged().subscribe(new Observer<String>(){*/

        /*Observable.from(strs).takeLast(3).repeat(2).distinct().subscribe(new Observer<String>() {*/

            @Override
            public void onCompleted() {
                System.out.println("----onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("----onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("--onNext()--s="+s);
            }
        });
    }

    private static void filterText() {

       /* lisStrs.add("aad");
        lisStrs.add("ber");
        lisStrs.add("cdf");
        lisStrs.add("pcf");
        lisStrs.add("zzvg");*/

        Observable.from(strs).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                System.out.println("--call--s="+s);
                return s.startsWith("c");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("----onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("----onError()");
            }

            @Override
            public void onNext(String s) {
                System.out.println("--onNext()--s="+s);
            }
        });
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

    public int getValue(){


        return 1;
    }


}
