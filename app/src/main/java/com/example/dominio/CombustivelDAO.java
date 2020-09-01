package com.example.dominio;

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
            if (combustivel.getCarro().getIdent_id().equals(carId)) {
                filtrados.add(combustivel);
            }
        }
        return filtrados;
    }
}
