package com.example.pacotesdeviagens.util;

public class DiasUtil {

    public static final String PLURAL = " Dias";
    public static final String SINGULAR = " Dia";

    public static String formataEmTexto(int valor) {
        if (valor > 1) return valor + PLURAL;
        return valor + SINGULAR;
    }
}
