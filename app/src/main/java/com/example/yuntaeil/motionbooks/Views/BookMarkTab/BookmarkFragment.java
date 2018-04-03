package com.example.yuntaeil.motionbooks.Views.BookMarkTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuntaeil.motionbooks.R;

import butterknife.ButterKnife;

public class BookmarkFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);
        ButterKnife.bind(this, view);


        return view;

    }





}

