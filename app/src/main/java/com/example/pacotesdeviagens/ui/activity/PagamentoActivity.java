package com.example.pacotesdeviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pacotesdeviagens.R;
import com.example.pacotesdeviagens.model.Pacote;
import com.example.pacotesdeviagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APP_BAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo", 2, new BigDecimal("536.74"));

        mostraPreco(pacoteSaoPaulo);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        preco.setText(MoedaUtil.formataValorParaPadraoDaMoedaBrasileira(pacote.getPreco()));
    }
}