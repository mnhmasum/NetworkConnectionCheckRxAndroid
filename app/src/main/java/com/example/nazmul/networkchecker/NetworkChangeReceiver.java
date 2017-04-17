package com.example.nazmul.networkchecker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private Context mContext;
    private boolean mIsConnected = false;

    @Override
    public void onReceive(final Context context, final Intent intent) {
        this.mContext = context;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        mIsConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (mIsConnected) {
            App.get().bus().send("True");

        } else {
            App.get().bus().send("False");

        }

    }

}