package com.example.jan.models;

import com.example.jan.models.interfaces.Trainingsziel;

import java.io.Serializable;
import java.util.Date;

public class TrainingseinheitMitZiel extends Trainingseinheit implements Trainingsziel, Serializable {

    private int dauer;
    private int kalorienZiel;
    private Fitnessgeraet fitnessgeraet;

    TrainingseinheitMitZiel(int dauer, int tag, int monat, int jahr,
                            int hh, int mm, Fitnessgeraet fitnessgeraet, int kalorienZiel) {
        super(dauer, fitnessgeraet, new Date(jahr-1900, monat-1, tag, hh, mm));
        this.setKalorienZiel(kalorienZiel);
        this.fitnessgeraet = fitnessgeraet;
    }

    @Override
    void trainieren(int minuten) {
        super.trainieren(minuten);
        if (getKalorienverbrauch(this.getTrainingsdauerinmin()) >= this.kalorienZiel) {
            System.out.println("____________________________________");
            System.out.println("Hurra! Das Ziel der Trainingseinheit wurde erreicht: " +
                    getKalorienverbrauch(this.getTrainingsdauerinmin()));
            System.out.println("Zielerreichungsgrad: " + getZielerreichungsgrad());
        } else {
            System.out.println("____________________________________");
            System.out.println("Das Ziel der Trainingseinheit wurde nicht erreicht: "+
                    getKalorienverbrauch(this.getTrainingsdauerinmin()));
            System.out.println("Zielerreichungsgrad: " + getZielerreichungsgrad());
        }
    }
    //Interface
    @Override
    public void setKalorienZiel(int kalorienZiel) {
        this.kalorienZiel = kalorienZiel;
    }

    @Override
    public int getKalorienZiel() {
        return kalorienZiel;
    }

    @Override
    public double getZielerreichungsgrad() {
        if (getTrainingsdauerinmin() == 0) {
            return getKalorienverbrauch(dauer) / kalorienZiel;
        } else {
            return getKalorienverbrauch(getTrainingsdauerinmin()) / kalorienZiel;
        }
    }

    @Override
    public int getErreichteKalorien() {
      return (int)getKalorienverbrauch(getTrainingsdauerinmin());
    }
}
