package com.wiktor.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    private static final String LOG_TAG = "qwertyu";
    final String CLASS_NAME = "MessageReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "onReceive" + "        --------------------------");

        String message = "Обнаружено сообщение "
                + intent.getAction();

        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "onReceive" + "   ---   " + message);


        if (intent.getAction().equalsIgnoreCase("android.intent.action.AIRPLANE_MODE")) {

        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.MEDIA_SCANNER_SCAN_FILE")) {

        } else if (intent.getAction().equalsIgnoreCase("TEST")) {

            Toast.makeText(context.getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();
            Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "                                           onReceive " + message);
        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_NEW_PICTURE")) {

        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_POWER_DISCONNECTED")) {

        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_POWER_CONNECTED")) {

        } else if (intent.getAction().equalsIgnoreCase("miui.intent.TAKE_SCREENSHOT")) {

        } else if (intent.getAction().equalsIgnoreCase("android.intent.TAKE_SCREENSHOT")) {

        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.BATTERY_CHANGED")) {

        } else if (intent.getAction().equalsIgnoreCase("android.media.VOLUME_CHANGED_ACTION")) {

        }
    }
}