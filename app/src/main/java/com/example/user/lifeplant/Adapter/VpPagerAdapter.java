package com.example.user.lifeplant.Adapter;

/**
 * Created by Tejas Soni on 04-04-2018.
 */

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.lifeplant.Models.PicModel;
import com.example.user.lifeplant.R;

import java.util.ArrayList;


public class VpPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<PicModel.Result> list;
    private Fragment fragment;


    public VpPagerAdapter(final Context context, final ArrayList<PicModel.Result> list, final Fragment fragment) {
        this.context = context;
        this.list = list;
        this.fragment = fragment;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }


    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        final PicModel.Result image = list.get(position);


        final LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        final View view = inflater.inflate(R.layout.row_image, container, false);
//        final View view1 = inflater.inflate(R.layout.view_product_detail, container, false);


        final ImageView allimg = view.findViewById(R.id.row_vp_image);
//        final TextView photo_name = view1.findViewById(R.id.photo_name);
//        final TextView photo_description = view1.findViewById(R.id.photo_description);
//        final EditText photo_category = view1.findViewById(R.id.photo_category);
//        final EditText photo_quantity = view1.findViewById(R.id.photo_quantity);
//        final EditText photo_price = view1.findViewById(R.id.photo_price);

      /*  final String[] images ={image.getImagePath()
                ,image.getPhotoUrl()
        };*/
        //allimg.setImageResource(list.get(position));\
        //GlideApp.with(context).load(images[position]).into(allimg);
        Glide.with(view)
                .load(image.getPicPath())
                .into(allimg);
        //  GlideApp.with(context).load(image.getPhotoUrl()).into(allimg);
//        photo_name.setText(image.getPhotoName());
//        photo_description.setText(image.getDescription());
//        photo_category.setText(image.getCategory());
//        photo_quantity.setText(image.getQuantity());
//        photo_price.setText(image.getPrice());


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
