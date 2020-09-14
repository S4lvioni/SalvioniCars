package com.example.dominio;


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

    public void setIdent_id(String ident_id) {
        this.ident_id = ident_id;
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
        return "Marca:"+marca+" "+"Modelo:"+modelo+" "+"Cor:"+cor+" "+"Placa:"+placa+" "+"Ano:"+ano;
    }
}
