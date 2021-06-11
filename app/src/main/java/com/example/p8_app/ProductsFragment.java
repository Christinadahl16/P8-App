package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p8_app.Logic.AnotherApi;
import com.example.p8_app.Logic.IApiInterface;
import com.example.p8_app.Logic.Session;
import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.adapters.ListViewAdaptor;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {

        private List<ProductModel> mDataList = new ArrayList<>();
        private String framerID = "";
        private ListViewAdaptor mAdapter;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

               View view = inflater.inflate(R.layout.fragment_products, container, false);
               RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

                mAdapter = new ListViewAdaptor(mDataList);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setAdapter(mAdapter);

            framerID = getActivity().getIntent().getStringExtra("farmerID");

            if (framerID == null) {
                Toast toast = Toast.makeText(getActivity(), "No Farmer Selected", Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent(getActivity(), FrontpageActivity.class);
                intent.putExtra("fragmentName", "farmeroverview");
                startActivity(intent);
                return view;
            }
            ImageButton AddProductButton = (ImageButton) view.findViewById(R.id.AddProductButton);
            if (Session.IsAdmin()){
                AddProductButton.setVisibility(View.VISIBLE);
                AddProductButton.setTag(framerID);
            }


            PrepareList(mAdapter);

               return view;
        }

    @Override
    public void onResume() {
        super.onResume();
        PrepareList(mAdapter);
    }

    private int getImageID(String imageName){
                return getActivity().getResources()
                        .getIdentifier(imageName, "drawable", getActivity().getPackageName());
        }

        private void PrepareList(ListViewAdaptor mAdapter){


            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {

                    try{
                        IApiInterface api = new AnotherApi();
                        mDataList = api.GetProducts(framerID);
                        getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                mAdapter.update(mDataList);
                            }
                        });
                    } catch (Exception ex){

                    }
                }
            });

            thread.start();

    }
}

