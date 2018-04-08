package com.example.yuntaeil.motionbooks.Views.SearchTab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuntaeil.motionbooks.Model.LibraryModel;
import com.example.yuntaeil.motionbooks.R;

import java.util.List;

/**
 * Cre®ated by hugeterry(http://hugeterry.cn)
 */

public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchRecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private List<LibraryModel> mDatas;

    public SearchRecyclerAdapter(Context context, List<LibraryModel> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.card_full_width, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.TitleText.setText(mDatas.get(position).title);
        holder.AuthorText.setText(mDatas.get(position).author);
        holder.StarText.setText(""+(mDatas.get(position).gitStar));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView TitleText;
        TextView AuthorText;
        TextView StarText;
        TextView NEWText;

        public MyViewHolder(View view) {
            super(view);
            TitleText = (TextView) view.findViewById(R.id.TitleText);
            AuthorText = view.findViewById(R.id.AutherText);
            StarText = view.findViewById(R.id.StarText);
            NEWText = view.findViewById(R.id.NEWText);
        }
    }
}