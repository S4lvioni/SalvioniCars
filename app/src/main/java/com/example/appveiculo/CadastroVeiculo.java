package com.example.appveiculo;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.appveiculo.ListarVeiculo;
import com.example.dominio.Carro;
import com.example.dominio.CarroDAO;

import java.util.List;
import java.util.UUID;

public class CadastroVeiculo extends AppCompatActivity {
    private String carId;
    private EditText marca;
    private EditText modelo;
    private EditText cor;
    private EditText placa;
    private EditText ano;
    private Carro carrotempedit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_veiculo);
        marca = findViewById(R.id.InserirMarca);
        modelo = findViewById(R.id.InserirModelo);
        cor = findViewById(R.id.InserirCor);
        placa = findViewById(R.id.InserirPlaca);
        ano = findViewById(R.id.InserirAno);

        Intent it12 = getIntent();
        Bundle bundle = it12.getExtras();
        if (bundle != null) {
            carId = (String)bundle.get("carId");
            List<Carro> controle = CarroDAO.getDados();
            for (Carro carro: controle) {
                if(carro.getIdent_id().equals(carId)) {
                    carrotempedit = carro;
                }
            }
        }
        if (carrotempedit != null) {
            marca.setText(carrotempedit.getMarca());
            modelo.setText(carrotempedit.getModelo());
            cor.setText(carrotempedit.getCor());
            placa.setText(carrotempedit.getPlaca());
            ano.setText(String.valueOf(carrotempedit.getAno()));
        }
    }
        public void BotaoSalvarVeiculo(View view){
            if (carrotempedit != null) {
                carrotempedit.setModelo(modelo.getText().toString());
                carrotempedit.setMarca(marca.getText().toString());
                carrotempedit.setCor(cor.getText().toString());
                carrotempedit.setPlaca(placa.getText().toString());
                carrotempedit.setAno(Integer.parseInt(ano.getText().toString()));
            }else{
                Carro carro = new Carro();
                carro.setMarca(marca.getText().toString());
                carro.setModelo(modelo.getText().toString());
                carro.setCor(cor.getText().toString());
                carro.setPlaca(placa.getText().toString());
                carro.setAno(Integer.parseInt(ano.getText().toString()));
                CarroDAO.SalvarCarro(carro);
                    System.out.println(CarroDAO.getDados());
                    Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

            }
            super.onBackPressed();
    }
    public void BotaoVoltar(View view){
        super.onBackPressed();
    }
}