package com.company;

public class Penalizare {
    private int nrApartament;
    private Double penalizare;

    public Penalizare() {
    }

    public Penalizare(int nrApartament, Double penalizare) {
        this.nrApartament = nrApartament;
        this.penalizare = penalizare;
    }

    public int getNrApartament() {
        return nrApartament;
    }

    public void setNrApartament(int nrApartament) {
        this.nrApartament = nrApartament;
    }

    public Double getPenalizare() {
        return penalizare;
    }

    public void setPenalizare(Double penalizare) {
        this.penalizare = penalizare;
    }

    @Override
    public String toString() {
        return "Penalizare{" +
                "nrApartament=" + nrApartament +
                ", penalizare=" + penalizare +
                '}';
    }
}
