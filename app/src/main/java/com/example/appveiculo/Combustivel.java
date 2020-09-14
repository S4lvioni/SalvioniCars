package com.example.appveiculo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bd.Banco;
import com.example.dominio.Carro;
import com.example.dominio.CarroDAOBanco;
import com.example.dominio.Combustiveis;
import com.example.dominio.CombustiveisDAOBanco;

import java.util.List;

public class Combustivel extends AppCompatActivity {
        private EditText litros;
        private EditText valor;
        private String carId;
        private CarroDAOBanco carrodaobanco;
        private Banco banco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);
        Intent it12 = getIntent();
        Bundle bundle = it12.getExtras();
        litros = findViewById(R.id.Litros);
        valor = findViewById(R.id.Valor);
    }
    public void SalvarGas(View view){
        Combustiveis combustivel = new Combustiveis();
        banco = new Banco(this);
        carrodaobanco = new CarroDAOBanco(banco.getWritableDatabase());
        System.out.println(combustivel);
        List<Carro> carros =carrodaobanco.getCarros();
        System.out.println(carros);
        for (Carro carrinho: carros) {
            System.out.println(carrinho.getIdent_id());
            if (carrinho.getIdent_id().equals(carId)) {
                combustivel.setCarro(carrinho);
            }
        }
        combustivel.setLitros(Double.parseDouble(litros.getText().toString()));
        combustivel.setValor(Double.parseDouble(valor.getText().toString()));
        CombustiveisDAOBanco.Salvar(combustivel);
        System.out.println(combustivel);
        super.onBackPressed();
    }
}