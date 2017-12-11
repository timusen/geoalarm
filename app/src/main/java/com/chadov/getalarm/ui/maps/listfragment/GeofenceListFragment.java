package com.chadov.getalarm.ui.maps.listfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.chadov.getalarm.R;
import com.chadov.getalarm.model.GeofenceRepositoryImpl;
import com.chadov.getalarm.model.Geofence;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;


public class GeofenceListFragment extends DaggerFragment implements GeofenceListFragmentView {

    @Inject
    GeofenceListFragmentPresenter mGeofenceListFragmentPresenter;

    private RecyclerView mGeofenceRecyclerView;
    private GeofenceAdapter mAdapter;

    public static GeofenceListFragment newInstance() {
        Bundle args = new Bundle();
        GeofenceListFragment fragment = new GeofenceListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_geofence_list, container,
                false);
        mGeofenceRecyclerView = (RecyclerView) view
                .findViewById(R.id.geofence_recycler_view);
        mGeofenceRecyclerView.setLayoutManager(new LinearLayoutManager
                (getActivity()));

        mGeofenceListFragmentPresenter.loadGeofences();
        return view;
    }


    public void setGeofences(List<Geofence> geofences)
    {
        mAdapter = new GeofenceAdapter(geofences);
        mGeofenceRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateList() {

    }

    public interface OnGeofenceSelectedListener {
        public void onGeofenceSelected(Geofence geofence);
    }

    public void fireGeofenceSelected(Geofence geofence)
    {
        OnGeofenceSelectedListener callback =  (OnGeofenceSelectedListener)getActivity();
        callback.onGeofenceSelected(geofence);
    }

    private class GeofenceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Geofence mGeofence;
        public TextView mTitleTextView;
        public TextView mLatLngTextView;
        public Switch mSwitch;

        public GeofenceHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_geofence_title);
            mLatLngTextView = (TextView) itemView.findViewById(R.id.list_item_geofence_latlong);
            mSwitch = (Switch)itemView.findViewById(R.id.list_item_switch);
            mSwitch.setOnClickListener(this);
        }

        public void bindGeofence(Geofence geo) {
            mGeofence = geo;
            mTitleTextView.setText(mGeofence.getName());
            mLatLngTextView.setText(mGeofence.getLatitude() + ", " + mGeofence.getLongitude());
            mSwitch.setChecked(mGeofence.isActive());
        }

        @Override
        public void onClick(View v) {
            updateSwitch();
            fireGeofenceSelected(mGeofence);
        }

        private void updateSwitch()
        {
            if (mSwitch.isChecked())
            {
                mGeofence.setActive(true);
                mSwitch.setText("Активен");
            }
            else
            {
                mGeofence.setActive(false);
                mSwitch.setText("Выключен");
            }
        }
    }


    private class GeofenceAdapter extends RecyclerView.Adapter<GeofenceHolder> {
        private List<Geofence> mGeofences;
        public GeofenceAdapter(List<Geofence> geofences) {
            mGeofences = geofences;
        }

        @Override
        public GeofenceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_geofence, parent, false);

            return new GeofenceHolder(view);
        }

        @Override
        public void onBindViewHolder(GeofenceHolder holder, int position) {
            Geofence geofence = mGeofences.get(position);
            holder.bindGeofence(geofence);
        }

        @Override
        public int getItemCount() {
            return mGeofences.size();
        }
    }



}
