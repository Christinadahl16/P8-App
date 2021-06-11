package com.example.p8_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.p8_app.Logic.Session;
import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListViewAdaptor extends RecyclerView.Adapter<ListViewAdaptor.MyViewHolder> {
private List<ProductModel> mDataList;

public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView name, quantityView;
    public ImageView imageView;
    public ImageButton editProductButton;

    public MyViewHolder(View view){
        super(view);
        name = (TextView) view.findViewById(R.id.productName);
        quantityView = (TextView) view.findViewById(R.id.product_quantity);
        imageView = (ImageView) view.findViewById(R.id.productImage);

        editProductButton = (ImageButton) view.findViewById(R.id.editProductButton);

        if (Session.IsAdmin()){
            editProductButton.setVisibility(View.VISIBLE);
        }
    }
}

    public ListViewAdaptor(List<ProductModel> dataList){
        this.mDataList = dataList;
    }

    public void update(List<ProductModel> data) {
        this.mDataList = data;
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_item, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProductModel data = mDataList.get(position);
        holder.editProductButton.setTag(data.GetID());
        holder.name.setText(data.GetName() );
        Picasso.get().load(data.GetImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
