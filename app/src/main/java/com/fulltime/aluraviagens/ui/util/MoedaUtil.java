package com.fulltime.aluraviagens.ui.util;

import android.content.Context;

import com.fulltime.aluraviagens.R;

import java.math.BigDecimal;

public class MoedaUtil {
    public static String precoFormatado(Context context, BigDecimal preco) {
        return String.format(context.getString(R.string.item_pacote_valor)
                , preco.doubleValue()).replace('.', ',');
    }
}