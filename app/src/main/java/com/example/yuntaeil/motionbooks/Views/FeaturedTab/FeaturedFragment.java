package com.example.yuntaeil.motionbooks.Views.FeaturedTab;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuntaeil.motionbooks.R;
import com.example.yuntaeil.motionbooks.Views.MyPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

import static android.content.ContentValues.TAG;

public class FeaturedFragment extends Fragment {

    @BindView(R.id.vp)
    ViewPager mViewPager;

    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private static ArrayList<Fragment> mFragments;
    private final String[] mTitles = {"Recycler", "iOS", "Web", "Other"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_featured_home, container, false);
        ButterKnife.bind(this, view);
        Log.d(TAG, "mfragment: "+ mFragments);
            if (mFragments == null) {
                initFragments();
            }else {
                checkFragment();
            }
        initViewPager();
        mImageArray = new int[]{
                R.mipmap.bg,
                R.mipmap.bg_android,
                R.mipmap.bg_js,
                R.mipmap.bg};
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};

        mCoordinatorTabLayout = (CoordinatorTabLayout) view.findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTranslucentStatusBar(getActivity())
                .setTitle("Demo")
                .setBackEnable(true)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);


        Log.d(TAG, "onCreate : " );
        return view;

    }

    private void checkFragment() {
        for (Fragment fragment : mFragments) {
            MainFragment m = (MainFragment) fragment;
            m.initData();
            m.initFragment();
        }
    }


    private void initFragments() {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(MainFragment.getInstance(title));
        }
        Log.d(TAG, "Init FRagment");

    }

    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(4);
        Log.d(TAG, "Init VP" );
        mViewPager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager(), mFragments, mTitles));
    }




}

