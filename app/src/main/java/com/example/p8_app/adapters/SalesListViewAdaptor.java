package com.example.p8_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.p8_app.Models.CartModel;
import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SalesListViewAdaptor extends RecyclerView.Adapter<SalesListViewAdaptor.MyViewHolder> {
private List<ProductModel> mDataList;
boolean noAdmin;
private CartModel cartModel;

public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView name, quantityView, productlistprice, deliverydate;
    public ImageView imageView;





    public MyViewHolder(View view){
        super(view);
        name = (TextView) view.findViewById(R.id.productName);
        productlistprice =  (TextView) view.findViewById(R.id.productlistprice);
        quantityView = (TextView) view.findViewById(R.id.product_quantity);
        deliverydate = (TextView) view.findViewById(R.id.delivery_date);
        imageView = (ImageView) view.findViewById(R.id.productImage);

    }
}

    public SalesListViewAdaptor(List<ProductModel> dataList){
        this.mDataList = dataList;
    }

    public void update(List<ProductModel> data, CartModel cartModel) {
        this.mDataList = data;
        this.cartModel = cartModel;
        notifyDataSetChanged();
    }


    public void NoAdmin(boolean noAdmin) {
        this.noAdmin = noAdmin;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_cartitem, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ProductModel data = mDataList.get(position);


        Integer SelectAmount = cartModel.GetQuantity(data.GetID());
        holder.quantityView.setText(SelectAmount.toString());
        holder.deliverydate.setText(cartModel.DeliveryDate);
        holder.name.setText(data.GetName() );
        holder.productlistprice.setText(Float.toString(data.GetPrice()));
        Picasso.get().load(data.GetImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
