package com.example.bottomsheetex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheetBehavior;
    private TextView TVState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons are declared inside onCreate
        // because we don't need them for the whole scope of this Activity.
        Button BTexpand, BTcollapse;
        BTexpand = findViewById(R.id.BTexpand);
        BTcollapse = findViewById(R.id.BTcollapse);

        View bottomSheet = findViewById(R.id.bottom_sheet);

        // Instantiate the behavior from the view.
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        // Bottomsheet status
        TVState = findViewById(R.id.TVstate);

        BTexpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        BTcollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        // Change the text of the bottomsheet state update TV.
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        TVState.setText("Dragging");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        TVState.setText("Settling");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        TVState.setText("Expanded");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        TVState.setText("Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        TVState.setText("Hidden");
                        break;
                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                TVState.setText("Sliding~");
            }
        });
    }
}
