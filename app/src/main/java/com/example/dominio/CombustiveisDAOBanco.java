package com.example.dominio;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CombustiveisDAOBanco {
    private SQLiteDatabase bancocombus;
    private static List<Combustiveis> dado = new ArrayList<>();
    public static  void Salvar(Combustiveis combustivel){
        dado.add(combustivel);
    }

    public CombustiveisDAOBanco(SQLiteDatabase bancocombus) {
        this.bancocombus = bancocombus;
    }
    public static List getDados(final String carId){
        List<Combustiveis> filtrados = new ArrayList<>();
        for (Combustiveis combustivel: dado) {
            filtrados.add(combustivel);
        }
        return dado;
    }
}
