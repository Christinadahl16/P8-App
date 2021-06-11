package com.example.p8_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.p8_app.Logic.Session;
import com.example.p8_app.Models.FarmerModel;
import com.example.p8_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FarmerViewAdaptor extends RecyclerView.Adapter<FarmerViewAdaptor.MyViewHolder> {
private List<FarmerModel> mDataList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name,details;
        public Button selectFarmerButton;
        public ImageView imageView;
        public ImageButton editFarmerButton;

        private ArrayList<FarmerModel> mData;

        public MyViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.FarmerName);
            details = (TextView) view.findViewById(R.id.FarmerDetails);
            imageView = (ImageView) view.findViewById(R.id.FarmerImage);
            selectFarmerButton = (Button) view.findViewById(R.id.selectFarmerButton);
            editFarmerButton = (ImageButton) view.findViewById(R.id.EditFarmerButton);

            if (Session.IsAdmin()){
                editFarmerButton.setVisibility(View.VISIBLE);
            }
        }
    }

    public FarmerViewAdaptor(List<FarmerModel> dataList){
        update(dataList);
    }

    public void update(List<FarmerModel> data) {
        this.mDataList = data;
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_farmer, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FarmerModel data = mDataList.get(position);
        holder.selectFarmerButton.setTag(data.GetID());
        holder.editFarmerButton.setTag(data.GetID());
        holder.name.setText(data.GetName() );
        holder.details.setText(data.GetDetails() );
        Picasso.get().load(data.GetImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
