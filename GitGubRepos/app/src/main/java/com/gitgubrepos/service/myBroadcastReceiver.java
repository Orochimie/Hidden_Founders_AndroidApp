package com.gitgubrepos.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gitgubrepos.model.GitHubListRepo;
import com.gitgubrepos.model.GitHubRepo;

import java.util.ArrayList;


//Broadcast retriever of the service intent values
public class myBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //retrieving Items of Repo
        GitHubListRepo Repos = (GitHubListRepo) intent.getSerializableExtra("Repos");
        //retrieving the list of Repos
        ArrayList<GitHubRepo> gitHubRepos = (ArrayList<GitHubRepo>) Repos.getGitHubRepoList();
        Intent is = new Intent("Sender");
        is.putExtra("RepoList", gitHubRepos);
        context.sendBroadcast(is);


    }
}
