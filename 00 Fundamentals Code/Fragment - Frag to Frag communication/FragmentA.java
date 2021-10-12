package com.example.frag2frg;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class FragmentA extends Fragment {

    private FragmentAListener listener;
    private EditText ET_a;
    private Button btn_a_ok;

    // To communicate with the underlying activity,
    // we need to create an interface
    public interface FragmentAListener {
        void onInputASent(CharSequence input);  // passing in String also works. but CharSequence is more general and no need to convert to String.
    }

    // Inflate the layout so that the Fragment knows which layout to show.

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        // container - parent view where the Fragment layout gets its layout parameters.
        // false (attachToRoot) - how the Fragment will be added to the layout.
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        ET_a = v.findViewById(R.id.ET_a);
        btn_a_ok = v.findViewById(R.id.btn_a_ok);
        btn_a_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // here we get the input from ET (EditText) and send it to MainActivity, and from there to the other Fragment.
                CharSequence input = ET_a.getText();
                // send input to the MainActivity.
                listener.onInputASent(input);  // this will be sent to whichever implements this interface.
            }
        });

        return v;  // the v created above with the inflater.
    }

    // this has to be public because we want to fetch the data from inside Activity.
    public void updateET_a(CharSequence newText) {
        ET_a.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {  // our Fragment will be attached to the Activity.
        super.onAttach(context);
        // first check if the Activity implements this interface. (context == Activity)
        if (context instanceof FragmentAListener) {// if Activity implements the instance of an interface...
            listener = (FragmentAListener) context; // this implements the interface in the Activity
        } else {
            throw new RuntimeException(context.toString()
            + " must implement FragmentAListener.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;  // because we don't need this reference to the Activity any longer.
    }
}
