package com.example.bottomsheet_modal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomSheetDialog.BottomSheetListner {

    private TextView mTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTV = findViewById(R.id.ID_TV_clickState);

        Button BTopen = findViewById(R.id.ID_BT_open);
        BTopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open BottomSheetDialog
                BottomSheetDialog bottomSheet = new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(), "Dialog");
            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        mTV.setText(text);
    }
}
