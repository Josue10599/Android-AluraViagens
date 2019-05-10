package com.fulltime.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.fulltime.aluraviagens.R;
import com.fulltime.aluraviagens.model.Pacote;
import com.fulltime.aluraviagens.ui.util.DataUtil;
import com.fulltime.aluraviagens.ui.util.MoedaUtil;
import com.fulltime.aluraviagens.ui.util.ResourceUtil;

import static com.fulltime.aluraviagens.ui.activity.ListaPacotesActivity.PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        configuraActionBar();
        pegaPacote();
    }

    private void configuraActionBar() {
        ActionBar bar = getSupportActionBar();
        bar.setTitle(getString(R.string.titulo_resumo_compra));
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mostraTelaListaPacotes();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        mostraTelaListaPacotes();
    }

    private void mostraTelaListaPacotes() {
        Intent telaListaPacotes = new Intent(this, ListaPacotesActivity.class);
        telaListaPacotes.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Limpa a fila de telas
        startActivity(telaListaPacotes);
    }

    private void pegaPacote() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);
            mostraCampos(pacote);
        }
    }

    private void mostraCampos(Pacote pacote) {
        mostraImagem(pacote);
        mostraLocal(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imageViewLocal = findViewById(R.id.resumo_compra_imagem_local);
        imageViewLocal.setImageResource(ResourceUtil.pegaImagem(this, pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView textViewLocal = findViewById(R.id.resumo_compra_local);
        textViewLocal.setText(pacote.getLocal());
    }

    private void mostraData(Pacote pacote) {
        TextView textViewData = findViewById(R.id.resumo_compra_data);
        textViewData.setText(DataUtil.periodoEmTexto(this, pacote.getDias()));
    }

    private void mostraPreco(Pacote pacote) {
        TextView textViewPreco = findViewById(R.id.resumo_compra_preco);
        textViewPreco.setText(MoedaUtil.precoFormatado(this, pacote.getPreco()));
    }

}
