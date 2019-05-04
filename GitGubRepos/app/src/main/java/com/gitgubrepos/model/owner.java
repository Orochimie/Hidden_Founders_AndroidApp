package com.gitgubrepos.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//Pojo for the owner values
public class owner implements Serializable {
    @SerializedName("login")
    String login;
    @SerializedName("avatar_url")
    String Repo_avatar;

    public owner(String login, String repo_avatar) {
        this.login = login;
        Repo_avatar = repo_avatar;
    }

    public String getRepo_avatar() {
        return Repo_avatar;
    }

    public void setRepo_avatar(String repo_avatar) {
        Repo_avatar = repo_avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
