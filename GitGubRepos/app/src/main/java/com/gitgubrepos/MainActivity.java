package com.gitgubrepos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gitgubrepos.ScrollListeners.EndlessRecyclerViewScrollListener;
import com.gitgubrepos.RepoArrayAdapter.EndlessRepoListAdapter;
import com.gitgubrepos.model.GitHubRepo;
import com.gitgubrepos.service.GitHubReposService;
import com.gitgubrepos.service.myBroadcastReceiver;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EndlessRepoListAdapter endlessRepoListAdapter;
    private ArrayList<GitHubRepo> gitHubRepoArrayList;


    Intent restintent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gitHubRepoArrayList = new ArrayList<>();
        endlessRepoListAdapter = new EndlessRepoListAdapter(gitHubRepoArrayList);
        restintent = new Intent(this, GitHubReposService.class);
        startService(restintent);

        RecyclerView recyclerView = findViewById(R.id.RepoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        EndlessRecyclerViewScrollListener scrollListener;
        recyclerView.setAdapter(endlessRepoListAdapter);

        // Scroll listener to check if we're at the last values to call next values in
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                //call service to get data
                restintent.putExtra("pageid", page);
                startService(restintent);
            }
        };
        //adding scroll listener to view
        recyclerView.addOnScrollListener(scrollListener);
        //retrieve broadcast new data
        BroadcastReceiver br = new myBroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                gitHubRepoArrayList.addAll((ArrayList<GitHubRepo>) intent.getSerializableExtra("RepoList"));
                endlessRepoListAdapter.notifyItemInserted(gitHubRepoArrayList.size());

            }

        };
        //registering our Broadcast receiver to the activity
        registerReceiver(br, new IntentFilter("Sender"));

    }

}
