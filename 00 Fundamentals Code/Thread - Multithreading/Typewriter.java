package com.example.typewriter;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Typewriter extends androidx.appcompat.widget.AppCompatTextView {

    private CharSequence text;
    private int index;
    private long delay = 5000;
    private Handler handler = new Handler();

    public Typewriter(Context context) {
        super(context);
    }

    public Typewriter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private Runnable charConcatenator = new Runnable() {
        @Override
        public void run() {
            setText(text.subSequence(0, index++));
            if (index <= text.length()){
                handler.postDelayed(charConcatenator, delay);
            }
        }
    };

    public void animateText(CharSequence cs) {
        text = cs;
        index = 0;

        // reset text
        setText("");
        // Clear MessageQueue to prioritise animating Text.
        handler.removeCallbacks(charConcatenator);
        handler.postDelayed(charConcatenator, delay);
    }

    public void setCharacterDelay(long m) {
        delay = m;
    }

    void runNext() {

    }

}
