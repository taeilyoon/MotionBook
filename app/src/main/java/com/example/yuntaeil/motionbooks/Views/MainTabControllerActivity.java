package com.example.yuntaeil.motionbooks.Views;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.yuntaeil.motionbooks.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import devlight.io.library.ntb.NavigationTabBar;

/**
 * Created by yuntaeil on 2018. 3. 27..
 */

public class MainTabControllerActivity extends AppCompatActivity {
        public static MainTabControllerActivity instance;

        @BindView(R.id.pager)
        public ViewPager viewPager;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            instance = this;


            setTheme(R.style.AppTheme);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);

            InitTabBar();
        }



        private void InitTabBar() {
            PagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapter);

            final String[] colors = getResources().getStringArray(R.array.default_preview);

            final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(
                    R.id.ntb_horizontal);

            final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
            models.add(
                    new NavigationTabBar.Model.Builder(
                            getResources().getDrawable(R.drawable.ic_launcher_background),
                            Color.parseColor(colors[0]))
                            .title("Featured")
                            .badgeTitle("New")
                            .build()
            );
            models.add(
                    new NavigationTabBar.Model.Builder(
                            getResources().getDrawable(R.drawable.ic_launcher_background),
                            Color.parseColor(colors[0]))

                            .title("Search")
                            .badgeTitle("with")
                            .build()
            );
            models.add(
                    new NavigationTabBar.Model.Builder(
                            getResources().getDrawable(R.drawable.ic_launcher_background),
                            Color.parseColor(colors[0]))

                            .title("Bookmark")
                            .badgeTitle("with")
                            .build()
            );
            models.add(
                    new NavigationTabBar.Model.Builder(
                            getResources().getDrawable(R.drawable.ic_launcher_background),
                            Color.parseColor(colors[0]))

                            .title("Setting")
                            .badgeTitle("with")
                            .build()
            );

            navigationTabBar.setModels(models);
            navigationTabBar.setViewPager(viewPager);
            navigationTabBar.setIsBadged(true);
            navigationTabBar.setBehaviorEnabled(true);


            navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
            {
                @Override
                public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(final int position) {
                    navigationTabBar.getModels()
                            .get(position)
                            .hideBadge();
                }

                @Override
                public void onPageScrollStateChanged(final int state) {

                }
            });

            navigationTabBar.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    for (int i = 0; i < navigationTabBar.getModels()
                            .size(); i++) {
                        final NavigationTabBar.Model model = navigationTabBar.getModels()
                                .get(i);
                        navigationTabBar.postDelayed(new Runnable()
                        {
                            @Override
                            public void run() {
                                model.showBadge();
                            }
                        }, i * 100);
                    }
                }
            }, 500);
        }



        void SetTabIconAsSelected(TabLayout.Tab tab) {
            int tabIconColor = (ContextCompat.getColor(getApplicationContext(),
                    R.color.tabUnselectedIconColor));
            tab.getIcon()
                    .setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        }


        void SetTabIconAsUnSelected(TabLayout.Tab tab) {
            int tabIconColor = (ContextCompat.getColor(getApplicationContext(),
                    R.color.tabUnselectedIconColor));
            tab.getIcon()
                    .setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        }


        //endregion


        //region confirm exit app


        @Override
        public void onBackPressed() {
            AskIfQuitApp();
        }

        void AskIfQuitApp(){
//            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
//                    .setTitleText(getString(R.string.quit_app_title))
//                    .setContentText(getString(R.string.quit_app_content))
//                    .setCancelText(getString(R.string.quit_app_cancel))
//                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sDialog) {
//                            sDialog.cancel();
//                        }
//                    })
//
//                    .setConfirmText(getString(R.string.quit_app_confirm))
//                    .setConfirmClickListener (new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sDialog) {
//                            sDialog.dismissWithAnimation();
//                            finish();
//                        }
//                    }).show();
        }


}
