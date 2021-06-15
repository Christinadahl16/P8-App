package com.example.p8_app;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.p8_app.Logic.AnotherApi;
import com.example.p8_app.Logic.IApiInterface;
import com.example.p8_app.Logic.Session;
import com.example.p8_app.Models.FarmerModel;
import com.example.p8_app.adapters.FarmerViewAdaptor;

import java.util.ArrayList;
import java.util.List;

/*View AboutgtFragment*/
public class FarmerOverview extends Fragment {
    private List<FarmerModel> mDataList = new ArrayList<>();
    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    FarmerViewAdaptor mAdapter;
    IApiInterface api;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_farmeroverview, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.Farmer_recycler_view);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.Farmer_Swipe);


        mAdapter = new FarmerViewAdaptor(mDataList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                api.forceServer(true);
                PrepareList();
            }
        });



        ImageButton farmerButton = view.findViewById(R.id.AddFarmer);

        if (!Session.IsAdmin()) {
            farmerButton.setVisibility(View.INVISIBLE);
        }

        api = new AnotherApi();
        PrepareList();

        return view;
    }



   private int getImageID(String imageName){
        return getActivity().getResources()
                .getIdentifier(imageName, "drawable", getActivity().getPackageName());
    }


    private void PrepareList(){


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                try{
                    swipeRefreshLayout.setRefreshing(true);
                    mDataList = api.GetFarmers();
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            mAdapter.update(mDataList);

                        }
                    });
                } catch (Exception ex){

                }finally {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        thread.start();

    }

}


