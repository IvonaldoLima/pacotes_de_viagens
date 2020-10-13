package com.example.pacotesdeviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pacotesdeviagens.R;
import com.example.pacotesdeviagens.model.Pacote;
import com.example.pacotesdeviagens.util.DataUtil;
import com.example.pacotesdeviagens.util.MoedaUtil;
import com.example.pacotesdeviagens.util.ResourceUtil;

import static com.example.pacotesdeviagens.ui.activity.PacoteAcrivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APP_BAR);
        carregarPacoteRecebido();
    }

    private void carregarPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getParcelableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraImagemDaCidade(pacote);
        mostraLocal(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
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