package com.app.devfest.nyeri.staterestoration.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.devfest.nyeri.staterestoration.R;
import com.app.devfest.nyeri.staterestoration.model.SportActivity;
import com.app.devfest.nyeri.staterestoration.utils.SportsManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mac on 10/17/2015.
 */
public class ActivitiesListFragment extends Fragment {

    private RecyclerView mSportsList;
    private SportActivitiesListAdapter mSportsAdapter;

    public static ActivitiesListFragment newInstance(){
        return new ActivitiesListFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activities_list,container,false);
        mSportsList = (RecyclerView)view.findViewById(R.id.my_recycler);
        /*
            Create LayoutManager and a set to Recycler. Since Recylcer View can behave as List or GridView the LayoutManager it's mandatory to define which of the two
            it should behave like.
            This case the Recycler View will work like a ListView since we passed a LinearLayoutManager
         */
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mSportsList.setLayoutManager(mLinearLayoutManager);
        mSportsAdapter = new SportActivitiesListAdapter();
        mSportsList.setAdapter(mSportsAdapter);
        mSportsAdapter.swapData(SportsManager.getNearstActivities());
        return view;
    }




    public class SportActivitiesListAdapter extends RecyclerView.Adapter<SportActivitiesListAdapter.SportItemViewHolder>{

        List<SportActivity> activites = new ArrayList<>();

        @Override
        public SportItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //get LayoutInflater from parent ViewGroup Context
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            //inflate the view
            View view = inflater.inflate(R.layout.layout_single_activitie_item,parent,false);
            //return a new view holder instance
            return new SportItemViewHolder(view);
        }


        @Override
        public void onBindViewHolder(SportItemViewHolder holder, int position) {

            Picasso.with(getActivity().getApplicationContext()).load(activites.get(position).getPhotoUrl()).into(holder.mSportsImage);
            holder.mSportTitle.setText(activites.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return activites.size();
        }


        public void swapData(List<SportActivity> activities){
            this.activites.clear();
            this.activites = activities;
        }


        public class SportItemViewHolder extends RecyclerView.ViewHolder{

            public ImageView mSportsImage;
            public TextView mSportTitle;

            public SportItemViewHolder(View itemView) {
                super(itemView);
                mSportsImage = (ImageView)itemView.findViewById(R.id.sport_activity_image);
                mSportTitle = (TextView)itemView.findViewById(R.id.sport_activity_name);
            }
        }
    }
}
