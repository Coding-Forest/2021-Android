package com.example.fragmentanimcomm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    private FrameLayout fragmentContainer;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        editText = (EditText) findViewById(R.id.id_edittext);
        button = (Button) findViewById(R.id.id_button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                openFragment(text);
            }
        });
    }

    public void openFragment(String text) {
        BlankFragment fragment = BlankFragment.newInstance(text);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // first and second arguments are for forward button, third and fourth are for the back button.
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
        // enable back button to close the 'fragment'; the activity will be closed completely otherwise.
        transaction.addToBackStack(null);
        // the fragment actually gets executed by .commit()
        transaction.add(R.id.fragment_container, fragment, "BLANK_FRAGMENT").commit();
    }

    @Override
    public void onFragmentInteraction(String sendBackText) {
        editText.setText(sendBackText);
        onBackPressed();
    }
}