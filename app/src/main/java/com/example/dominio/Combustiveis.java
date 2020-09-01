package com.example.dominio;

public class Combustiveis {
    private double litros;
    private double valor;
    private Carro carro;

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Combustiveis{" +
                "litros=" + litros +
                ", valor=" + valor +
                '}';
    }
}
