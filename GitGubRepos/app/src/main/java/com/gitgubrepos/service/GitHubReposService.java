package com.gitgubrepos.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.gitgubrepos.MainActivity;
import com.gitgubrepos.interfaces.GitHubRepoGetter;
import com.gitgubrepos.model.GitHubListRepo;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GitHubReposService extends IntentService {

    //Url endpoint
    String RepoUrlEndPoint = "https://api.github.com/search/";
    GitHubListRepo GitHubListRepo;

    public GitHubReposService() {
        super("GitHubReposService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int RepoPage = intent.getIntExtra("pageid", 0);

        Call<GitHubListRepo> listCall = Get_Repos(RepoPage);
        try {
            Intent BroadcastIntent = new Intent(this, myBroadcastReceiver.class);
            BroadcastIntent.setAction("BroadCaster");
            GitHubListRepo = listCall.execute().body();
            BroadcastIntent.putExtra("Repos", GitHubListRepo);
            sendBroadcast(BroadcastIntent);
        } catch (IOException error) {
            Log.i(TAG, "Rest API FAILED:" + error);
        }

    }

    public Call<GitHubListRepo> Get_Repos(int Repopage) {
        //Retrofit API used to consume Rest API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RepoUrlEndPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        GitHubRepoGetter gitHubRepoGetter = retrofit.create(GitHubRepoGetter.class);


        return gitHubRepoGetter.GetRepoListByPage(String.valueOf(Repopage));
    }


}



