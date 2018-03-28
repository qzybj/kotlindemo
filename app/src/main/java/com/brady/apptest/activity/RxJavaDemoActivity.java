package com.brady.apptest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.brady.apptest.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zyb
 *
 * @date 2017/12/12
 * @description
 */
public class RxJavaDemoActivity extends Activity {

    public final static String TAG = "Observable";
    private Person tmp = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_activity);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {

        Observable.create(new ObservableOnSubscribe<Person>() {
            @Override
            public void subscribe(ObservableEmitter<Person> emitter) throws Exception {
                for (int i = 0; i < 5; i++) {
                    emitter.onNext(getPerson(""+i,"name"+i));
                }
                emitter.onComplete();
            }
        }).subscribe(new Observer<Person>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(Person value) {
                Log.d(TAG, "" + value);
                tmp =value;
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
                Log.d(TAG, tmp.toString());
            }
        });

    }
    public Person getPerson(String id, String name){
        return new Person(id,name);
    }

    class Person {
        private String id;
        private String name;

        public Person( String id,String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
