package com.fulltime.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fulltime.aluraviagens.R;
import com.fulltime.aluraviagens.model.Pacote;
import com.fulltime.aluraviagens.ui.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(getString(R.string.titulo_pagamento));

        Intent intent = getIntent();
        Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView textViewPreco = findViewById(R.id.pagamento_preco_pacote);
        textViewPreco.setText(MoedaUtil.precoFormatado(this, pacote.getPreco()));
    }
}
