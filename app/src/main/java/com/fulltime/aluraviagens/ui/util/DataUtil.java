package com.fulltime.aluraviagens.ui.util;

import android.content.Context;

import com.fulltime.aluraviagens.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_MES = "dd/MM";

    public static String periodoEmTexto(Context context, int dias) {
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DIA_MES);
        String dataIda = format.format(calendario.getTime());
        calendario.add(Calendar.DAY_OF_MONTH, dias);
        String dataVolta = format.format(calendario.getTime());
        int ano = calendario.get(Calendar.YEAR);
        String textoFormatado = String.format(context.getString(R.string.resumo_pacote_data_viagem),
                dataIda, dataVolta, ano);
        return textoFormatado;
    }
}