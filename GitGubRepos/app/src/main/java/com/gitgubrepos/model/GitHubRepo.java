package com.gitgubrepos.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//Pojo for the repo values
public class GitHubRepo implements Serializable {
    @SerializedName("name")
    String Repo_Name;
    @SerializedName("description")
    String Repo_desc;
    @SerializedName("stargazers_count")
    int Repo_Stars;
    @SerializedName("owner")
    owner owner;

    //constructors
    public GitHubRepo() {
    }

    public GitHubRepo(String repo_Name, String repo_desc, int repo_Stars, com.gitgubrepos.model.owner owner) {
        Repo_Name = repo_Name;
        Repo_desc = repo_desc;
        Repo_Stars = repo_Stars;
        this.owner = owner;
    }

    //getter & Setter
    public String getRepo_Name() {
        return Repo_Name;
    }

    public void setRepo_Name(String repo_Name) {
        Repo_Name = repo_Name;
    }

    public String getRepo_desc() {
        return Repo_desc;
    }

    public void setRepo_desc(String repo_desc) {
        Repo_desc = repo_desc;
    }

    public int getRepo_Stars() {
        return Repo_Stars;
    }

    public void setRepo_Stars(int repo_Stars) {
        Repo_Stars = repo_Stars;
    }

    public com.gitgubrepos.model.owner getOwner() {
        return owner;
    }

    public void setOwner(com.gitgubrepos.model.owner owner) {
        this.owner = owner;
    }
}
