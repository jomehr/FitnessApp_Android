package com.example.jan.fittnessapp;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jan.models.TrainingsProgramm;
import com.example.jan.models.Trainingseinheit;
import com.example.jan.models.TrainingseinheitMitZiel;

public class TrainingsEinheitActivity extends AppCompatActivity {

    TextView title, machine, time, calories;
    Button prev, next;
    ProgressBar progressBar;

    private TrainingsProgramm trainingsProgramm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings_einheit);

        Application app = getApplication();
        final TrainingsApp trainingsApp = (TrainingsApp) app;

        title = findViewById(R.id.detail_programTitle);
        machine = findViewById(R.id.detail_machine);
        time = findViewById(R.id.detail_minutes);
        calories = findViewById(R.id.detail_calories);
        prev = findViewById(R.id.detail_buttonBack);
        next = findViewById(R.id.detail_buttonForward);
        progressBar = findViewById(R.id.detail_progressBar);

        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setDisplayShowHomeEnabled(true);
        }

        int extra = getIntent().getIntExtra("programNumber", 0);
        Log.d("EXTRANUMBER3", String.valueOf(extra));

        trainingsProgramm = trainingsApp.getTrainingsProgramm(extra);

        if (trainingsProgramm.getTrainingseinheit() instanceof TrainingseinheitMitZiel) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setMax(((TrainingseinheitMitZiel) trainingsProgramm.getTrainingseinheit()).getKalorienZiel());
            progressBar.setProgress((int)((TrainingseinheitMitZiel) trainingsProgramm.getTrainingseinheit()).getKalorienverbrauch((trainingsProgramm.getTrainingseinheit().getTrainingsdauerinmin())));
        }else {
            progressBar.setVisibility(View.INVISIBLE);
        }

        String titeltmp = "Trainingsprogramm "+ trainingsProgramm.getCounter();
        title.setText(titeltmp);
        machine.setText(trainingsProgramm.getTrainingseinheit().getGeraetname());
        int timetmp = trainingsProgramm.getTrainingseinheit().getTrainingsdauerinmin();
        time.setText(String.valueOf(timetmp));
        calories.setText(String.valueOf(trainingsProgramm.getTrainingseinheit().getKalorienverbrauch(timetmp)));

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trainingseinheit trainingseinheit = trainingsProgramm.prev();

                if (trainingseinheit instanceof TrainingseinheitMitZiel) {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setMax((((TrainingseinheitMitZiel) trainingseinheit).getKalorienZiel()));
                    progressBar.setProgress((int)(trainingseinheit.getKalorienverbrauch((trainingsProgramm.getTrainingseinheit().getTrainingsdauerinmin()))));
                }else {
                    progressBar.setVisibility(View.INVISIBLE);
                }

                machine.setText(trainingseinheit.getGeraetname());
                int timetmp = trainingseinheit.getTrainingsdauerinmin();
                time.setText(String.valueOf(timetmp));
                calories.setText(String.valueOf(trainingseinheit.getKalorienverbrauch(timetmp)));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trainingseinheit trainingseinheit = trainingsProgramm.next();

                if (trainingseinheit instanceof TrainingseinheitMitZiel) {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setMax((((TrainingseinheitMitZiel) trainingseinheit).getKalorienZiel()));
                    progressBar.setProgress((int)(trainingseinheit.getKalorienverbrauch((trainingsProgramm.getTrainingseinheit().getTrainingsdauerinmin()))));
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                }

                machine.setText(trainingseinheit.getGeraetname());
                int timetmp = trainingseinheit.getTrainingsdauerinmin();
                time.setText(String.valueOf(timetmp));
                calories.setText(String.valueOf(trainingseinheit.getKalorienverbrauch(timetmp)));
            }
        });
    }
}
