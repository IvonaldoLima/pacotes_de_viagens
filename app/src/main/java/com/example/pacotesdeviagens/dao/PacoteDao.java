package com.example.pacotesdeviagens.dao;

import com.example.pacotesdeviagens.model.Pacote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacoteDao {

    public List<Pacote> lista() {
        return new ArrayList<Pacote>(Arrays.asList(
                new Pacote("Belo Horizonte", "bh", 1, new BigDecimal("400.53")),
                new Pacote("Recife", "recife", 3, new BigDecimal("550.00")),
                new Pacote("Rio de Janeiro", "rio_janeiro", 4, new BigDecimal("700.30"))
        ));
    }
}