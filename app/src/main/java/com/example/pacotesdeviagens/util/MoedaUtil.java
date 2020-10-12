package com.example.pacotesdeviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";

    public static String formataValorParaPadraoDaMoedaBrasileira(BigDecimal valor) {
        return DecimalFormat.getCurrencyInstance(
                new Locale(PORTUGUES, BRASIL)).format(valor).replace(FORMATO_PADRAO, FORMATO_COM_ESPACO);
    }
}
