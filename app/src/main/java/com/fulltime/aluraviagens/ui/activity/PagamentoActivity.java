package com.fulltime.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fulltime.aluraviagens.R;
import com.fulltime.aluraviagens.model.Pacote;
import com.fulltime.aluraviagens.ui.util.MoedaUtil;

import static com.fulltime.aluraviagens.ui.activity.ListaPacotesActivity.PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        configuraActionBar();
        pegaPacote();
    }

    private void configuraActionBar() {
        ActionBar bar = getSupportActionBar();
        bar.setTitle(getString(R.string.titulo_pagamento));
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    private void pegaPacote() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);
            mostraPreco(pacote);
            configuraBotaoFinalizarCompra(pacote);
        }
    }

    private void configuraBotaoFinalizarCompra(final Pacote pacote) {
        Button buttonFinalizar = findViewById(R.id.pagamento_botao_finalizar_compra);
        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaResumoCompra = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                telaResumoCompra.putExtra(PACOTE, pacote);
                startActivity(telaResumoCompra);
            }
        });
    }

    private void mostraPreco(Pacote pacote) {
        TextView textViewPreco = findViewById(R.id.pagamento_preco_pacote);
        textViewPreco.setText(MoedaUtil.precoFormatado(this, pacote.getPreco()));
    }
}
