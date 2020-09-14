package com.example.appveiculo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dominio.CombustiveisDAOBanco;

public class ListaAbastecimentos extends AppCompatActivity {
    private ListView ListarCombustiveis;
    private String carId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_abastecimentos);
        Intent it13 = getIntent();
        Bundle bundle = it13.getExtras();
        if (bundle != null) {
            carId = (String) bundle.get("carId");
        }
        ListarCombustiveis=findViewById(R.id.ListagemCombustiveis);
        AtualizarLista();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AtualizarLista();
    }

    public void AtualizarLista(){
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, CombustiveisDAOBanco.getDados(carId));
        ListarCombustiveis.setAdapter(adapter);
    }
    }
