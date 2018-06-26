package com.example.jan.fittnessapp;

import android.app.Application;
import android.util.Log;

import com.example.jan.models.*;

import java.util.ArrayList;
import java.util.Random;

public class TrainingsApp extends Application {

    private int programCounter;
    private ArrayList<String> listItems;
    private ArrayList<TrainingsProgramm> trainingsProgramms;

    public int getProgrammSize() {
        return trainingsProgramms.size();
    }

    public TrainingsProgramm getTrainingsProgramm(int index) {
        if (trainingsProgramms != null) {
            Log.d("INDEX1", String.valueOf(index));
            return trainingsProgramms.get(index);
        } else {
            return null;
        }
    }

    public void addTrainingsProgramm (TrainingsProgramm t) {
        if (trainingsProgramms != null) {
            trainingsProgramms.add(t);
        }else {
            trainingsProgramms = new ArrayList<>();
            trainingsProgramms.add(t);
        }

    }

    public ArrayList<String> getListItems() {
        return listItems;
    }
    public ArrayList<String> initListItems() {
        listItems = new ArrayList<>();
        return listItems;
    }

    public void setCounter() {
        programCounter++;
    }

    public int getCounter() {
        return programCounter;
    }

    public TrainingsProgramm createProgram(int counter) {

        DoublyLinkedListLoop<Trainingseinheit> trainingslist = new DoublyLinkedListLoop<>();
        TrainingsProgramm trainingsProgramm = new TrainingsProgramm
                (counter,2000, trainingslist);

        Random r = new Random();
        for (int i = 1; i <= 3; i++) {
            int ri = r.nextInt(((10-1) + 1)+1);
            switch (ri) {
                case 1:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit1);
                    break;
                case 2:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit2);
                    break;
                case 3:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit3);
                    break;
                case 4:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit4);
                    break;
                case 5:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit5);
                    break;
                case 6:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit6);
                    break;
                case 7:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit7);
                    break;
                case 8:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit8);
                    break;
                case 9:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit9);
                    break;
                case 10:
                    trainingsProgramm.addTrainingseinheit(StaticData.trainingseinheit10);
                    break;
            }
        }
        addTrainingsProgramm(trainingsProgramm);
        return trainingsProgramm;
    }
}
