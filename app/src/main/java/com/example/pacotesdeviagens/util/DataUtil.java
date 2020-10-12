package com.example.pacotesdeviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_E_MES);
        String dataFomatadaIda = formatoBrasileiro.format(dataIda.getTime());
        String dataFomatadaVolta = formatoBrasileiro.format(dataVolta.getTime());

        return String.format("%s - %s de %d", dataFomatadaIda, dataFomatadaVolta, dataVolta.get(Calendar.YEAR));
    }
}
