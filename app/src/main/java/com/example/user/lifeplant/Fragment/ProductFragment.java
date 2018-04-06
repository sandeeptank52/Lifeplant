package com.example.user.lifeplant.Fragment;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lifeplant.Adapter.CategoryAdapter;
import com.example.user.lifeplant.Models.ProResultModel;
import com.example.user.lifeplant.Models.ResHomeModel;
import com.example.user.lifeplant.R;
import com.example.user.lifeplant.WsClass.WSHome;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    private RecyclerView recyclerView;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.category_product_rv);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
//        final ArrayList<CategoryModel> categoryList = new ArrayList<>();
//        final ArrayList<ProductModel> productList = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 100; j++) {
//                final ProductModel productModel = new ProductModel(j, "M1", "Product" + j);
//                productList.add(productModel);
//            }
//
//            final CategoryModel categoryModel = new CategoryModel("Category" + i, productList);
//            categoryList.add(categoryModel);
//
//        }
//
//        final CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(),
//                categoryList, ProductFragment.this);
//        recyclerView.setAdapter(categoryAdapter);

        new AsyncHome().execute();
    }


    private class AsyncHome extends AsyncTask<Void, Void, ResHomeModel> {


        private WSHome wsHome;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(), "", "Please wait");

        }

        @Override
        protected ResHomeModel doInBackground(Void... voids) {
            wsHome = new WSHome(getActivity());
            return wsHome.executeService();
        }


        @Override
        protected void onPostExecute(ResHomeModel resHomeModel) {
            super.onPostExecute(resHomeModel);
            if (resHomeModel != null) {
                if (resHomeModel.getResponse() == 0) {

                    final CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(),
                            (ArrayList<ProResultModel>) resHomeModel.getResult(), ProductFragment.this);
                    recyclerView.setAdapter(categoryAdapter);
                }

            }
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }


        }
    }

}















