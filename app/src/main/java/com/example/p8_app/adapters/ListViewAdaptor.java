package com.example.p8_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.R;

import java.util.List;

public class ListViewAdaptor extends RecyclerView.Adapter<ListViewAdaptor.MyViewHolder> {
private List<ProductModel> mDataList;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public ImageView imageView;

    public MyViewHolder(View view){
        super(view);
        name = (TextView) view.findViewById(R.id.productName);
        imageView = (ImageView) view.findViewById(R.id.productImage);
    }
}

    public ListViewAdaptor(List<ProductModel> dataList){
        this.mDataList = dataList;
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

        String name = data.GetName() + "("+data.GetPrice()+")";

        holder.name.setText(name);

        holder.imageView.setImageResource(data.GetImage());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
