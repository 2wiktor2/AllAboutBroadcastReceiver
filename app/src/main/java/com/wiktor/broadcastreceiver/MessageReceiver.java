package com.wiktor.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    private BroadcastReceiver parent;

    public MessageReceiver(BroadcastReceiver parent) {
        this.parent = parent;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        parent.onReceive(context, intent);
    }

/*    @Override
    public void onReceive(Context context, Intent intent) {
        String message = "Обнаружено сообщение "
                + intent.getAction();

        if (intent.getAction().equalsIgnoreCase("android.intent.action.AIRPLANE_MODE")) {

            Toast.makeText(context.getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.MEDIA_SCANNER_SCAN_FILE")) {

            Toast.makeText(context.getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equalsIgnoreCase("cat")) {

            Toast.makeText(context.getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_NEW_PICTURE")) {

            Toast.makeText(context.getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_POWER_DISCONNECTED")) {

            Toast.makeText(context.getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_POWER_CONNECTED")) {

            Toast.makeText(context.getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();
        }
    }*/
}