/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manojlovic
 */
public class DBUtil {
    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/Proba02";
    private static String username = "root";
    private static String password = "";

    public static void openConnection() throws SQLException {
        con = DriverManager.getConnection(url, username, password);
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
    
    //metoda za dodavanje automobila u bazu
    public static void addAuto(Automobili auto) {
        try {
            con = DriverManager.getConnection(url, username, password);
            Statement st = (Statement) con.createStatement();
            st.execute("INSERT INTO automobili (ID,NAZIV,GODISTE,CENA) "
                    + "" + "VALUES ('" + auto.getID() + "','" + auto.getNAZIV()
                    + "','" + auto.getGODISTE() + "','" + auto.getCENA() + "')");
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
     //metoda za ispis svih automobila koji se nalaze u bazi
    public static List<Automobili> getAllAutomobili() {
        ArrayList<Automobili> listaAutomobila = new ArrayList<Automobili>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM automobili";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String naziv = rs.getString("NAZIV");
                int godiste = rs.getInt("GODISTE");
                int cena = rs.getInt("CENA");
                listaAutomobila.add(new Automobili(id, naziv, godiste, cena));
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAutomobila;
    }
    
    //za editovanje-update baze
    public static void editAutomobili(Automobili auto) throws SQLException {
        openConnection();
        PreparedStatement sql = con.prepareStatement("UPDATE `automobili` SET  `NAZIV` = ?, `GODISTE`=?, `CENA`=?, WHERE ID = ?");
        sql.setInt(1, auto.getID());
        sql.setString(2, auto.getNAZIV());
        sql.setInt(3, auto.getGODISTE());
        sql.setInt(4, auto.getCENA());

        sql.execute();

        closeConnection();
    }
       
    public static List<Automobili> getAll() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        ResultSet rs = sql.executeQuery("select * from automobili order by ID asc");
        List<Automobili> auta = new ArrayList<>();

        while (rs.next()) {
           
            auta.add(new Automobili(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
        }

        closeConnection();
        return auta;

    }
    
     //metoda za ispis-filtriranje automobila prema zadatom kriterijumu
    public static List<Automobili> getGodisteStarijeOd2010() {
        ArrayList<Automobili> listaAutomobila = new ArrayList<Automobili>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM automobili WHERE GODISTE <= 2010";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String naziv = rs.getString("NAZIV");
                int godiste = rs.getInt("GODISTE");
                int cena = rs.getInt("CENA");
                listaAutomobila.add(new Automobili(id, naziv, godiste, cena));
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAutomobila;
        
    }
    //metoda za ispis-filtriranje automobila prema zadatom kriterijumu

    /**
     *
     * @return
     */
    public static List<Automobili> getGodisteMladjeOd2010() {
        ArrayList<Automobili> listaAutomobila = new ArrayList<Automobili>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM automobili WHERE GODISTE > 2010";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String naziv = rs.getString("NAZIV");
                int godiste = rs.getInt("GODISTE");
                int cena = rs.getInt("CENA");
                listaAutomobila.add(new Automobili(id, naziv, godiste, cena));
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAutomobila;    
    }
    /**
     *
     * @param karta
     * @throws SQLException
     */
    //mtoda ya brisanje automobila
    public static void brisanjeAutomobila(Automobili karta) throws SQLException {
        openConnection();
 
        PreparedStatement sql = con.prepareStatement("DELETE FROM `automobili` WHERE id =? ");
        sql.setLong(1, karta.getID());

        sql.execute();

        closeConnection();
    }
          
}   
