package com.gitgubrepos.RepoArrayAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gitgubrepos.R;
import com.gitgubrepos.model.GitHubRepo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//Custom adapter for the recycled view content
public class EndlessRepoListAdapter extends RecyclerView.Adapter<EndlessRepoListAdapter.ViewHolder> {

    private ArrayList<GitHubRepo> data ;
    //constructor
    public EndlessRepoListAdapter(ArrayList<GitHubRepo> gitHubRepo){
        this.data=gitHubRepo;
    }

    @NonNull
    @Override
    public EndlessRepoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context=viewGroup.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View Reporow=layoutInflater.inflate(R.layout.list_repo,viewGroup,false);
        ViewHolder viewHolder =new ViewHolder(Reporow);
        return viewHolder;

    }

    //populating viewholder row with values
    @Override
    public void onBindViewHolder(@NonNull EndlessRepoListAdapter.ViewHolder viewHolder, int i) {
        // Get the data model based on position
        GitHubRepo gitHubRepo=data.get(i);
        // Set item views based on your views and data model
        TextView repo_name=viewHolder.repo_name;
        repo_name.setText(gitHubRepo.getRepo_Name());
        TextView repo_desc=viewHolder.repo_desc;
        repo_desc.setText(gitHubRepo.getRepo_desc());
        TextView owner_id=viewHolder.owner_id;
        owner_id.setText(gitHubRepo.getOwner().getLogin());
        ImageView iv=viewHolder.iv;
        Picasso.get().load(gitHubRepo.getOwner().getRepo_avatar()).into(iv);
        TextView repo_stars=viewHolder.repo_stars;
        repo_stars.setText(String.valueOf(gitHubRepo.getRepo_Stars()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        TextView repo_name;
        TextView repo_desc;
        TextView owner_id;
        ImageView iv;
        TextView repo_stars;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

             repo_name = itemView.findViewById(R.id.repo_name);

             repo_desc = itemView.findViewById(R.id.repo_desc);

             owner_id = itemView.findViewById(R.id.owner_id);

             iv =itemView.findViewById(R.id.stars_img);

             repo_stars = itemView.findViewById(R.id.repo_stars);
             //used to draw a star on the left of the textview
            repo_stars.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_star,0,0,0);


        }
    }
}
