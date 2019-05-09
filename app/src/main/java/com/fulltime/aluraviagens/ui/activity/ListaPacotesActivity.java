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

    private ListView lista;
    private List<Pacote> pacotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(R.string.titulo_app_bar);

        configuraLista();

        itemSelecionado();
    }

    private void configuraLista() {
        lista = findViewById(R.id.lista_pacotes_listview);
        pacotes = new PacoteDAO().lista();
        lista.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }

    private void itemSelecionado() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                intent.putExtra("pacote", pacotes.get(position));
                startActivity(intent);
            }
        });
    }
}
