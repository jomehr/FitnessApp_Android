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

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Application app = getApplication();
        final TrainingsApp trainingsApp = (TrainingsApp) app;

        Button button = (Button) findViewById(R.id.main_addProgramButton);
        ListView listView = (ListView) findViewById(R.id.main_listPrograms);

        if (trainingsApp.getListItems() != null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, trainingsApp.getListItems());
            listView.setAdapter(adapter);
        } else {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, trainingsApp.initListItems());
            listView.setAdapter(adapter);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                trainingsApp.setCounter();
                counter = trainingsApp.getCounter();
                Log.d("EXTRANUMBER1", String.valueOf(counter));

                trainingsApp.getListItems().add("Trainingsprogramm " + counter);
                trainingsApp.createProgram(counter);
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Clicked Item Nr.: "+ (i+1), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, TrainingsEinheitActivity.class);
                Log.d("EXTRANUMBER2", String.valueOf(i));

                intent.putExtra("programNumber", i);

                startActivity(intent);
            }
        });
    }
}
