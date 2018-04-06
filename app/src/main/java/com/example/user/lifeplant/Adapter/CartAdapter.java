package com.example.user.lifeplant.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lifeplant.Models.CartModel;
import com.example.user.lifeplant.R;

import java.util.ArrayList;

/**
 * Created by user on 16-03-2018.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private ArrayList<CartModel> cartModelArrayList;
    private Context context;

    public CartAdapter(Context context, ArrayList<CartModel> cartModelArrayList) {
        this.cartModelArrayList = cartModelArrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = ((Activity) parent.getContext())
                .getLayoutInflater().inflate(R.layout.row_cart, parent, false);
        return new CartAdapter.MyViewHolder(view, context, cartModelArrayList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Context context;
        private RecyclerView recyclerView;
        private ArrayList<CartModel> cartModelArrayList = new ArrayList<>();

        public MyViewHolder(View itemView, Context context, ArrayList<CartModel> cartModels) {
            super(itemView);
            this.cartModelArrayList = cartModels;
            this.context = context;
            recyclerView.findViewById(R.id.cart_product_rv);
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}
