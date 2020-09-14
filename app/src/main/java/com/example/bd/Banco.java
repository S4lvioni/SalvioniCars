package com.example.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Banco extends SQLiteOpenHelper {


    public Banco(@Nullable Context context) {
        super(context, "bancoCarro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CARRO( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "MARCA VARCHAR(20) NOT NULL," +
                "MODELO VARCHAR(20) NOT NULL," +
                "COR VARCHAR(20) NOT NULL, " +
                "PLACA VARCHAR(7),"+
                "ANO INTEGER,"+
                "ID2 INTEGER"+
                ")");
            db.execSQL("CREATE TABLE COMBUSTIVEL( " +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "LITROS INTEGER(10) NOT NULL," +
                    "VALOR REAL(10) NOT NULL" +
                    ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {

    }
}
