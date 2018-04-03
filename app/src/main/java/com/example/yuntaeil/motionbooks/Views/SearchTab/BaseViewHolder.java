package com.example.yuntaeil.motionbooks.Views.SearchTab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yuntaeil.motionbooks.Model.LibraryModel;
import com.example.yuntaeil.motionbooks.R;
import com.felipecsl.gifimageview.library.GifImageView;

/**
 * Created by yuntaeil on 2018. 3. 29..
 */

class BaseViewHolder extends RecyclerView.ViewHolder {

    public TextView TitleTextView;
    public TextView AutherTextView;
    public TextView StarTextView;
    public GifImageView ImageView;
    public TextView DescriptionTextView;
    LibraryModel Data;
    Context context;
    public BaseViewHolder(View itemView, Context context) {
        super(itemView);

        this.context = context;

        TitleTextView = itemView.findViewById(R.id.TitleText);
        AutherTextView = itemView.findViewById(R.id.AutherText);
        StarTextView = itemView.findViewById(R.id.StarText);
        ImageView = itemView.findViewById(R.id.ImageView);
        DescriptionTextView = itemView.findViewById(R.id.DescriptionText);
    }

    public void BindingWithData(LibraryModel model){
        Data = model;
        BindingWithData();

    }
    public void BindingWithData(){

        TitleTextView.setText(Data.title);
        AutherTextView.setText(Data.author);
        StarTextView.setText(Data.gitStar);
    }
}
