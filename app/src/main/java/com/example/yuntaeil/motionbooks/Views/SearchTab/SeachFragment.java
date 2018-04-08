package com.example.yuntaeil.motionbooks.Views.SearchTab;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yuntaeil.motionbooks.Helper.DataManager;
import com.example.yuntaeil.motionbooks.Model.LibraryModel;
import com.example.yuntaeil.motionbooks.R;
import com.example.yuntaeil.motionbooks.Views.FeaturedTab.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

import static android.content.ContentValues.TAG;

public class SeachFragment extends Fragment {

    @BindView(R.id.SearchView)
    SearchView searchView;

    @BindView(R.id.tagView)
    TagContainerLayout tagView;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    public List<LibraryModel> list = new ArrayList<>();
    public List<String> tagitems = new ArrayList<>();
    SearchRecyclerAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        adapter = new SearchRecyclerAdapter(getContext(),list);


        recyclerview.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(llm);

        initTagview();
        return view;
    }

    public void initTagview(){
        tagitems.add("라이언");
        tagitems.add("For Artist");
        tagitems.add("음란마기");
        tagitems.add("test");
        tagitems.add("오늘 날씨는 흐림");

        tagView.setTags(tagitems);
        tagView.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                Toast.makeText(getContext(),text+"가 클릭 됨", Toast.LENGTH_LONG).show();
                search(text);
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });

    }
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {

        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < DataManager.getInstance().LibraryList.size(); i++)
            {
                if(DataManager.getInstance().LibraryList.get(i).description.contains(charText)||
                        DataManager.getInstance().LibraryList.get(i).title.contains(charText)){
                    list.add(DataManager.getInstance().LibraryList.get(i));
                }

            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
        Log.d(TAG, "search: Seach my name");
    }




}

