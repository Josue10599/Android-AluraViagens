package com.fulltime.aluraviagens.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fulltime.aluraviagens.R;
import com.fulltime.aluraviagens.model.Pacote;
import com.fulltime.aluraviagens.ui.util.DiasUtil;
import com.fulltime.aluraviagens.ui.util.MoedaUtil;
import com.fulltime.aluraviagens.ui.util.ResourceUtil;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View lista = criaLayoutLista(parent);

        Pacote pacote = pacotes.get(position);

        mostraImagem(lista, pacote);
        mostraLocal(lista, pacote);
        mostraDias(lista, pacote);
        mostraValor(lista, pacote);

        return lista;
    }

    private View criaLayoutLista(ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_pacote, parent,false);
    }

    private void mostraValor(View inflate, Pacote pacote) {
        TextView valor = inflate.findViewById(R.id.item_pacote_valor);
        String textMoeda = MoedaUtil.precoFormatado(context, pacote.getPreco());
        valor.setText(textMoeda);
    }


    private void mostraDias(View inflate, Pacote pacote) {
        TextView dias = inflate.findViewById(R.id.item_pacote_dias);
        String textDias = DiasUtil.diasFormatado(context, pacote.getDias());
        dias.setText(textDias);
    }


    private void mostraImagem(View inflate, Pacote pacote) {
        ImageView imagem = inflate.findViewById(R.id.item_pacote_imagem);
        int id = ResourceUtil.pegaImagem(context, pacote.getImagem());
        imagem.setImageResource(id);
    }


    private void mostraLocal(View inflate, Pacote pacote) {
        TextView local = inflate.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
