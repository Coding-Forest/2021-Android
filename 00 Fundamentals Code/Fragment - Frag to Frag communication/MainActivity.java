package com.example.frag2frg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentA)
                .replace(R.id.container_b, fragmentB)
                .commit();
    }

    // In order to get the data from the Fragments to MainActivity,
    // the interfaces have to be implemented.

    // Calling a public method on Fragment is one way to send data.
    // Another way is to create a new instance and send the data while creating the Fragment.
    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateET_b(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateET_a(input);
    }
}