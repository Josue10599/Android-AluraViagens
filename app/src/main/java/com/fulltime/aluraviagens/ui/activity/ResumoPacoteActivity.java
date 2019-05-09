package com.fulltime.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fulltime.aluraviagens.R;
import com.fulltime.aluraviagens.model.Pacote;
import com.fulltime.aluraviagens.ui.util.DataUtil;
import com.fulltime.aluraviagens.ui.util.DiasUtil;
import com.fulltime.aluraviagens.ui.util.MoedaUtil;
import com.fulltime.aluraviagens.ui.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(getString(R.string.titulo_resumo_pacote));

        Intent intent = getIntent();
        final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

        colocaImagem(pacote);
        colocaLocal(pacote);
        colocaDias(pacote);
        colocaData(pacote);
        colocaPreco(pacote);

        Button botaoPagamento = findViewById(R.id.resumo_pacote_botao);
        botaoPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaPagamento = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                telaPagamento.putExtra("pacote", pacote);
                startActivity(telaPagamento);
            }
        });
    }

    private void colocaImagem(Pacote pacote) {
        ImageView imageViewLocal = findViewById(R.id.resumo_pacote_imagem);
        imageViewLocal.setImageResource(ResourceUtil.pegaImagem(this, pacote.getImagem()));
    }

    private void colocaLocal(Pacote pacote) {
        TextView textViewLocal = findViewById(R.id.resumo_pacote_local);
        textViewLocal.setText(pacote.getLocal());
    }

    private void colocaDias(Pacote pacote) {
        TextView textViewDias = findViewById(R.id.resumo_pacote_dias);
        textViewDias.setText(DiasUtil.diasFormatado(this, pacote.getDias()));
    }

    private void colocaData(Pacote pacote) {
        TextView textViewData = findViewById(R.id.resumo_pacote_data);
        textViewData.setText(DataUtil.periodoEmTexto(this, pacote.getDias()));
    }

    private void colocaPreco(Pacote pacote) {
        TextView textViewPreco = findViewById(R.id.resumo_pacote_preco);
        textViewPreco.setText(MoedaUtil.precoFormatado(this, pacote.getPreco()));
    }
}
