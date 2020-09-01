package com.example.appveiculo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dominio.Carro;
import com.example.dominio.CarroDAO;

import java.util.List;

public class ListViewMenu extends AppCompatActivity {
        private String idtemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_menu);
        Intent it9 = getIntent();
        Bundle bundle = it9.getExtras();
        if (bundle != null) {
            idtemp = (String) bundle.get("carId");
        }
    }
    public void ChamarTelaAbastecimento(View view){
        Intent it6 = new Intent(ListViewMenu.this,Combustivel.class);
        it6.putExtra("carId",idtemp);
        startActivity(it6);
    }
    public void EditarCadastro(View view){
        Intent it7 = new Intent(ListViewMenu.this,CadastroVeiculo.class);
        it7.putExtra("carId",idtemp);
        startActivity(it7);
    }
    public void RemoverVeiculo(View view){
        Intent it8 = new Intent(ListViewMenu.this,MainActivity.class);
        List<Carro>carrinhos = CarroDAO.getDados();
        Carro controleremoto = null;
        for (Carro carro : carrinhos){
            if(carro.getIdent_id().equals(idtemp)) {
                controleremoto = carro;
            }
        }
        CarroDAO.RemoverCarro(controleremoto);
        startActivity(it8);
    }
    public void ListarAbastecimentos(View view){
        Intent it11 = new Intent (ListViewMenu.this,ListaAbastecimentos.class);
        it11.putExtra("carId",idtemp);
        startActivityForResult(it11,121);
    }
}