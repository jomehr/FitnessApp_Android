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

    public static TrainingseinheitMitZiel trainingseinheit1 = new TrainingseinheitMitZiel(60, 26, 06, 2018, 11, 50, fitnessgeraet1, 700);
    public static TrainingseinheitMitZiel trainingseinheit2 = new TrainingseinheitMitZiel(120, 26, 06, 2018, 11, 50, fitnessgeraet2, 500);
    public static TrainingseinheitMitZiel trainingseinheit3 = new TrainingseinheitMitZiel(60, 26, 06, 2018, 11, 50, fitnessgeraet3, 1000);
    public static TrainingseinheitMitZiel trainingseinheit4 = new TrainingseinheitMitZiel(45, 26, 06, 2018, 11, 50, fitnessgeraet4, 600);
    public static TrainingseinheitMitZiel trainingseinheit5 = new TrainingseinheitMitZiel(30, 26, 06, 2018, 11, 50, fitnessgeraet5, 500);
    public static TrainingseinheitMitZiel trainingseinheit6 = new TrainingseinheitMitZiel(90, 26, 06, 2018, 11, 50, fitnessgeraet6, 800);
    public static TrainingseinheitMitZiel trainingseinheit7 = new TrainingseinheitMitZiel(60, 26, 06, 2018, 11, 50,fitnessgeraet7, 800);
    public static TrainingseinheitMitZiel trainingseinheit8 = new TrainingseinheitMitZiel(90, 26, 06, 2018, 11, 50,fitnessgeraet8, 2000);
    public static TrainingseinheitMitZiel trainingseinheit9 = new TrainingseinheitMitZiel(120, 26, 06, 2018, 11, 50, fitnessgeraet9, 1000);
    public static TrainingseinheitMitZiel trainingseinheit10 = new TrainingseinheitMitZiel(150, 26, 06, 2018, 11, 50, fitnessgeraet10, 1400);

}
