package com.example.jan.fittnessapp;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jan.models.CustomAdapter;
import com.example.jan.models.TrainingsProgramm;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Application app = getApplication();
        final TrainingsApp trainingsApp = (TrainingsApp) app;

        Button addProgramButton = findViewById(R.id.main_addProgramButton);
        Button deleteButton = findViewById(R.id.main_deleteButton);
        ListView listView = findViewById(R.id.main_listPrograms);

            adapter = new CustomAdapter(this, trainingsApp.getTrainingsProgramms());
            listView.setAdapter(adapter);

        addProgramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                trainingsApp.setCounter();
                counter = trainingsApp.getCounter();
                Log.d("EXTRANUMBER1", String.valueOf(counter));

                //trainingsApp.getListItems().add("Trainingsprogramm " + counter);
                trainingsApp.createProgram(counter);
                adapter.notifyDataSetChanged();
            }
        });

        adapter.setOnProgramClickedListener(new CustomAdapter.OnProgramClickedListener() {
            @Override
            public void onProgramClicked(TrainingsProgramm programm, int i) {
                Toast.makeText(MainActivity.this, "Clicked Item Nr.: "+ (i+1), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, TrainingsEinheitActivity.class);
                Log.d("EXTRANUMBER2", String.valueOf(i));

                intent.putExtra("programNumber", i);

                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<TrainingsProgramm> list = adapter.getProgrammsToDelete();
                adapter.getProgramms().removeAll(list);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
