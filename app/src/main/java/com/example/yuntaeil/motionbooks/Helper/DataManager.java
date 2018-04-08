package com.example.yuntaeil.motionbooks.Helper;

import com.example.yuntaeil.motionbooks.Model.LibraryModel;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuntaeil on 2018. 4. 6..
 */

public class DataManager {
    private static final DataManager ourInstance = new DataManager();


    public static DataManager getInstance() {
        return ourInstance;
    }
    public List<LibraryModel> LibraryList = new ArrayList<>();
    private DataManager() {
        LibraryModel tempData = new LibraryModel();
        tempData.author = "test";
        tempData.title = "test";
        tempData.gitStar = 999;
        tempData.type = "RecyclerView";
        tempData.description = "It is temp data for development, it developed by T@eil, powered By yunastic, gigigiiggi";
        LibraryList.add(tempData);
        LibraryList.add(tempData);
        LibraryList.add(tempData);
        LibraryList.add(tempData);
    }
}
