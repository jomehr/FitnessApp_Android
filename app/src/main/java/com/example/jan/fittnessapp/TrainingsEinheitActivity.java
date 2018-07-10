package com.example.jan.fittnessapp;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.jan.models.TrainingsProgramm;
import com.example.jan.models.Trainingseinheit;
import com.example.jan.models.TrainingseinheitMitZiel;

public class TrainingsEinheitActivity extends AppCompatActivity {

    TextView title, machine, time;
    EditText calories;
    Button prev, next;
    SeekBar seekBar;

    private TrainingsProgramm trainingsProgramm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings_einheit);

        Application app = getApplication();
        TrainingsApp trainingsApp = (TrainingsApp) app;

        title = findViewById(R.id.detail_programTitle);
        machine = findViewById(R.id.detail_machine);
        time = findViewById(R.id.detail_minutes);
        calories = findViewById(R.id.detail_calories);
        prev = findViewById(R.id.detail_buttonBack);
        next = findViewById(R.id.detail_buttonForward);
        seekBar = findViewById(R.id.detail_seekbar);

        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setDisplayShowHomeEnabled(true);
        }

        int extra = getIntent().getIntExtra("programNumber", 0);
        Log.d("EXTRANUMBER3", String.valueOf(extra));

        trainingsProgramm = trainingsApp.getTrainingsProgramm(extra);

        int timetmp = trainingsProgramm.getTrainingseinheit().getTrainingsdauerinmin();

        if (trainingsProgramm.getTrainingseinheit() instanceof TrainingseinheitMitZiel) {
            seekBar.setVisibility(View.VISIBLE);
            seekBar.setMax(((TrainingseinheitMitZiel) trainingsProgramm.getTrainingseinheit()).getKalorienZiel());
            if (((TrainingseinheitMitZiel) trainingsProgramm.getTrainingseinheit()).getEditedKalorien() != 0) {
                seekBar.setProgress((int)((TrainingseinheitMitZiel) trainingsProgramm.getTrainingseinheit()).getEditedKalorien());
                calories.setText(String.valueOf(((TrainingseinheitMitZiel) trainingsProgramm.getTrainingseinheit()).getEditedKalorien()));
            }else {
                seekBar.setProgress((int)((TrainingseinheitMitZiel) trainingsProgramm.getTrainingseinheit()).getKalorienverbrauch((trainingsProgramm.getTrainingseinheit().getTrainingsdauerinmin())));
                calories.setText(String.valueOf(trainingsProgramm.getTrainingseinheit().getKalorienverbrauch(timetmp)));
            }
        }else {
            seekBar.setVisibility(View.INVISIBLE);
            calories.setText(String.valueOf(trainingsProgramm.getTrainingseinheit().getKalorienverbrauch(timetmp)));
        }

        String titeltmp = "Trainingsprogramm "+ trainingsProgramm.getCounter();
        title.setText(titeltmp);
        machine.setText(trainingsProgramm.getTrainingseinheit().getGeraetname());
        time.setText(String.valueOf(timetmp));


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trainingseinheit trainingseinheit = trainingsProgramm.prev();
                int timetmp = trainingsProgramm.getTrainingseinheit().getTrainingsdauerinmin();

                if (trainingseinheit instanceof TrainingseinheitMitZiel) {
                    seekBar.setVisibility(View.VISIBLE);
                    seekBar.setMax((((TrainingseinheitMitZiel) trainingseinheit).getKalorienZiel()));
                    if (((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien() != 0) {
                        Log.d("EDITED", "true" + ((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien());
                        seekBar.setProgress((int)((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien());
                        calories.setText(String.valueOf(((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien()));
                    }else {
                        Log.d("EDITED", "false" + ((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien());
                        seekBar.setProgress((int)((TrainingseinheitMitZiel) trainingseinheit).getKalorienverbrauch((trainingseinheit.getTrainingsdauerinmin())));
                        calories.setText(String.valueOf(trainingseinheit.getKalorienverbrauch(timetmp)));
                    }
                }else {
                    seekBar.setVisibility(View.INVISIBLE);
                }

                machine.setText(trainingseinheit.getGeraetname());
                time.setText(String.valueOf(timetmp));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trainingseinheit trainingseinheit = trainingsProgramm.next();
                int timetmp = trainingseinheit.getTrainingsdauerinmin();
                if (trainingseinheit instanceof TrainingseinheitMitZiel) {
                    seekBar.setVisibility(View.VISIBLE);
                    seekBar.setMax(((TrainingseinheitMitZiel) trainingseinheit).getKalorienZiel());
                    if (((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien() != 0) {
                        Log.d("EDITED", "true" + ((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien());
                        seekBar.setProgress((int)((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien());
                        calories.setText(String.valueOf(((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien()));
                    }else {
                        Log.d("EDITED", "false" + ((TrainingseinheitMitZiel) trainingseinheit).getEditedKalorien());
                        seekBar.setProgress((int)((TrainingseinheitMitZiel) trainingseinheit).getKalorienverbrauch((trainingseinheit.getTrainingsdauerinmin())));
                        calories.setText(String.valueOf(trainingseinheit.getKalorienverbrauch(timetmp)));
                    }
                } else {
                    seekBar.setVisibility(View.INVISIBLE);
                }

                machine.setText(trainingseinheit.getGeraetname());
                time.setText(String.valueOf(timetmp));
            }
        });

        calories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calories.addTextChangedListener(textWatcher);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                calories.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Trainingseinheit trainingseinheit = trainingsProgramm.getTrainingseinheit();
                ((TrainingseinheitMitZiel) trainingseinheit).setEditedKalorien(seekBar.getProgress());
            }
        });
    }

    TextWatcher textWatcher=new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s == "") s = "0";

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            Trainingseinheit trainingseinheit = trainingsProgramm.getTrainingseinheit();
            ((TrainingseinheitMitZiel) trainingseinheit).setEditedKalorien(Double.valueOf(s.toString()));
            double value = Double.valueOf(s.toString());
            seekBar.setProgress((int) value);
        }
    };
}
