package com.example.jan.models;

import com.example.jan.models.interfaces.Muskelunterstuetzung;
import com.example.jan.models.interfaces.Trainingsziel;

import java.io.Serializable;
import java.util.ArrayList;

public class TrainingsProgramm implements Trainingsziel, Muskelunterstuetzung, Serializable {

    //Attribute
    private DoublyLinkedListLoop<Trainingseinheit> trainingsprogramm;
    private int kalorienZiel;
    private double tmp = 0;
    private int counter = 0;

    public TrainingsProgramm(int counter, int kalorienZiel, DoublyLinkedListLoop<Trainingseinheit> trainingsprogramm) {
        this.counter = counter;
        this.setKalorienZiel(kalorienZiel);
        this.trainingsprogramm = trainingsprogramm;
    }

    //Methoden
    public void addTrainingseinheit (Trainingseinheit trainingseinheit) {
        trainingsprogramm.add(trainingseinheit);
    }

    public Trainingseinheit getTrainingseinheit () {
        return trainingsprogramm.getCurrent();
    }

    public Trainingseinheit next () {
        return trainingsprogramm.next();
    }

    public Trainingseinheit prev () {
        return trainingsprogramm.prev();
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

    //Gibt Mittelwert der Zielerreichung aller Trainingseinheitem aus
    @Override
    public double getZielerreichungsgrad() {
        /*for (Trainingseinheit object: trainingsprogramm) {
            //System.out.println(object.getKalorienverbrauch(object.getTrainingsdauerinmin()));
            tmp += object.getKalorienverbrauch(object.getTrainingsdauerinmin());
        }*/
        for (int i = 0 ; i < trainingsprogramm.size() ; i++) {
            //System.out.println(object.getKalorienverbrauch(object.getTrainingsdauerinmin()));
            tmp += trainingsprogramm.get(i).getKalorienverbrauch
                    (trainingsprogramm.get(i).getTrainingsdauerinmin());
            System.out.println(trainingsprogramm.get(i).getTrainingsdauerinmin());
        }

        double erreichungsgrad = tmp / this.kalorienZiel;
        if (erreichungsgrad>=1) {
            System.out.println("____________________________________");
            System.out.println("Hurra! Das Ziel des Trainingsprogramms wurde erreicht: "+ erreichungsgrad*100 + "%");
        } else {
            System.out.println("____________________________________");
            System.out.println("Das Ziel des Trainingsprogramms wurde nicht erreicht: " + erreichungsgrad*100 + "%");
        }
        return erreichungsgrad;
    }

    @Override
    public int getErreichteKalorien() {
        int tmp = 0;
        for (int i = 0 ; i < trainingsprogramm.size() ; i++) {
            //System.out.println(object.getKalorienverbrauch(object.getTrainingsdauerinmin()));
            tmp += trainingsprogramm.get(i).getKalorienverbrauch(trainingsprogramm.get(i).getTrainingsdauerinmin());
        }
        return tmp;
    }

    @Override
    public boolean untertuetzt(String muskel) {
        for (int i = 0 ; i < trainingsprogramm.size() ; i++)  {
            if (trainingsprogramm.get(i).untertuetzt(muskel)) return true;
        }
            return false;
    }

    public int size() {
        return trainingsprogramm.size();
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
