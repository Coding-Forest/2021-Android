package com.example.bottomsheet_modal;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    // 3) Create a member variable for the BottomSheetListner.
    private BottomSheetListner mListener;
    // 4-1) Then we have to assign this variable to the Activity where we want to send out button clicks to.

    // First, define that we want to use the custom layout (bottom_sheet_layout.xml).
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);

        // 1) Associate the resource idea of the custom layout.
        // Note that it is not R.id but R.layout.layout_name.
        // This is standard for Fragments, as FragmentManager will add the View to the container.
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        Button BT1 = v.findViewById(R.id.BT1);
        Button BT2 = v.findViewById(R.id.BT2);

        // This is how we communicate from the fragment back to the underlying activity.
        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("Button 1 clicked");  // this string will be sent to MainActivity and associated with TextView for MainActivity.
                dismiss();
            }
        });

        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("Button 2 clicked");  // verbatim for Button 2.
                dismiss();
            }
        });

        return v;
    }

    // 2) Here need to create an interface.
    public interface BottomSheetListner {
        void onButtonClicked(String text);
    }

    // Dialog. When we open this Dialog in the MainActivity,
    // the context will be MainActivity.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Associate the context to this Listener
        // Later we will implement this Listener in the MainActivity.

        // * read below
        try {
            // so cast context into the BSListener interface.
            mListener = (BottomSheetListner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + " must implement BottomSheetListener");

            // * What is happening in this try catch block?
            // When we try to open this in the MainActivity and
            // we forgot to implement the interface into the Activity,
            // the app will crash and you get this error message.
        }


    }
}
