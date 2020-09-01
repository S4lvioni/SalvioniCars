package com.example.dominio;

import android.content.Intent;

import com.example.appveiculo.ListarVeiculo;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private static List<Carro> dados = new ArrayList<>();
    public CarroDAO(){};

    public static void SalvarCarro (Carro carro){
        carro.setIdent_id((dados.size()+1)+"");
        if(!dados.contains(carro)){
            dados.add(carro);
        }else{
            dados.remove(carro);
            dados.add(carro);
            dados.set(
                    dados.indexOf(carro),carro
            );
        }
    }
    public static void RemoverCarro (Carro carro){
        dados.remove(carro);
    }
    public static List getDados (){
        return dados;
    }
}
