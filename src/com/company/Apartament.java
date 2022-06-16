package com.company;

public class Apartament {
    private int nrApartament;
    private String nume;
    private Double valoarePlata;

    public Apartament() {
    }

    public Apartament(int nrApartament, String nume, Double valoarePlata) {
        this.nrApartament = nrApartament;
        this.nume = nume;
        this.valoarePlata = valoarePlata;
    }

    public int getNrApartament() {
        return nrApartament;
    }

    public void setNrApartament(int nrApartament) {
        this.nrApartament = nrApartament;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Double getValoarePlata() {
        return valoarePlata;
    }

    public void setValoarePlata(Double valoarePlata) {
        this.valoarePlata = valoarePlata;
    }

    @Override
    public String toString() {
        return "Apartament{" +
                "nrApartament=" + nrApartament +
                ", nume='" + nume + '\'' +
                ", valoarePlata=" + valoarePlata +
                '}';
    }
}
