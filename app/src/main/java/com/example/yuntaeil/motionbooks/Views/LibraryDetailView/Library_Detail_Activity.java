package com.example.yuntaeil.motionbooks.Views.LibraryDetailView;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuntaeil.motionbooks.Model.LibraryModel;
import com.example.yuntaeil.motionbooks.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Library_Detail_Activity extends AppCompatActivity {


    public static String VIEW_NAME_HEADER_IMAGE ="detail:header:image";
    public static String VIEW_NAME_HEADER_TITLE ="detail:header:title";


    @BindView(R.id.TitleText)
    TextView TitleText;

    @BindView(R.id.DescriptionText)
    TextView DescriptionText;

    @BindView(R.id.StarText)
    TextView StarText;

    @BindView(R.id.WatchText)
    TextView WatchText;

    @BindView(R.id.ForkText)
    TextView ForkText;

    @BindView(R.id.ImageView)
    ImageView HeaderImageView;

    static LibraryModel Data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library__detail);
        ButterKnife.bind(this);

        ViewCompat.setTransitionName(HeaderImageView, VIEW_NAME_HEADER_IMAGE);
        ViewCompat.setTransitionName(TitleText, VIEW_NAME_HEADER_TITLE);
        BindDatawithView();
    }

    private void BindDatawithView() {
    }

    public static void ShowDetail(LibraryModel data, Context context){
        Library_Detail_Activity.Data = data;


        context.startActivity(new Intent(context, Library_Detail_Activity.class));
    }
}
