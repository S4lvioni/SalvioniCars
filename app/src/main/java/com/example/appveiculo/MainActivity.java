package com.example.appveiculo;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.appveiculo.ListarVeiculo;

import com.example.dominio.Carro;
import com.example.dominio.CarroDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CadastroVeiculo(View view) {
        Intent it = new Intent(MainActivity.this, CadastroVeiculo.class);
        it.putExtra("id1", "string");
        startActivity(it);
    }

    public void ListarVeiculo(View view) {
        Intent it2 = new Intent(MainActivity.this, ListarVeiculo.class);
        startActivity(it2);
    }
}
