package com.liveinbits.internshiptest.models;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Owner implements Serializable {
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("organizations_url")
    @Expose
    private String organizational_url;
    @SerializedName("type")
    @Expose
    private String type;

    public Owner() {
    }

    public Owner(String login, int id, String url, String organizational_url, String type) {
        this.login = login;
        this.id = id;
        this.url = url;
        this.organizational_url = organizational_url;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrganizational_url() {
        return organizational_url;
    }

    public void setOrganizational_url(String organizational_url) {
        this.organizational_url = organizational_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
