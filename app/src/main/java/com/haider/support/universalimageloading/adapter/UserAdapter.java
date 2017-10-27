package com.haider.support.universalimageloading.adapter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haider.support.universalimageloading.R;
import com.haider.support.universalimageloading.imageChahelib.core.DisplayImageOptions;
import com.haider.support.universalimageloading.imageChahelib.core.ImageLoader;
import com.haider.support.universalimageloading.imageChahelib.core.display.CircleBitmapDisplayer;
import com.haider.support.universalimageloading.imageChahelib.core.display.FadeInBitmapDisplayer;
import com.haider.support.universalimageloading.imageChahelib.core.listener.ImageLoadingListener;
import com.haider.support.universalimageloading.imageChahelib.core.listener.SimpleImageLoadingListener;
import com.haider.support.universalimageloading.model.UserModel;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by support on 10/27/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<UserModel> usersList;
    private DisplayImageOptions options;
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public ImageView userImage;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.userName);
            userImage = (ImageView) view.findViewById(R.id.userImage);
        }
    }


    public UserAdapter(List<UserModel> usersList) {
        this.usersList = usersList;

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.placeholder_icon)
                .showImageForEmptyUri(R.drawable.empty_icon)
                .showImageOnFail(R.drawable.error_icon)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                .build();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        UserModel user = usersList.get(position);
        holder.userName.setText(user.getUserName());
        ImageLoader.getInstance().displayImage(user.getImageUrl(), holder.userImage, options, animateFirstListener);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                }
            }
        }
    }
}
