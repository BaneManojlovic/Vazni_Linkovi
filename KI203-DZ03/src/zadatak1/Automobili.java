/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

/**
 *
 * @author manojlovic
 */
public class Automobili {
    private int ID;
    private String NAZIV;
    private int GODISTE;
    private int CENA;

    public Automobili() {
    }

    public Automobili(int ID, String NAZIV, int GODISTE, int CENA) {
        this.ID = ID;
        this.NAZIV = NAZIV;
        this.GODISTE = GODISTE;
        this.CENA = CENA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAZIV() {
        return NAZIV;
    }

    public void setNAZIV(String NAZIV) {
        this.NAZIV = NAZIV;
    }

    public int getGODISTE() {
        return GODISTE;
    }

    public void setGODISTE(int GODISTE) {
        this.GODISTE = GODISTE;
    }

    public int getCENA() {
        return CENA;
    }

    public void setCENA(int CENA) {
        this.CENA = CENA;
    }

    @Override
    public String toString() {
        return "Automobil - " + "ID broj: " + ID + ", model: " + NAZIV + ", godina proizvodnje: " + GODISTE + ", cena: " + CENA + ".\n";
    }
    
}
