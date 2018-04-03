package com.example.yuntaeil.motionbooks.Model;

/**
 * Created by yuntaeil on 2018. 3. 29..
 */

public class LibraryModel {

    public String title;
    public String author;
    public String type;
    public String gifUrl;
    public String gitUrl;
    public String license;
    public String lauguage;
    public String authorImageUrl;
    public String mianColor;


    public int gitStar;
    public int gitFork;
    public int gitIssue;
    public int gitSubscriber;


    public boolean gradleInstall;
    public boolean mavenInstall;
    public boolean availableLibrary;
    public boolean favorite;

    public LibraryModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public LibraryModel setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
        return this;

    }
    public LibraryModel setStar(int star) {
        this.gitStar = star;
        return this;

    }

    public LibraryModel setTitle(String title) {
        this.title = title;
        return this;

    }

}
