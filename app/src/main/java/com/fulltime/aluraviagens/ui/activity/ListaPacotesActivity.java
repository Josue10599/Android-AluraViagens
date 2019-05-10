package com.fulltime.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fulltime.aluraviagens.R;
import com.fulltime.aluraviagens.dao.PacoteDAO;
import com.fulltime.aluraviagens.model.Pacote;
import com.fulltime.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String PACOTE = "pacote";
    private ListView lista;
    private List<Pacote> pacotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(R.string.titulo_app_bar);
        configuraLista();
    }

    private void configuraLista() {
        pacotes = new PacoteDAO().lista();
        lista = findViewById(R.id.lista_pacotes_listview);
        lista.setAdapter(new ListaPacotesAdapter(pacotes, this));
        itemSelecionado();
    }

    private void itemSelecionado() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostraTelaResumoPacote(position);
            }
        });
    }

    private void mostraTelaResumoPacote(int position) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(PACOTE, pacotes.get(position));
        startActivity(intent);
    }
}
