package com.example.frag2frg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    private FragmentBListener listener;
    private EditText ET_b;
    private Button btn_b_ok;

    // To communicate with the underlying activity,
    // we need to create an interface
    public interface FragmentBListener {
        void onInputBSent(CharSequence input);  // passing in String also works. but CharSequence is more general and no need to convert to String.
    }

    // Inflate the layout so that the Fragment knows which layout to show.

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        // container - parent view where the Fragment layout gets its layout parameters.
        // false (attachToRoot) - how the Fragment will be added to the layout.
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        ET_b = v.findViewById(R.id.ET_b);
        btn_b_ok = v.findViewById(R.id.btn_b_ok);
        btn_b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // here we get the input from ET (EditText) and send it to MainActivity, and from there to the other Fragment.
                CharSequence input = ET_b.getText();
                // send input to the MainActivity.
                listener.onInputBSent(input);  // this will be sent to whichever implements this interface.
            }
        });

        return v;  // the v created above with the inflater.
    }

    // this has to be public because we want to fetch the data from inside Activity.
    public void updateET_b(CharSequence newText) {
        ET_b.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {  // our Fragment will be attached to the Activity.
        super.onAttach(context);
        // first check if the Activity implements this interface. (context == Activity)
        if (context instanceof FragmentBListener) {// if Activity implements the instance of an interface...
            listener = (FragmentBListener) context; // this implements the interface in the Activity
        } else {
            throw new RuntimeException(context.toString()
            + " must implement FragmentBListener.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;  // because we don't need this reference to the Activity any longer.
    }
}
