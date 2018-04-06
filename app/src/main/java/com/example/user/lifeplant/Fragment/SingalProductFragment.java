package com.example.user.lifeplant.Fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.lifeplant.Adapter.VpPagerAdapter;
import com.example.user.lifeplant.Models.PicModel;
import com.example.user.lifeplant.Models.PrefManager;
import com.example.user.lifeplant.Models.ResCartModel;
import com.example.user.lifeplant.Models.ResProductModel;
import com.example.user.lifeplant.Models.ResSignupModel;
import com.example.user.lifeplant.R;
import com.example.user.lifeplant.WsClass.WSCart;
import com.example.user.lifeplant.WsClass.WsProduct;

import java.util.ArrayList;


public class SingalProductFragment extends Fragment {
    private TextView productname, productprize, productdetails;
    private Button addtocart;
    private ViewPager imageView;
    private String email;
    private VpPagerAdapter vpPagerAdapter;
    private String pid;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_singal_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new PrefManager(getActivity()).getEmail();
        SharedPreferences detail = getActivity().getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        email = detail.getString("Email","");
        final ResProductModel productList = getArguments().getParcelable("model");
        productname = view.findViewById(R.id.product_name);
        productname.setText(productList.getProName());
        pid = productList.getProId();
        productprize = view.findViewById(R.id.product_price);
        productprize.setText(productList.getPrice());
        productdetails = view.findViewById(R.id.productDetails);
        productdetails.setText(productList.getProDetail());

        imageView = view.findViewById(R.id.product_image);


        addtocart = view.findViewById(R.id.add_to_cart);

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncCart().execute(email,pid,"1");

            }
        });

        new AyncProduct().execute();
    }


    private class AyncProduct extends AsyncTask<Void, Void, PicModel> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(PicModel resProductModel) {
            super.onPostExecute(resProductModel);
            if (resProductModel != null) {
                vpPagerAdapter = new VpPagerAdapter(getActivity(), (ArrayList<PicModel.Result>) resProductModel.getResult(), SingalProductFragment.this);
                imageView.setAdapter(vpPagerAdapter);
            }
        }


        @Override
        protected PicModel doInBackground(Void... voids) {
            WsProduct wsProduct = new WsProduct(getActivity());
            return wsProduct.executeService(pid);
        }

    }


    private class AsyncCart extends AsyncTask<String, Void, Void> {


        private WSCart wsCart;
        private ProgressDialog progressDialog;
        private ResSignupModel resSignupModel;
        private ResCartModel resCartModel;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(), "Loding", "Please wait");
        }

        @Override
        protected Void doInBackground(String... strings) {
//            wsSignup = new WSSignUp(getActivity());
            wsCart = new WSCart(getActivity());
            resCartModel = wsCart.executeService(strings[0], strings[1], strings[2]);
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (resCartModel.getResponse() == 0) {

                Toast.makeText(getActivity(), "This Product Added in your Cart", Toast.LENGTH_SHORT).show();
            } else {
                new AlertDialog.Builder(getActivity()).setTitle("Somthing Went Wrong");
            }
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }
}
