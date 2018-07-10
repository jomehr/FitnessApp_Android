package com.example.jan.models;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.jan.fittnessapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi1920 on 26.06.2018.
 */

public class CustomAdapter extends ArrayAdapter<TrainingsProgramm> {

    private List<TrainingsProgramm> programms;
    private List<TrainingsProgramm> programmsToDelete;

    public interface OnProgramClickedListener{
        void onProgramClicked(TrainingsProgramm programm, int index);
    }

    private OnProgramClickedListener onProgramClickedListener;

    public OnProgramClickedListener getOnProgramClickedListener() {
        return onProgramClickedListener;
    }

    public void setOnProgramClickedListener(OnProgramClickedListener onProgramClickedListener) {
        this.onProgramClickedListener = onProgramClickedListener;
    }

    public CustomAdapter(@NonNull Context context, @NonNull List<TrainingsProgramm> objects) {
        super(context, 0, objects);
        this.programms = objects;
        this.programmsToDelete = new ArrayList<>();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
        TrainingsProgramm programm = programms.get(position);
        //Füllen mit Daten

        CheckBox checkBox = listItem.findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new DeleteCheckboxListener(programm));

        TextView textView = listItem.findViewById(R.id.list_item);
        textView.setOnClickListener(new ProjectClickedListener(programm, position));

        textView.setText("Trainingsprogramm" + position);

        ProgressBar progressBar = listItem.findViewById(R.id.list_progressbar);
        progressBar.setMax(((TrainingseinheitMitZiel) programm.getTrainingseinheit()).getKalorienZiel());
        progressBar.setProgress((int)((TrainingseinheitMitZiel) programm.getTrainingseinheit()).getKalorienverbrauch(programm.getTrainingseinheit().getTrainingsdauerinmin()));

        return listItem;
    }

    private class ProjectClickedListener implements View.OnClickListener {

        private TrainingsProgramm programm;
        private int position;

        ProjectClickedListener(TrainingsProgramm programm, int position) {
            this.programm = programm;
            this.position = position;
        }


        @Override
        public void onClick(View v) {
            if(onProgramClickedListener != null)
                onProgramClickedListener.onProgramClicked(programm, position);
        }
    }

    private class DeleteCheckboxListener implements CompoundButton.OnCheckedChangeListener {

        private TrainingsProgramm trainingsProgramm;

        DeleteCheckboxListener(TrainingsProgramm trainingsProgramm) {
            this.trainingsProgramm = trainingsProgramm;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                Log.d("TODELETE", trainingsProgramm.toString());
                programmsToDelete.add(trainingsProgramm);
            } else {
                Log.d("TONOTDELETE", trainingsProgramm.toString());
                programmsToDelete.remove(trainingsProgramm);
            }
        }
    }

    public List<TrainingsProgramm> getProgrammsToDelete() {
        return programmsToDelete;
    }

    public List<TrainingsProgramm> getProgramms() {
        return programms;
    }
}
