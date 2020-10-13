package com.example.pacotesdeviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pacotesdeviagens.R;
import com.example.pacotesdeviagens.model.Pacote;
import com.example.pacotesdeviagens.util.DataUtil;
import com.example.pacotesdeviagens.util.DiasUtil;
import com.example.pacotesdeviagens.util.MoedaUtil;
import com.example.pacotesdeviagens.util.ResourceUtil;

import static com.example.pacotesdeviagens.ui.activity.PacoteAcrivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APP_BAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getParcelableExtra(CHAVE_PACOTE);
            mostraLocal(pacote);
            mostraImagemDaCidade(pacote);
            nostraDias(pacote);
            mostraPreco(pacote);
            mostraData(pacote);
            configuraBotaoPagamento(pacote);
        }
    }

    private void configuraBotaoPagamento(final Pacote pacote) {
        Button botaoRealizarPagamento = findViewById(R.id.resumo_pacote_botao_pagamento);
        botaoRealizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamento(pacote);
            }
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        preco.setText(MoedaUtil.formataValorParaPadraoDaMoedaBrasileira(pacote.getPreco()));
    }

    private void nostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        dias.setText(DiasUtil.formataEmTexto(pacote.getDias()));
    }

    private void mostraImagemDaCidade(Pacote pacote) {
        ImageView imagemCidade = findViewById(R.id.resumo_pacote_banner_imagem_cidade);
        imagemCidade.setImageDrawable(ResourceUtil.obterDrawable(this, pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        data.setText(DataUtil.periodoEmTexto(pacote.getDias()));
    }

}