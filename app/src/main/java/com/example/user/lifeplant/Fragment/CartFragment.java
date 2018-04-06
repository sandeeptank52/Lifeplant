package com.example.user.lifeplant.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lifeplant.Adapter.CartAdapter;
import com.example.user.lifeplant.Models.CartModel;
import com.example.user.lifeplant.R;

import java.util.ArrayList;

/**
 * Created by user on 16-02-2018.
 */
public class CartFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = view.findViewById(R.id.cart_product_rv);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        final ArrayList<CartModel> cart = new ArrayList<>();
        final CartAdapter cartAdapter = new CartAdapter(getActivity(), cart);
        recyclerView.setAdapter(cartAdapter);
    }
}
