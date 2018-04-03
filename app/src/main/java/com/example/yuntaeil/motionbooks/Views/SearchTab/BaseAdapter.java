package com.example.yuntaeil.motionbooks.Views.SearchTab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuntaeil.motionbooks.Model.LibraryModel;
import com.example.yuntaeil.motionbooks.R;

import java.util.List;

/**
 * Created by yuntaeil on 2018. 3. 29..
 */

public class BaseAdapter extends RecyclerView.Adapter
{

    protected Context context;
    public List<LibraryModel> menuDatas;

    public BaseAdapter(Context mContext, List<LibraryModel> ApiDatas)
    {
        this.context = mContext;
        this.menuDatas = menuDatas;
    }

    public  void UpdateDatas(List<LibraryModel> newMenuDatas){
        this.menuDatas = newMenuDatas;
        notifyDataSetChanged();

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_feature, parent, false);

        return new BaseViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder ViewHolder = (BaseViewHolder) holder;
        ViewHolder.Data = menuDatas.get(position);

       // MenuModel menuData = menuDatas.get(position);
       // menuCardViewHolder.BindWithMenuData(menuData);
    }

    @Override
    public int getItemCount() {
        return  (menuDatas != null) ? menuDatas.size() : 0;
    }
}
