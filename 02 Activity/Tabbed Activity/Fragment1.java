package com.example.tabswithfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_layout, container, false);
    }
}

/*
inflater – The LayoutInflater object that can be used to inflate any views in the fragment.

@Nullable
ViewGroup container
container – If non-null, this is the parent view that the fragment's UI should be attached to. 
The fragment should not add the view itself, but this can be used to generate the LayoutParams of the view.
*/
