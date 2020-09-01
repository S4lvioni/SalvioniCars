package com.example.dominio;

import com.example.appveiculo.Combustivel;

import java.util.ArrayList;
import java.util.List;

public class CombustivelDAO {
    private static List<Combustiveis> dado = new ArrayList<>();
    private CombustivelDAO(){}
    public static  void Salvar(Combustiveis combustivel){
        dado.add(combustivel);
    }

    public static List getDados(final String carId){
        List<Combustiveis> filtrados = new ArrayList<>();
        for (Combustiveis combustivel: dado) {
           filtrados.add(combustivel);
        }
        return dado;
    }
}
