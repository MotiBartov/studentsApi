package com.tikal.resttestapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tikal.resttestapp.R;
import com.tikal.resttestapp.api.ApiClient;
import com.tikal.resttestapp.model.Student;
import com.tikal.resttestapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motibartov on 02/05/2017.
 */

public class StudentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private static final String TAG = StudentsAdapter.class.getSimpleName();
    LayoutInflater mInflater;
    Activity mContext;
    private List<Student> data = new ArrayList<>();


    public StudentsAdapter(Activity context){
        mContext = context;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = mInflater.inflate(R.layout.row_list_item, parent, false);
                return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder)holder).ivItemImage = (ImageView) ((ItemViewHolder)holder).itemView.findViewById(R.id.ivRowItemImage);
        ((ItemViewHolder)holder).tvFirstName = (TextView) ((ItemViewHolder)holder).itemView.findViewById(R.id.tvFirstName);
        ((ItemViewHolder)holder).tvLastName = (TextView) ((ItemViewHolder)holder).itemView.findViewById(R.id.tvLastName);

        ((ItemViewHolder)holder).tvFirstName.setText(data.get(position).firstname);
        ((ItemViewHolder)holder).tvLastName.setText(data.get(position).lastname);
        Uri uri = Uri.parse(ApiClient.IMAGES_BASE_URL + data.get(position).image);
        Log.i(TAG, "onBindViewHolder: image uri " + uri);
        Glide.with(mContext).load(uri).
                into(((ItemViewHolder)holder).ivItemImage);

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivItemImage;
        private TextView tvFirstName;
        private TextView tvLastName;
        private View itemView;

        private ItemViewHolder(View itemView) {
            super(itemView);
            //drawerRowIcon.setOnClickListener(this);
            this.itemView = itemView;


        }

    }

    public void updateItems(List<Student> items) {
        if (this.data != null) {
            this.data.clear();
        }

        this.data.addAll(items);
        Log.i(TAG, "data size: " + this.data.size());
        mContext.runOnUiThread(() -> notifyDataSetChanged());
    }

}
