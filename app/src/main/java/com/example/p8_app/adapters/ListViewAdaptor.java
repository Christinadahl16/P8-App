package com.example.p8_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.p8_app.Logic.Session;
import com.example.p8_app.Models.CartModel;
import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListViewAdaptor extends RecyclerView.Adapter<ListViewAdaptor.MyViewHolder> {
private List<ProductModel> mDataList;

public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView name, quantityView, productlistprice;
    public ImageView imageView;
    public ImageButton editProductButton;
    public ImageButton decreaseProduct;
    public ImageButton increaseProduct;


    public MyViewHolder(View view){
        super(view);
        name = (TextView) view.findViewById(R.id.productName);
        productlistprice =  (TextView) view.findViewById(R.id.productlistprice);
        quantityView = (TextView) view.findViewById(R.id.product_quantity);
        imageView = (ImageView) view.findViewById(R.id.productImage);
        increaseProduct = (ImageButton) view.findViewById(R.id.increaseProduct);
        decreaseProduct = (ImageButton) view.findViewById(R.id.decreaseProduct);
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


        CartModel cartModel = Session.GetCart();
        ProductModel data = mDataList.get(position);


        Integer SelectAmount = cartModel.GetQuantity(data.GetID());
        holder.quantityView.setText(SelectAmount.toString());

        holder.editProductButton.setTag(data.GetID());
        holder.increaseProduct.setTag(data.GetID());
        holder.decreaseProduct.setTag(data.GetID());
        holder.name.setText(data.GetName() );
        holder.productlistprice.setText(Float.toString(data.GetPrice()));
        Picasso.get().load(data.GetImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
