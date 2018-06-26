package com.example.jan.fittnessapp;

import com.example.jan.models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaticData {

    private static final Date date = new Date();

    private static final ArrayList<String> arm = new ArrayList<String>(){
        {
            add("Trizeps");
            add("Brachialis");
            add("Bizeps");
        }
    };
    private static final ArrayList<String> brust = new ArrayList<String>(){
        {
            add("großer Brustmuskel");
            add("kleiner Brustmuskel");
        }
    };
    private static final ArrayList<String> bein = new ArrayList<String>(){
        {
            add("Oberschenkel");
            add("Unterschnenkel");
            add("Wade");
        }
    };
    private static final ArrayList<String> bauch = new ArrayList<String>(){
        {
            add("Gerader Bauchmuskel");
            add("Äußerer schräger Bauchmuskel");
            add("Innerer schräger Bauchmuskel");
        }
    };
    private static final ArrayList<String> schulter = new ArrayList<String>(){
        {
            add("Deltamuskel");
            add("Untergrätenmuskel");
            add("Unterschulterblattmuskel");
        }
    };


    private static final Muskelgruppe muskelgruppe1 = new Muskelgruppe("Arm", arm);
    private static final Muskelgruppe muskelgruppe2 = new Muskelgruppe("Brust", brust);
    private static final Muskelgruppe muskelgruppe3 = new Muskelgruppe("Bein", bein);
    private static final Muskelgruppe muskelgruppe4 = new Muskelgruppe("Bauch", bauch);
    private static final Muskelgruppe muskelgruppe5 = new Muskelgruppe("Schulter", schulter);

    private static final Fitnessgeraet fitnessgeraet1 = new Fitnessgeraet
            ("Rudermaschine", "Krafttraining", 60, 600, muskelgruppe2, false,  new String[]{"Schulterdrücken", "Nackendrücken"});
    private static final Fitnessgeraet fitnessgeraet2 = new Fitnessgeraet
            ("Lastzug", "Krafttraining", 120, 300, muskelgruppe1, false,  new String[]{"Seitheben", "Frontheben"});
    private static final Fitnessgeraet fitnessgeraet3 = new Fitnessgeraet
            ("Laufband", "Cardio", 180, 300, muskelgruppe3, true,  new String[]{"Walking", "Laufen", "Sprint"});
    private static final Fitnessgeraet fitnessgeraet4 = new Fitnessgeraet
            ("Stepper", "Cardio", 210, 100, muskelgruppe3, false,  new String[]{"Steppen", "Springen"});
    private static final Fitnessgeraet fitnessgeraet5 = new Fitnessgeraet
            ("Schulterpresse", "Krafttraining", 60, 400, muskelgruppe5, false,  new String[]{"Stemmen", "Noch mehr stemmen"});
    private static final Fitnessgeraet fitnessgeraet6 = new Fitnessgeraet
            ("Bauchbank", "Krafttraining", 120, 400, muskelgruppe4, false,  new String[]{"Situps", "Einfach liegen bleiben"});
    private static final Fitnessgeraet fitnessgeraet7 = new Fitnessgeraet
            ("Butterfly", "Krafttraining", 60, 500, muskelgruppe5, false,  new String[]{"Zussammendrücken", "Toll fühlen und weg fliegen"});
    private static final Fitnessgeraet fitnessgeraet8 = new Fitnessgeraet
            ("Crosstrainer", "cardio", 120, 700, muskelgruppe3, true,  new String[]{"Strampel", "Härter strampeln", "HHNNNNGGHGH"});
    private static final Fitnessgeraet fitnessgeraet9 = new Fitnessgeraet
            ("Crosswalker", "cardio", 180, 200, muskelgruppe3, true,  new String[]{"Walking", "Angestrengtes sitzen"});
    private static final Fitnessgeraet fitnessgeraet10 = new Fitnessgeraet
            ("Hanteln", "Krafttraining", 240, 100, muskelgruppe1, false,  new String[]{"Lifting", "Drücken", "Ziehen", "Werfen?"});

    public static final Trainingseinheit trainingseinheit1 = new Trainingseinheit(60, fitnessgeraet1, date);
    public static final Trainingseinheit trainingseinheit2 = new Trainingseinheit(120,fitnessgeraet2, date);
    public static final Trainingseinheit trainingseinheit3 = new Trainingseinheit(60, fitnessgeraet3, date);
    public static final Trainingseinheit trainingseinheit4 = new Trainingseinheit(45, fitnessgeraet4, date);
    public static final Trainingseinheit trainingseinheit5 = new Trainingseinheit(30, fitnessgeraet5, date);
    public static final Trainingseinheit trainingseinheit6 = new Trainingseinheit(90, fitnessgeraet6, date);
    public static final Trainingseinheit trainingseinheit7 = new Trainingseinheit(60, fitnessgeraet7, date);
    public static final Trainingseinheit trainingseinheit8 = new Trainingseinheit(90, fitnessgeraet8, date);
    public static final Trainingseinheit trainingseinheit9 = new Trainingseinheit(120, fitnessgeraet9, date);
    public static final Trainingseinheit trainingseinheit10 = new Trainingseinheit(150, fitnessgeraet10, date);

}
