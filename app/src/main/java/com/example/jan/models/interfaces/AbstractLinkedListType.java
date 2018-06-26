package com.example.jan.models.interfaces;

public interface AbstractLinkedListType<Trainingseinheit>{

    void add (Trainingseinheit e);

    Trainingseinheit getCurrent();

    Trainingseinheit next();

    Trainingseinheit prev();

    Trainingseinheit get (int offset);

    boolean isEmpty();

    int size();
}
