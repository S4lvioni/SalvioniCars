package com.example.appveiculo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bd.Banco;
import com.example.dominio.Carro;
import com.example.dominio.CarroDAOBanco;

public class ListarVeiculo extends AppCompatActivity {
    private ListView ListarCarros;
    public CarroDAOBanco carrodaobanco;
    private Banco banco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        banco = new Banco(this);
        setContentView(R.layout.activity_listar_veiculo);
        ListarCarros = findViewById(R.id.ListaCarros);
        AtualizarLista();


    }
    public void AtualizarLista(){
        carrodaobanco = new CarroDAOBanco(banco.getReadableDatabase());
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, carrodaobanco.getCarros());
        ListarCarros.setAdapter(adapter);
        ListarCarros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it5 = new Intent(ListarVeiculo.this,ListViewMenu.class);
                Carro carro = (Carro) carrodaobanco.getCarros().get(position);
                it5.putExtra("carId",carro.getIdent_id());
                startActivity(it5);
            }
        });
    }
    public void BotaoVoltar(View view){
        super.onBackPressed();
    }

}