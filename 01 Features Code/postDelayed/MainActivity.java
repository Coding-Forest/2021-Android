package com.example.delayedpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int delay = 2000;
    Button BTstart, BTstop;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // We assign these methods to our Buttons.
    // We must pass a View into the method, otherwise it will crash.
    public void startRepeat(View v) {
        // mHandler.postDelayed(mToastRunnable, delay);
        mToastRunnable.run();
    }

    public void stopRepeat(View v) {
        mHandler.removeCallbacks(mToastRunnable);
        Toast.makeText(MainActivity.this, "Repeat terminated", Toast.LENGTH_SHORT).show();
    }

    // Create a private Runnable
    // When a Runnable object is created, it comes in a package with a function which it will run.
    // the keyword 'this' will point to the object that is closest to itself: meaning,
    // the inner most object or method that encloses it.
    // so without being preceded by 'MainActivity', this will point to this Runnable.
    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this, String.format("Toast appearing after %x seconds", delay), Toast.LENGTH_SHORT).show();
            mHandler.postDelayed(this, delay);      // 'this' will run mToast Runnable again.
        }
    };
}
