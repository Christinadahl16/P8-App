package com.example.p8_app;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

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
import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.adapters.ListViewAdaptor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CartFragment extends Fragment {

        private List<ProductModel> mDataList = new ArrayList<>();
        IApiInterface api;
        private ListViewAdaptor mAdapter;
        SwipeRefreshLayout swipeRefreshLayout;
        final Calendar myCalendar = Calendar.getInstance();
        EditText deliveryDate;
        Button deliverySubmit;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

           View view = inflater.inflate(R.layout.shoppingbasket, container, false);
           RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

            mAdapter = new ListViewAdaptor(mDataList);
            mAdapter.NoAdmin(true);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setAdapter(mAdapter);


            deliveryDate= (EditText) view.findViewById(R.id.delivery_date);
            deliverySubmit = view.findViewById(R.id.delivery_submit);


            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }

            };

            deliveryDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new DatePickerDialog(getActivity(), date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });


            swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.Product_Swipe);


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

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.GERMANY);

        deliveryDate.setText(sdf.format(myCalendar.getTime()));
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
                                mAdapter.update(mDataList);
                                if (!mDataList.isEmpty()){
                                    deliverySubmit.setVisibility(View.VISIBLE);
                                    deliveryDate.setVisibility(View.VISIBLE);
                                }
                                else {
                                    deliverySubmit.setVisibility(View.INVISIBLE);
                                    deliveryDate.setVisibility(View.INVISIBLE);
                                }
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

