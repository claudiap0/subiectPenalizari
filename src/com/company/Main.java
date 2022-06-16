package com.company;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Apartament> listaApartamente = new ArrayList<>();
        String caleFisierText = "/Users/claudiapistol/IdeaProjects/subiectPenalizari/apartamente.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(caleFisierText))){
            String linie;
            while((linie = bufferedReader.readLine()) != null) {
                String[] elemente = linie.split(",");
                int numarApartament = Integer.parseInt(elemente[0]);
                String nume = elemente[1];
                Double plata = Double.parseDouble(elemente[2]);

                Apartament apartament = new Apartament(numarApartament, nume, plata);
                listaApartamente.add(apartament);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Double valoareTotala = 0.0;

        for(Apartament a : listaApartamente){
            valoareTotala += a.getValoarePlata();
        }

        System.out.println("Exercitiul 1");
        System.out.println("total intretinere " + valoareTotala + " lei");


        System.out.println("Exercitiul 2");
        listaApartamente
                .stream()
                .sorted(Comparator.comparingDouble(Apartament::getValoarePlata).reversed())
                .forEach(a->System.out.println(a.getValoarePlata() + " " + a.getNrApartament() + " " + a.getNume()));


        List<Penalizare> listaPenalizari = new ArrayList<>();
        String caleFisierJson = "/Users/claudiapistol/IdeaProjects/subiectPenalizari/penalizari.json";

        try(var fisier = new FileReader(caleFisierJson)) {
            var jsonPenalizari = new JSONArray(new JSONTokener(fisier));

            for(int i=0;i<jsonPenalizari.length();i++) {
                var jsonPenalizare = jsonPenalizari.getJSONObject(i);

                Penalizare penalizare = new Penalizare(
                        jsonPenalizare.getInt("numar_apartament"),
                        jsonPenalizare.getDouble("penalizare")
                );

                listaPenalizari.add(penalizare);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Penalizare p: listaPenalizari)
            System.out.println(p);

        System.out.println("Exercitiul 3");

        for(Apartament a : listaApartamente) {
            listaPenalizari
                    .stream()
                    .filter(p -> p.getNrApartament() == a.getNrApartament())
                    .forEach(p->System.out.println(a.getValoarePlata()+p.getPenalizare() + " " + a.getNrApartament() + " " + a.getNume()));
        }

    }
}
