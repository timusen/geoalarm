package com.chadov.getalarm.ui.maps.listfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.chadov.getalarm.R;
import com.chadov.getalarm.model.GeofenceRepository;
import com.chadov.getalarm.model.GeofenceRepositoryImpl;
import com.chadov.getalarm.model.Geofence;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;


public class GeofenceListFragment extends DaggerFragment implements GeofenceListFragmentView, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener  {

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
        mGeofenceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mGeofenceRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        updateUI();

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mGeofenceRecyclerView);

        return view;
    }

//    @Override
//    public void onAttach(Context context) {
//        AndroidSupportInjection.inject(this);
//        super.onAttach(context);
//    }

    private void updateUI() {
        GeofenceRepositoryImpl geoLab = new GeofenceRepositoryImpl(getActivity());
        mAdapter = new GeofenceAdapter(geoLab);
        mGeofenceRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateList() {

    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof GeofenceHolder) {
            // get the removed item name to display it in snack bar
            //String name = cartList.get(viewHolder.getAdapterPosition()).getName();

            // backup of removed item for undo purpose
            //final Item deletedItem = cartList.get(viewHolder.getAdapterPosition());
            //final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            mAdapter.removeItem(viewHolder.getAdapterPosition());

            /*
            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    mAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
            */
        }
    }

    public interface OnGeofenceSelectedListener {
        public void onGeofenceSelected(Geofence geofence);
    }

    public void fireGeofenceSelected(Geofence geofence)
    {
        OnGeofenceSelectedListener callback =  (OnGeofenceSelectedListener)getActivity();
        callback.onGeofenceSelected(geofence);
    }

    public class GeofenceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Geofence mGeofence;

        public TextView mTitleTextView;
        public TextView mLatLngTextView;
        public Switch mSwitch;

        public RelativeLayout mViewBackground, mViewForeground;

        public GeofenceHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_geofence_title);
            mLatLngTextView = (TextView) itemView.findViewById(R.id.list_item_geofence_latlong);
            mSwitch = (Switch)itemView.findViewById(R.id.list_item_switch);
            mSwitch.setOnClickListener(this);

            mViewBackground = (RelativeLayout)itemView.findViewById(R.id.view_background);
            mViewForeground = (RelativeLayout)itemView.findViewById(R.id.view_foreground);
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


    public class GeofenceAdapter extends RecyclerView.Adapter<GeofenceHolder> {
        GeofenceRepository mGeofenceRepository;
        private List<Geofence> mGeofences;

        public GeofenceAdapter(GeofenceRepository geofenceRepository)
        {
            mGeofenceRepository = geofenceRepository;
            mGeofences = mGeofenceRepository.getGeofences();
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

        public void removeItem(int position) {
            mGeofenceRepository.delete(mGeofences.get(position));
            mGeofences.remove(position);
            // notify the item removed by position
            // to perform recycler view delete animations
            // NOTE: don't call notifyDataSetChanged()
            notifyItemRemoved(position);
        }
    }



}
