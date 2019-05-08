package com.fulltime.aluraviagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fulltime.aluraviagens.R;
import com.fulltime.aluraviagens.dao.PacoteDAO;
import com.fulltime.aluraviagens.model.Pacote;
import com.fulltime.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.Arrays;
import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(R.string.titulo_app_bar);
        configuraLista();
    }

    private void configuraLista() {
        ListView lista = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        lista.setAdapter(new ListaPacotesAdapter(pacotes,this));
    }
}
