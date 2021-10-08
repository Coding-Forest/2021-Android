package com.example.testsplash_faceid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView IVminion, IVcircle;
    TextView TVappname;
    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        IVminion = findViewById(R.id.minion);
        TVappname = findViewById(R.id.appname);
        IVcircle = findViewById(R.id.circle);

        // Set full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Animate minion
        ObjectAnimator oba = ObjectAnimator.ofPropertyValuesHolder(
                IVminion,
                PropertyValuesHolder.ofFloat("scaleX", 0.75f),
                PropertyValuesHolder.ofFloat("scaleY", 0.75f)
        );

        oba.setDuration(1000);
        oba.setRepeatMode(ValueAnimator.RESTART);
        oba.start();

        animateText("Minionese\nTranslator");

        // Animate bottom circle
        Animation anim_circle = AnimationUtils.loadAnimation(this, R.anim.circle);
        IVcircle.setAnimation(anim_circle);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,
                        MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        }, 4000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // When a Runnable runs
            // set text
            TVappname.setText(charSequence.subSequence(0, index++));
            // Check condition
            if (index <= charSequence.length()) {
                handler.postDelayed(runnable, delay);
            }
        }
    };

    public void animateText(CharSequence cs) {
        charSequence = cs;
        index = 0;

        TVappname.setText("");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, delay);
    }
}
