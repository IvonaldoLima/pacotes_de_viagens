package com.example.pacotesdeviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pacotesdeviagens.util.DiasUtil;
import com.example.pacotesdeviagens.util.MoedaUtil;
import com.example.pacotesdeviagens.R;
import com.example.pacotesdeviagens.util.ResourceUtil;
import com.example.pacotesdeviagens.model.Pacote;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Object getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pacotes.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = pacotes.get(position);

        mostraLocal(viewCriada, pacote);
        mostraDia(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView itemPacoteImagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable imagemDaCidade = ResourceUtil.obterDrawable(context, pacote.getImagem());
        itemPacoteImagem.setImageDrawable(imagemDaCidade);
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView itemPacotePreco = viewCriada.findViewById(R.id.item_pacote_preco);
        String preco = MoedaUtil.formataValorParaPadraoDaMoedaBrasileira(pacote.getPreco());
        itemPacotePreco.setText(preco);
    }

    private void mostraDia(View viewCriada, Pacote pacote) {
        TextView itemPacoteDias = viewCriada.findViewById(R.id.item_pacote_dias);
        String dias = DiasUtil.formataEmTexto(pacote.getDias());
        itemPacoteDias.setText(dias);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView itemPacoteLocal = viewCriada.findViewById(R.id.item_pacote_local);
        itemPacoteLocal.setText(pacote.getLocal());
    }

}
