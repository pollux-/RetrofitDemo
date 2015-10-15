package com.pollux.retrofitdemo.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.pollux.retrofitdemo.R;
import com.pollux.retrofitdemo.model.Image.Photos.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SreeKumar on 15/10/15
 */
public class ImageUtil {

    /**
     * Load the images for the row
     *
     * @param rootView
     * @param context
     * @param photos
     */
    public static void loadImages(View rootView, Context context, List<Photo> photos) {

        final ImageView column1 = (ImageView) rootView.findViewById(R.id.thumb1);
        final ImageView column2 = (ImageView) rootView.findViewById(R.id.thumb2);
        final ImageView column3 = (ImageView) rootView.findViewById(R.id.thumb3);
        final ImageView column4 = (ImageView) rootView.findViewById(R.id.thumb4);

        Picasso.with(context).load(context.getString(R.string.image_url, photos.get(0).farm, photos.get(0).server,
                photos.get(0).id, photos.get(0).secret)).into(column1);

        Picasso.with(context).load(context.getString(R.string.image_url, photos.get(1).farm, photos.get(1).server,
                photos.get(1).id, photos.get(1).secret)).into(column2);

        Picasso.with(context).load(context.getString(R.string.image_url, photos.get(2).farm, photos.get(2).server,
                photos.get(2).id, photos.get(2).secret)).into(column3);
        Picasso.with(context).load(context.getString(R.string.image_url, photos.get(3).farm, photos.get(3).server,
                photos.get(3).id, photos.get(3).secret)).into(column4);


    }

}
