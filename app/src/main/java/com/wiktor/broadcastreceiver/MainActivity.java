package com.wiktor.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView textView;

    public static final String WHERE_MY_CAT_ACTION = "CAT";
    public static final String ALARM_MESSAGE = "Срочно пришлите кота!";

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("qwertyu", "Received: " + intent.getAction() + " " + context.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewHelloWorld);
        button = findViewById(R.id.buttonTestSend);
        button.setOnClickListener(this);

        registerBroadcastReceiver();


        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onClick(View v) {
        textView.setText("Click");

        sendMessage(v);


        Intent intent = new Intent();
        for (Field field : intent.getClass().getDeclaredFields()) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers) &&
                    Modifier.isStatic(modifiers) &&
                    Modifier.isFinal(modifiers) &&
                    field.getType().equals(String.class)) {

                String filter = null;
                try {
                    filter = (String) field.get(intent);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                Log.i("qwertyu", "Registered: " + filter);
                this.registerReceiver(new MessageReceiver(receiver), new IntentFilter(filter));
            }
        }

    }

    public void sendMessage(View view) {
        Intent intent = new Intent();
        intent.setAction(WHERE_MY_CAT_ACTION);
        intent.putExtra("ru.alexanderklimov.broadcast.Message", ALARM_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }


    public void registerBroadcastReceiver() {
        this.registerReceiver(receiver, new IntentFilter(
                WHERE_MY_CAT_ACTION));

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.AIRPLANE_MODE"));

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.MEDIA_SCANNER_SCAN_FILE"));

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.ACTION_NEW_PICTURE"));

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.ACTION_POWER_DISCONNECTED"));

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.ACTION_POWER_CONNECTED"));

        this.registerReceiver(receiver, new IntentFilter(
                "android.intent.action.ACTION_POWER_CONNECTED"));

        this.registerReceiver(receiver, new IntentFilter(
                "miui.intent.TAKE_SCREENSHOT"));

    }
}