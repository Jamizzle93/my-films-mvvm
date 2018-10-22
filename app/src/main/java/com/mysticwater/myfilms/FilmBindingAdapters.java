package com.mysticwater.myfilms;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FilmBindingAdapters {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String imageUrl) {
        if (imageUrl == null) {
            imageView.setImageDrawable(null);
        } else {
            Picasso.get().load(imageUrl).into(imageView);
        }
    }

}
