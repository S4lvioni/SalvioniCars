package com.example.dominio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

public class CarroDAOBanco {
    private SQLiteDatabase dadosbanco;

    public CarroDAOBanco(SQLiteDatabase dadosbanco) {
        this.dadosbanco = dadosbanco;
    }
    public void InserirCarro(Carro carro){
        ContentValues values = new ContentValues();

        values.put("MARCA",carro.getMarca());
        values.put("MODELO",carro.getModelo());
        values.put("COR",carro.getCor());
        values.put("PLACA",carro.getPlaca());
        values.put("ANO",carro.getAno());

        dadosbanco.insertOrThrow("CARRO",null,values);
    }
    public void removerCarro(Carro carro){
        dadosbanco.delete("CARRO","ID=?",new String[]{carro.getIdent_id().toString()});
    }
    public void AtualizaCarro(Carro carro){
        ContentValues values = new ContentValues();
        values.put("MARCA", carro.getMarca());
        values.put("MODELO", carro.getModelo());
        values.put("COR", carro.getCor());
        values.put("PLACA", carro.getPlaca());
        values.put("ANO", carro.getAno());
        dadosbanco.update("CARRO", values, "id=?", new String[]{carro.getIdent_id().toString()});
    }
    public List<Carro> getCarros(){
        List<Carro>carros = new LinkedList<>();
        Cursor cursor;
        Carro carro;

        cursor = dadosbanco.rawQuery("SELECT * FROM CARRO ",null);

        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {

            carro =new Carro();
            carro.setIdent_id(
                    cursor.getString(cursor.getColumnIndex("ID"))
            );
            carro.setMarca(cursor.getString(cursor.getColumnIndex("MARCA")));
            carro.setModelo(cursor.getString(cursor.getColumnIndex("MODELO")));
            carro.setCor(cursor.getString(cursor.getColumnIndex("COR")));
            carro.setPlaca(cursor.getString(cursor.getColumnIndex("PLACA")));
            carro.setAno(cursor.getInt(cursor.getColumnIndex("ANO")));

            carros.add(carro);
            cursor.moveToNext();
        }
        return carros;
    }

}
