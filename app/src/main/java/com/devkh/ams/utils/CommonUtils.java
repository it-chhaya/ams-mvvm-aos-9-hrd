package com.devkh.ams.utils;

import android.content.Context;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public final class CommonUtils {

    public static CircularProgressIndicator showLoading(Context context) {
        CircularProgressIndicator loading = new CircularProgressIndicator(context);
        loading.show();
        return loading;
    }

}
