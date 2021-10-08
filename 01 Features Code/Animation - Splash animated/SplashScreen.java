// This is my practice code I tried watching a tutorial by Android Coding. 
// Source code (https://www.youtube.com/watch?v=OARIq17u12g&ab_channel=AndroidCoding)

package com.example.splash2;

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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class SplashScreen extends AppCompatActivity {

    ImageView IVtop, IVheart, IVheartbeat, IVbottom;
    TextView TVappname;
    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Map UI components in the Activity
        IVtop = findViewById(R.id.IVtop);
        IVheart = findViewById(R.id.IVheart);
        IVheartbeat = findViewById(R.id.IVheartbeat);
        IVbottom = findViewById(R.id.IVbottom);
        TVappname = findViewById(R.id.TVappname);

        // Set full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Initialise top animation
        Animation anim_top = AnimationUtils.loadAnimation(this, R.anim.top_wave);
        // Start animation.
        IVtop.setAnimation(anim_top);

        // Initialise object animator
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                IVheart,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f)
        );

        // Set duration
        objectAnimator.setDuration(500);
        // Set repeat count
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        // Set repeat mode
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        // Start animator
        objectAnimator.start();

        // Call animateText()
        animateText("Heart Beat");

        // Load GIF
        Glide.with(this).load("@drawable/heart_beat.gif")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(IVheartbeat);

        // Initialise bottom animation
        Animation anim_bottom = AnimationUtils.loadAnimation(this,
                R.anim.bottom_wave);
        // Start bottom animation
        IVbottom.setAnimation(anim_bottom);

        // Initialise handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Redirect to main activity
                startActivity(new Intent(SplashScreen.this,
                        MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                // Finish activity
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
            if (index <=charSequence.length()) {
                // When index is equal to text length
                // Run handler
                handler.postDelayed(runnable, delay);
            }
        }
    };

    // Create animated text method
    public void animateText(CharSequence cs) {
        // Set text
        charSequence = cs;
        // Clear index
        index = 0;
        // Clear text
        TVappname.setText("");
        // Remove call back
        handler.removeCallbacks(runnable);
        // Run Handler
        handler.postDelayed(runnable, delay);
    }
}
