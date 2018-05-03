package com.example.yuntaeil.motionbooks.Views.FeaturedTab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yuntaeil.motionbooks.Helper.DataManager;
import com.example.yuntaeil.motionbooks.Model.LibraryModel;
import com.example.yuntaeil.motionbooks.R;
import com.example.yuntaeil.motionbooks.Views.LibraryDetailView.Library_Detail_Activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hugeterry(http://hugeterry.cn)
 */
public  class MainFragment extends Fragment {
    static MainFragment Instance;
    private RecyclerView mRecyclerView;

    private List<LibraryModel> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;

    public static MainFragment getInstance(String title) {
        MainFragment frag = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        frag.setArguments(bundle);
        return frag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mTitle = bundle.getString(ARG_TITLE);
        Instance = this;
        Log.d(TAG, "onCreate: MainFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_featured_inside, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        initData();
        initFragment();
        return v;

    }

    public void initData() {

        mDatas = new ArrayList<>();
        mDatas.addAll(DataManager.getInstance().LibraryList);

    }


    public void initFragment(){
        Log.d(TAG, "initFragment: !!!");
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecyclerView.setAdapter(new RecyclerAdapter(getContext(), mDatas));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), Library_Detail_Activity.class);
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        getActivity(),
                        new Pair<View, String>(view.findViewById(R.id.card_image),
                                Library_Detail_Activity.VIEW_NAME_HEADER_IMAGE),
                        new Pair<View, String>(view.findViewById(R.id.TitleText),
                                Library_Detail_Activity.VIEW_NAME_HEADER_TITLE));

                //ActivityCompat.startActivity(getActivity(), intent, activityOptions.toBundle());
                Library_Detail_Activity.ShowDetail(mDatas.get(position),getContext(),intent,activityOptions);

               // Library_Detail_Activity.ShowDetail(mDatas.get(position),getContext());
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        }
}

