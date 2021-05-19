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

import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.adapters.ListViewAdaptor;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {

        private List<ProductModel> mDataList = new ArrayList<>();

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


               View view = inflater.inflate(R.layout.fragment_products, container, false);
               RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

                ListViewAdaptor mAdapter = new ListViewAdaptor(mDataList);
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

                mDataList.add(new ProductModel("Apple", (float) 2.2, getImageID("aebler"), "1"));
                mDataList.add(new ProductModel("Blomme", (float) 2.2, getImageID("blomme"), "1"));
                mDataList.add(new ProductModel("Agurk", (float) 2.2, getImageID("agurk"), "1"));
                mDataList.add(new ProductModel("Chili", (float) 2.2, getImageID("chili"), "2"));
                mDataList.add(new ProductModel("Dild", (float) 2.2, getImageID("dild"), "2"));
                mDataList.add(new ProductModel("Agurk", (float) 2.2, getImageID("agurk"), "2"));
        }
}

