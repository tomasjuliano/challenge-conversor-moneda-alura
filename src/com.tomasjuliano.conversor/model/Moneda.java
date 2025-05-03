package com.tomasjuliano.conversor.model;

public class Moneda {
    private String codigo;
    private double monto;

    public Moneda(String codigo, double monto) {
        this.codigo = codigo;
        this.monto = monto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}