package com.example.user.lifeplant.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.lifeplant.Adapter.SingalProductAdapter;
import com.example.user.lifeplant.Models.ResProductModel;
import com.example.user.lifeplant.R;

import java.util.ArrayList;


public class SingalCategoryFragment extends Fragment {
    private TextView textView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_singal_category, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        textView = view.findViewById(R.id.category_name);
        textView.setText(getArguments().getString("categoryname"));
        final RecyclerView recyclerView = view.findViewById(R.id.category_product_rv);
        final GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        int position = getArguments().getInt("position");
        final ArrayList<ResProductModel> productList = getArguments().getParcelableArrayList("model");
        final SingalProductAdapter singalProductAdapter = new SingalProductAdapter(getContext(),
                productList, SingalCategoryFragment.this);
        recyclerView.setAdapter(singalProductAdapter);
    }

}

