package com.fulltime.aluraviagens.ui.util;

import android.content.Context;
import android.content.res.Resources;

import com.fulltime.aluraviagens.R;

public class DiasUtil {
    public static String diasFormatado(Context context, int dias) {
        Resources resources = context.getResources();
        return String.format(resources.
                getQuantityString(R.plurals.item_pacote_dias, dias), dias);
    }
}