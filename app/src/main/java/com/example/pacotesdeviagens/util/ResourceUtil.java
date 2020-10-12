package com.example.pacotesdeviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable obterDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE, context.getPackageName());
        return ResourcesCompat.getDrawable(context.getResources(), idDrawable, null);
    }
}
