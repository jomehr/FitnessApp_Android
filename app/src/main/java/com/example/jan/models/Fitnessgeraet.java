package com.example.jan.models;


import java.io.Serializable;
import java.util.ArrayList;

public class Fitnessgeraet implements Serializable {

    //Attribute
    private String geraetename;
    private String geraetetyp;
    private int maxtrainingsdauer;
    private int kalorienverbrauchproh;
    private ArrayList<String> muskelliste;
    private boolean stromversorgung;
    private Muskelgruppe muskelgruppe;
    private String [] moeglicheUebungen;

    public Fitnessgeraet(String geraetename, String geraetetyp, int maxtrainingsdauer,
                  int kalorienverbrauchproh, Muskelgruppe muskelgruppe, boolean stromversorgung,
                  String [] moeglicheUebungen) {
        this.setGeraetename(geraetename);
        this.setGeraetetyp(geraetetyp);
        this.setMaxtrainingsdauer(maxtrainingsdauer);
        this.setKalorienverbrauchproh(kalorienverbrauchproh);
        this.muskelliste = muskelgruppe.getMuskelgruppe();
        this.muskelgruppe = muskelgruppe;
        this.setStromversorgung(stromversorgung);
        this.setMoeglicheUebungen(moeglicheUebungen);
    }

    boolean unterstuetztUebung(String uebung) {
        for(String s : this.getMoeglicheUebungen()){
            if (s.equals(uebung)) return true;
        }
        return false;
    }

    double kalorienverbrauch(int minuten) {
        if (minuten > (getMaxtrainingsdauer() * 60)) {
            //warning();
        }
        return (getKalorienverbrauchproh() / 60) * minuten;
    }

    double kalorienverbrauch (int stunden, int minuten) {
        if (stunden > getMaxtrainingsdauer() || minuten > (getMaxtrainingsdauer() * 60)) {
            //warning();
        }
        return ((getKalorienverbrauchproh() / 60) * minuten) + (getKalorienverbrauchproh() * stunden);
    }

    boolean unterstuetzt(String muskel) {
        return this.muskelliste.contains(muskel);
    }

    boolean unterstuetzt(Muskelgruppe muskelgruppe) {
        return this.muskelgruppe.equals(muskelgruppe);
    }

    boolean benoetigtStromversorgung() {
        return this.getStromversorgung();
    }

    private void warning () {
        System.out.print("Warnung! Maximale Trainigsdauer überschritten: ");
    }

    //getter
    String getGeraetename() {
        return geraetename;
    }

    String getGeraetetyp() {
        return geraetetyp;
    }

    int getMaxtrainingsdauer() {
        return maxtrainingsdauer;
    }

    double getKalorienverbrauchproh() {
        return kalorienverbrauchproh;
    }

    boolean getStromversorgung() {
        return stromversorgung;
    }

    String[] getMoeglicheUebungen() {
        return moeglicheUebungen;
    }

    //setter
    private void setGeraetename(String geraetename) {
        this.geraetename = geraetename;
    }

    private void setGeraetetyp(String geraetetyp) {
        this.geraetetyp = geraetetyp;
    }

    private void setMaxtrainingsdauer(int maxtrainingsdauer) {
        this.maxtrainingsdauer = maxtrainingsdauer;
    }

    private void setKalorienverbrauchproh(int kalorienverbrauch) {
        this.kalorienverbrauchproh = kalorienverbrauch;
    }

    private void setStromversorgung(boolean stromversorgung) {
        this.stromversorgung = stromversorgung;
    }

    private void setMoeglicheUebungen(String[] moeglicheUebungen) {
        this.moeglicheUebungen = moeglicheUebungen;
    }
}
