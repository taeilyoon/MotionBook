package com.example.yuntaeil.motionbooks.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.yuntaeil.motionbooks.Views.BookMarkTab.BookmarkFragment;
import com.example.yuntaeil.motionbooks.Views.FeaturedTab.FeaturedFragment;
import com.example.yuntaeil.motionbooks.Views.SearchTab.SeachFragment;
import com.example.yuntaeil.motionbooks.Views.SettingTab.SettingFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter
{

        private static final String TAG = "MainPagerAdapter";

        public MainPagerAdapter(FragmentManager fm) {
                super(fm);
        }


        @Override
        public int getCount() {
                return MainTabsType.values().length;
        }

        Fragment featuredViewFragment = new FeaturedFragment();
        Fragment searchViewFragment = new SeachFragment();
        Fragment bookmarkViewFragment = new BookmarkFragment();
        Fragment settingViewFragment = new SettingFragment();




        @Override
        public Fragment getItem(int position) {
                MainTabsType tabType = MainTabsType.MainTabsPositionMapping.get(position);
                Log.d(TAG, "tab == null : " + (tabType  == null));
                Log.d(TAG, "position : " + position + ", tab : " + tabType);


                switch (tabType)
                {
                        case Featured:
                                     return featuredViewFragment;
                        case Search:
                                return searchViewFragment;
                        case BookMark:
                                return bookmarkViewFragment;
                        case Setting:
                                return settingViewFragment;
                        default:
                                return null;
                }
        }


}
