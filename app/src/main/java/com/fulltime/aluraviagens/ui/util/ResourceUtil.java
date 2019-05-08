package com.fulltime.aluraviagens.ui.util;

import android.content.Context;
import android.content.res.Resources;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static int pegaImagem(Context context, String caminhoImagem) {
        Resources resources = context.getResources();
        return resources.getIdentifier(caminhoImagem, DRAWABLE, context.getPackageName());
    }
}