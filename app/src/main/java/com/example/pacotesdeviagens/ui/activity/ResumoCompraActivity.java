package com.example.pacotesdeviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pacotesdeviagens.R;
import com.example.pacotesdeviagens.model.Pacote;
import com.example.pacotesdeviagens.util.DataUtil;
import com.example.pacotesdeviagens.util.MoedaUtil;
import com.example.pacotesdeviagens.util.ResourceUtil;

import java.math.BigDecimal;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APP_BAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo", 6, new BigDecimal("750.00"));

        mostraImagemDaCidade(pacoteSaoPaulo);
        mostraLocal(pacoteSaoPaulo);
        mostraData(pacoteSaoPaulo);
        mostraPreco(pacoteSaoPaulo);
    }

    private void mostraImagemDaCidade(Pacote pacote) {
        ImageView imagemCidade = findViewById(R.id.resumo_compra_imagem_pacote);
        imagemCidade.setImageDrawable(ResourceUtil.obterDrawable(this, pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        data.setText(DataUtil.periodoEmTexto(pacote.getDias()));
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        preco.setText(MoedaUtil.formataValorParaPadraoDaMoedaBrasileira(pacote.getPreco()));
    }
}