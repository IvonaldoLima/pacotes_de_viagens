package com.example.pacotesdeviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pacotesdeviagens.R;
import com.example.pacotesdeviagens.model.Pacote;
import com.example.pacotesdeviagens.util.MoedaUtil;

import static com.example.pacotesdeviagens.ui.activity.PacoteAcrivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APP_BAR);

        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intent.getParcelableExtra(CHAVE_PACOTE);
            mostraPreco(pacote);
            configuraBotaoFinalizaCompra(pacote);
        }
    }

    private void configuraBotaoFinalizaCompra(final Pacote pacote) {
        Button botaoFinalizarCompra = findViewById(R.id.pagamento_finalizar_compra);
        botaoFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        preco.setText(MoedaUtil.formataValorParaPadraoDaMoedaBrasileira(pacote.getPreco()));
    }
}