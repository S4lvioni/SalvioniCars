package com.example.dominio;

import android.content.Intent;

import java.io.Serializable;
import java.util.UUID;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private Integer ano;
    private String ident_id;

    public String getIdent_id() {
        return ident_id;
    }

    public Carro() {
        this.ident_id = UUID.randomUUID().toString();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Carro:"+ '\''+
                "marca:" + marca + '\'' +
                ", modelo:'" + modelo + '\'' +
                ", cor:" + cor + '\'' +
                ", placa:'" + placa + '\'' +
                ", ano:" + ano +
                '}';
    }
}
