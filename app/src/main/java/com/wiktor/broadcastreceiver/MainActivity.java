package com.wiktor.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView textView;

    private static final String LOG_TAG = "qwertyu";
    final String CLASS_NAME = "MainActivity";

    public static final String ACTION_TEST = "TEST";
    public static final String ALARM_MESSAGE = "Срочно пришлите кота!";

    private MessageReceiver receiver = new MessageReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "onCreate");

        textView = findViewById(R.id.textViewHelloWorld);
        button = findViewById(R.id.buttonTestSend);
        button.setOnClickListener(this);

        registerBroadcastReceiver();


/*        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);*/

    }

    @Override
    public void onClick(View v) {
        textView.setText("Test");

        sendMessage(v);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION_TEST);
        intent.putExtra("ru.alexanderklimov.broadcast.Message", ALARM_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }


    public void registerBroadcastReceiver() {

        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "registerBroadcastReceiver");

        this.registerReceiver(receiver, new IntentFilter(
                ACTION_TEST));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + ACTION_TEST);

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.AIRPLANE_MODE"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.intent.action.AIRPLANE_MODE");

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.MEDIA_SCANNER_SCAN_FILE"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.intent.action.MEDIA_SCANNER_SCAN_FILE");

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.ACTION_NEW_PICTURE"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.intent.action.ACTION_NEW_PICTURE");

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.ACTION_POWER_DISCONNECTED"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.intent.action.ACTION_POWER_DISCONNECTED");

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.ACTION_POWER_CONNECTED"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.intent.action.ACTION_POWER_CONNECTED");

        this.registerReceiver(receiver, new IntentFilter(
                "miui.intent.TAKE_SCREENSHOT"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "miui.intent.TAKE_SCREENSHOT");

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.TAKE_SCREENSHOT"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.intent.TAKE_SCREENSHOT");

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.BATTERY_CHANGED"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.intent.action.BATTERY_CHANGED");

        this.registerReceiver(receiver, new IntentFilter(
                "android.media.VOLUME_CHANGED_ACTION"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.media.VOLUME_CHANGED_ACTION");


        this.registerReceiver(receiver, new IntentFilter(
                "android.media.ACTION_MEDIA_SCANNER_SCAN_FILE"));
        Log.i(LOG_TAG, CLASS_NAME + "   ---   " + "android.media.ACTION_MEDIA_SCANNER_SCAN_FILE");

    }
}