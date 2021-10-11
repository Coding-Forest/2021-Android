package com.example.bottomsheetex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* In order to control BottomSheet, you need two elements:
1. BottomSheet View,     (UI controller)
2. BottomeSheetBehavior  (Activity controller)

*/

public class MainActivity extends AppCompatActivity {
    
    private BottomSheetBehavior BSBehavior;   // behaviour controller
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
        BSBehavior = BottomSheetBehavior.from(bottomSheet);

        // Bottomsheet status
        TVState = findViewById(R.id.TVstate);

        // When botton 'expand' is clicked, the state will be set to STATE_EXPANDED.
        BTexpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BSBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        // When botton 'collapse' is clicked, the state will be set to STATE_COLLAPSED.
        BTcollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BSBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        // Update the text of the bottom sheet state TV.
        // .setState(): Sets the state of the bottom sheet. The bottom sheet will transition to that state with animation.
        BSBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                        // all states here are static (completed, finished behaviours), hence represented in integers.
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
    
            // Unlike all the above static states, sliding is a dynamic 'process'. 
            // Therefore, it is represented in float.
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                TVState.setText("Sliding~");
                
                // Params - slideOffset:
                // The new offset of this bottom sheet within [-1,1] range. 
                // Offset increases as this bottom sheet is moving upward. 
                // From 0 to 1 the sheet is between collapsed and expanded states and 
                // from -1 to 0 it is between hidden and collapsed states.
            }
        });
    }
}
