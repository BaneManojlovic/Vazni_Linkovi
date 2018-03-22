/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author manojlovic
 */
public class Zadatak1 {

    Scanner sc = new Scanner(System.in);

    public Zadatak1() throws SQLException {
        int izbor = 0;
        System.out.println("------- MENI -------");
        System.out.println("1. Unos novog automobila u bazu.");
        System.out.println("2. Ispis automobila iz baze.");
        System.out.println("3. Izmena automobila u bazi.????????????????");
        System.out.println("4. Filtriranje automobila starijih od 2010 godista.");
        System.out.println("5. Filtriranje automobila mladjih od 2010 godista.");
        System.out.println("6. Brisanje automobila iz baze.");
        System.out.println("7. Izlaz iz programa.");
        System.out.println("\nOdaberite zeljenu opciju: ");
        izbor = sc.nextInt();
        switch (izbor) {
            case 1:
                DBUtil.addAuto(new Automobili(7, "Yugo 55", 1997, 450));
                break;
            case 2:
                System.out.println(DBUtil.getAllAutomobili());
                break;
            case 3:
                /*         List<Automobili> auto = DBUtil.getAll();
                for (Automobili a : auto) {
                    System.out.println(a);
                }
                Automobili k = auto.get(0);
                k.setID(1);
                k.setNAZIV("Mazda 6");
                k.setGODISTE(2007);
                k.setCENA(6500);
                DBUtil.editAutomobili(k);*/
                break;
            case 4:
                System.out.println(DBUtil.getGodisteStarijeOd2010());
                break;
            case 5:
                System.out.println(DBUtil.getGodisteMladjeOd2010());
                break;
            case 6:
                List<Automobili> karte = DBUtil.getAll();
                for (Automobili a : karte) {
                    System.out.println(a);
                }
                DBUtil.brisanjeAutomobila(karte.get(2));
                break;
            case 7:
                System.out.println("Kraj programa!");
                System.exit(0);
                break;
            default:
                System.out.println("Izabrali ste nepostojecu opciju, pokrenite program ponovo!");
        }
    }

    public static void main(String[] args) throws SQLException {
        new Zadatak1();
    }
}
