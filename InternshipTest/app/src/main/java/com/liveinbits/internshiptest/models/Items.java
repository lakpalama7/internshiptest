package com.liveinbits.internshiptest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Items implements Serializable {
    @SerializedName("forks")
    @Expose
    private int forks;
    @SerializedName("watchers")
    @Expose
    private int watchers;

    @SerializedName("score")
    @Expose
    private double score;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("open_issues")
    @Expose
    private int open_issues;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    public Items() {
    }

    public Items(int forks, int watchers, double score, String language, int open_issues, String name, Owner owner) {
        this.forks = forks;
        this.watchers = watchers;
        this.score = score;
        this.language = language;
        this.open_issues = open_issues;
        this.name = name;
        this.owner = owner;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}




