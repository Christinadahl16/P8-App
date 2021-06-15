package com.example.p8_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import com.example.p8_app.Models.CartModel;
import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.adapters.SalesListViewAdaptor;

import java.util.ArrayList;
import java.util.List;

public class SalesFragment extends Fragment {

        private List<ProductModel> mDataList = new ArrayList<>();
        IApiInterface api;
        private SalesListViewAdaptor mAdapter;
        SwipeRefreshLayout swipeRefreshLayout;
        TextView deliveryThanksYou;
        CartModel cartModel;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

           View view = inflater.inflate(R.layout.sale_fragment, container, false);
           RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

            mAdapter = new SalesListViewAdaptor(mDataList);
            mAdapter.NoAdmin(true);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 1);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setAdapter(mAdapter);

            deliveryThanksYou =  view.findViewById(R.id.delivery_thankyou);

            swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.Product_Swipe);



            cartModel = Session.GetCart();

            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    api.forceServer(true);
                    PrepareList();
                }
            });

            api = new AnotherApi();
            PrepareList();

               return view;
        }


    @Override
    public void onResume() {
        super.onResume();
        PrepareList();
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

                        String Idlist = Session.GetCart().ProductIDS();

                        mDataList = api.GetCartProducts(Idlist);
                        getActivity().runOnUiThread(new Runnable() {
                            public void run() {

                                deliveryThanksYou.setText("Total Price :" + cartModel.GetTotal().toString()  + "\n \n \n  Thank you for your order.. it will be delivered on " + cartModel.DeliveryDate);
                                mAdapter.update(mDataList, cartModel);
                                cartModel.DeleteOnAccess = true;

                            }
                        });
                    } catch (Exception ex){

                    } finally {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }
            });

            thread.start();

    }
}

