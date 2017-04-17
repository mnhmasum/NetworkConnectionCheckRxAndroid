package com.example.nazmul.networkchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private Subscription busSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        /*autoUnsubBus();
        busSubscription = App.get().bus().stringBus.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("MainActivity", ":::: " + s);
                Toast.makeText(MainActivity.this, "event bus: " + s, Toast.LENGTH_SHORT).show();
            }
        });*/

        autoUnsubBus();
        busSubscription = App.get().bus().toObserverable().observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String event) {
                        textView.setText(event);
                        //Toast.makeText(MainActivity.this, "Simple event bus: " + event, Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void autoUnsubBus() {
        if (busSubscription != null && !busSubscription.isUnsubscribed()) {
            busSubscription.unsubscribe();
        }
    }


}
