package com.example.appveiculo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dominio.Carro;
import com.example.dominio.CarroDAO;

import java.util.ArrayList;

public class ListarVeiculo extends AppCompatActivity {
    private ListView ListarCarros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_veiculo);
        ListarCarros = findViewById(R.id.ListaCarros);
        AtualizarLista();
    }
    public void AtualizarLista(){
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, CarroDAO.getDados());
        ListarCarros.setAdapter(adapter);
        ListarCarros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it5 = new Intent(ListarVeiculo.this,ListViewMenu.class);
                Carro carro = (Carro) CarroDAO.getDados().get(position);
                it5.putExtra("carId",carro.getIdent_id());
                startActivity(it5);
            }
        });
    }
    public void BotaoVoltar(View view){
        super.onBackPressed();
    }

}