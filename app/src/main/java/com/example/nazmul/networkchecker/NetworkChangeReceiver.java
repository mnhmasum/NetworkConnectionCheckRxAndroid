package com.example.nazmul.networkchecker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private Context mContext;

    @Override
    public void onReceive(final Context context, final Intent intent) {
        this.mContext = context;
        Toast.makeText(context, "Status changed", Toast.LENGTH_SHORT).show();

        if (checkConnection(mContext)) {
            App.get().bus().send("True");

        } else {
            App.get().bus().send("False");

        }

    }

    public static boolean checkConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean mIsConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return mIsConnected;
    }

}