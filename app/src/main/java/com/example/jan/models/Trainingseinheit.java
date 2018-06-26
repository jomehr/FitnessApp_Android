package com.example.jan.models;

import com.example.jan.models.interfaces.Muskelunterstuetzung;

import java.io.Serializable;
import java.util.Date;

public class Trainingseinheit implements Muskelunterstuetzung, Serializable {

    //Attribute
    private int dauer = 0;
    private Date date;
    private Fitnessgeraet fitnessgeraet;

    //Konstruktoren
    public Trainingseinheit(int dauer, Fitnessgeraet fitnessgeraet, Date date) {
        this.fitnessgeraet = fitnessgeraet;
        this.setTrainingsdauerinmin(dauer);
        this.setDate(date);
    }

    Trainingseinheit(Fitnessgeraet fitnessgeraet) {
        this.fitnessgeraet = fitnessgeraet;
    }

    //Methoden
    public String getGeraetname() {
        return fitnessgeraet.getGeraetename();
    }

    public boolean zielErreicht(int kalorienZiel) {
        return getKalorienverbrauch(this.dauer) >= kalorienZiel;
    }

    public double erforderlicheTrainingszeit(int kalorienZiel) {
        return kalorienZiel / (this.fitnessgeraet.getKalorienverbrauchproh() / 60);
    }

    void trainieren() {
        this.dauer++;
    }

    void trainieren(int minuten) {
        this.dauer += minuten;
        //System.out.println("Training: " + minuten);
    }

    public double getKalorienverbrauch(int dauerinmin) {
        return this.fitnessgeraet.kalorienverbrauch(dauerinmin);
    }

    //getter
    public int getTrainingsdauerinmin() {
        return dauer;
    }

    public Date getDate() {
        return date;
    }

    //setter
    private void setTrainingsdauerinmin(int trainingsdauerinmin) {
        this.dauer = trainingsdauerinmin;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean untertuetzt(String muskel) {
        return this.fitnessgeraet.unterstuetzt(muskel);
    }
}

