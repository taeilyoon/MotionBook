
package com.example.yuntaeil.motionbooks.Views.SettingTab;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.yuntaeil.motionbooks.R;
import com.example.yuntaeil.motionbooks.UnlockExampleActivity;
import com.example.yuntaeil.motionbooks.Views.MyPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

public class SettingFragment extends Fragment {

    @OnClick(R.id.Unlock_Example)
    void UnlockExample(){
        Intent intent = new Intent(getActivity(), UnlockExampleActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.OpenSourceLicense)
    void OpenSource(){

    }

    @OnClick(R.id.AppStoreReview)
    void AppStore(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, view);


        return view;

    }





}

