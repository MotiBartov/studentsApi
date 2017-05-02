package com.tikal.resttestapp.utils;

import android.net.Uri;
import android.util.Log;

import com.tikal.resttestapp.api.ApiClient;

/**
 * Created by motibartov on 02/05/2017.
 */

public class Utils {

    public static Uri getImageUri(String image){
        Uri.Builder builder= new Uri.Builder();
        builder.authority(ApiClient.IMAGES_BASE_URL).
                appendPath(image);
        Uri uri = builder.build();

        Log.i("Utils", "getImageUri: " + uri.toString());
        return uri;
    }

}
