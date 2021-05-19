package com.example.p8_app;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p8_app.Models.FarmerModel;
import com.example.p8_app.adapters.FarmerViewAdaptor;

import java.util.ArrayList;
import java.util.List;

/*View AboutgtFragment*/
public class FarmerOverview extends Fragment {
    private List<FarmerModel> mDataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_farmeroverview, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.Farmer_recycler_view);

        FarmerViewAdaptor mAdapter = new FarmerViewAdaptor(mDataList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        PrepareList();

        return view;
    }


    private int getImageID(String imageName){
        return getActivity().getResources()
                .getIdentifier(imageName, "drawable", getActivity().getPackageName());
    }

    private void PrepareList(){

        mDataList.add(new FarmerModel("1", "Farmer 1", "holder til ved den lille by Y nær Aalborg midtby. Farmer XXX er kendt for sit store udvalg af økologiske grøntsager, fokus på bæredygtighed og gode service.", getImageID("farmer1")));
        mDataList.add(new FarmerModel("2", "Farmer 2", "holder til ved den lille by Y nær Aalborg midtby. Farmer XXX er kendt for sit store udvalg af økologiske grøntsager, fokus på bæredygtighed og gode service.", getImageID("farmer4")));
    }
}


