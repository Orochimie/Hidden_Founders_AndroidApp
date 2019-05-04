package com.gitgubrepos.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//List for the Pojos retrieved via URL
public class GitHubListRepo implements Serializable {

    @SerializedName("items")
    private List<GitHubRepo> gitHubRepoList;

    //constructors
    public GitHubListRepo() {

    }

    public GitHubListRepo(List<GitHubRepo> gitHubRepoList) {
        this.gitHubRepoList = gitHubRepoList;
    }

    //Getters & Setters
    public List<GitHubRepo> getGitHubRepoList() {
        return gitHubRepoList;
    }

    public void setGitHubRepoList(List<GitHubRepo> gitHubRepoList) {
        this.gitHubRepoList = gitHubRepoList;
    }
}
