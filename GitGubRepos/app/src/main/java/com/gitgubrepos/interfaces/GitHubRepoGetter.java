package com.gitgubrepos.interfaces;

import com.gitgubrepos.model.GitHubListRepo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//Url parameters used by Retrofit2
public interface GitHubRepoGetter {
    @GET("repositories?q=created:>2017-10-22&sort=stars&order=desc&per_page=50")
    Call<GitHubListRepo> GetRepoListByPage(@Query("page") String pageid);
}
