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

        View viewCriada;
        ViewHolder holder;

        if(convertView == null){
            viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
            holder = new ViewHolder(viewCriada);
            viewCriada.setTag(holder);
        }else {
            viewCriada = convertView;
            holder = (ViewHolder) convertView.getTag();
        }
        Pacote pacote = pacotes.get(position);

        mostraLocal(holder, pacote);
        mostraDia(holder, pacote);
        mostraPreco(holder, pacote);
        mostraImagem(holder, pacote);

        return viewCriada;
    }

    private void mostraImagem(ViewHolder holder, Pacote pacote) {
        Drawable imagemDaCidade = ResourceUtil.obterDrawable(context, pacote.getImagem());
        holder.itemPacoteImagem.setImageDrawable(imagemDaCidade);
    }

    private void mostraPreco(ViewHolder holder, Pacote pacote) {
        String preco = MoedaUtil.formataValorParaPadraoDaMoedaBrasileira(pacote.getPreco());
        holder.itemPacotePreco.setText(preco);
    }

    private void mostraDia(ViewHolder holder, Pacote pacote) {
        String dias = DiasUtil.formataEmTexto(pacote.getDias());
        holder.itemPacoteDias.setText(dias);
    }

    private void mostraLocal(ViewHolder holder, Pacote pacote) {
        holder.itemPacoteLocal.setText(pacote.getLocal());
    }

    class ViewHolder {

        final ImageView itemPacoteImagem;
        final TextView itemPacotePreco;
        final TextView itemPacoteDias;
        final TextView itemPacoteLocal;

        public ViewHolder(View view) {
            itemPacoteImagem =  (ImageView) view.findViewById(R.id.item_pacote_imagem);
            itemPacotePreco = (TextView) view.findViewById(R.id.item_pacote_preco);
            itemPacoteDias = (TextView) view.findViewById(R.id.item_pacote_dias);
            itemPacoteLocal = (TextView) view.findViewById(R.id.item_pacote_local);
        }
    }
}
