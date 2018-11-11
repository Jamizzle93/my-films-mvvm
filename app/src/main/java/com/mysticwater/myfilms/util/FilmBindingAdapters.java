package com.mysticwater.myfilms.util;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class FilmBindingAdapters {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String backdropUrl) {
        if (TextUtils.isEmpty(backdropUrl)) {
            imageView.setImageDrawable(null);
        } else {
            String fullImageUrl = String.format(
                    Locale.getDefault(),
                    "https://image.tmdb.org/t/p/w1280%1$s",
                    backdropUrl
            );
            Picasso.get().load(fullImageUrl).into(imageView);
        }
    }

}
