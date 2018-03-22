/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak01;

/**
 *
 * @author manojlovic
 */
public class Automobili {

    //atributi klase
    private static int id;
    private static String model;
    private static int godiste;
    private static double cena;

    //construktori
    public Automobili() {
    }

    public Automobili(int id, String model, int godiste, double cena) {
        this.id = id;
        this.model = model;
        this.godiste = godiste;
        this.cena = cena;
    }

    public Automobili(String model, int godiste, double cena) {
        this.model = model;
        this.godiste = godiste;
        this.cena = cena;
    }

    //geteri i seteri
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Automobili.id = id;
    }

    public static String getModel() {
        return model;
    }

    public static void setModel(String model) {
        Automobili.model = model;
    }

    public static int getGodiste() {
        return godiste;
    }

    public static void setGodiste(int godiste) {
        Automobili.godiste = godiste;
    }

    public static double getCena() {
        return cena;
    }

    public static void setCena(double cena) {
        Automobili.cena = cena;
    }

    //metoda za ispis
    @Override
    public String toString() {
        return "Rb: " + id + " " + model + ", godiste: " + godiste + ", cena: " + cena + ".";
    }
}