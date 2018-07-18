package edu.cvtc.jdiederich2.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyListFragment extends Fragment {


    public MyListFragment() {
        // Required empty public constructor
    }


    @Override
    /* Main activity in charge of controlling this. */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_list, container, false);
    }

}
