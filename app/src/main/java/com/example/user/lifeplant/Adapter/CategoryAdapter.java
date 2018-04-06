package com.example.user.lifeplant.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.lifeplant.Fragment.ProductFragment;
import com.example.user.lifeplant.Fragment.SingalCategoryFragment;
import com.example.user.lifeplant.Models.ProResultModel;
import com.example.user.lifeplant.Models.ResProductModel;
import com.example.user.lifeplant.R;

import java.util.ArrayList;

/**
 * Created by user on 16-02-2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    ProductFragment productFragment;
    private ArrayList<ProResultModel> myModelArrayList;
    private Context context;

    public CategoryAdapter(final Context context, final ArrayList<ProResultModel> myModelArrayList, ProductFragment productFragment) {
        this.myModelArrayList = myModelArrayList;
        this.context = context;
        this.productFragment = productFragment;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = ((Activity) parent.getContext())
                .getLayoutInflater().inflate(R.layout.row_category, parent, false);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final ProResultModel myModel = myModelArrayList.get(position);
        holder.tv.setText(myModel.getCateName());


        final ProductAdapter productAdapter = new ProductAdapter(context, (ArrayList<ResProductModel>) myModel.getProducts(), productFragment);
        holder.recyclerView.setAdapter(productAdapter);


        holder.see_all_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = holder.getAdapterPosition();

                String categoryname = holder.tv.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                bundle.putString("categoryname", categoryname);
                bundle.putParcelableArrayList("model", (ArrayList<ResProductModel>) myModelArrayList.get(holder.getAdapterPosition()).getProducts());
                final FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                SingalCategoryFragment singalCategoryFragment = new SingalCategoryFragment();
                singalCategoryFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.main_container, singalCategoryFragment);
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
        Context context;
        private RecyclerView recyclerView;
        private TextView tv;
        private TextView see_all_btn;
        private ImageView productimage;

        public MyViewHolder(View itemView, Context context) {
            super(itemView);

            this.context = context;
            recyclerView = itemView.findViewById(R.id.row_category_rv);
            tv = itemView.findViewById(R.id.row_category_tv_name);
            see_all_btn = itemView.findViewById(R.id.seeall_button);
            productimage = itemView.findViewById(R.id.row_product_iv);

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);

        }


    }
}
