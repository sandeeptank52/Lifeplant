package com.example.user.lifeplant.Adapter;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.lifeplant.Models.ProductModel;
import com.example.user.lifeplant.Fragment.ProductFragment;
import com.example.user.lifeplant.Models.ResHomeModel;
import com.example.user.lifeplant.Models.ResProductModel;
import com.example.user.lifeplant.R;
import com.example.user.lifeplant.Fragment.SingalProductFragment;

import java.util.ArrayList;

/**
 * Created by user on 16-02-2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ProductFragment productFragment;
    private ArrayList<ResProductModel> myModelArrayList;
    private Context context;

    public ProductAdapter(final Context context, final ArrayList<ResProductModel> myModelArrayList, ProductFragment productFragment) {
        this.myModelArrayList = myModelArrayList;
        this.context = context;
        this.productFragment = productFragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = ((Activity) parent.getContext())
                .getLayoutInflater().inflate(R.layout.row_product, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ResProductModel myModel = myModelArrayList.get(position);
        holder.tv.setText(myModel.getProName());

        Glide.with(context)
                .load(myModel.getPicPath())
                .into(holder.iv);
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();

                Bundle bundle = new Bundle();
                bundle.putParcelable("model",myModel);
                final FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                SingalProductFragment singalProductFragment = new SingalProductFragment();
                singalProductFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.main_container, singalProductFragment, SingalProductFragment.class.getSimpleName());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.hide(productFragment);

                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return myModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageButton iv;
        private TextView tv;


        public MyViewHolder(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.row_product_iv);
            tv = itemView.findViewById(R.id.row_product_tv);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    ResProductModel model = myModelArrayList.get(position);
//

                }
            });

        }
    }

}
