package com.example.jan.models;

import com.example.jan.models.interfaces.AbstractLinkedListType;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class DoublyLinkedListLoop<Trainingseinheit> implements AbstractLinkedListType<Trainingseinheit>, Serializable {

    private Node currentNode;
    private Node firstNode;
    private int currentSize;

    private class Node {
        Trainingseinheit trainingseinheit;
        Node next;
        Node prev;

        private Node (Trainingseinheit trainingseinheit , Node next, Node prev) {
            this.trainingseinheit = trainingseinheit;
            this.next = next;
            this.prev = prev;
        }

    }

    public void replaceCurrent (Trainingseinheit t) {
        currentNode.trainingseinheit = t;
    }

    public void removeTraining(Trainingseinheit t) {
        Node runPointer = currentNode;

        if (isEmpty()) throw new NoSuchElementException();

        for (int i = 0 ; i < currentSize ; i++) {
            if (runPointer.trainingseinheit == t) {
                if (currentNode == runPointer) {
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;

                    currentNode = currentNode.prev;

                    currentSize--;
                }else {
                    runPointer.prev.next = runPointer.next;
                    runPointer.next.prev = runPointer.prev;
                    currentSize--;
                }
            }else {
                runPointer = runPointer.next;
            }
        }
    }

    public void removeCurrent () {
        if (isEmpty()) throw new NoSuchElementException();

        if (currentSize == 1){
            currentNode.next = null;
            currentNode.prev = null;
            currentNode = null;

            currentSize--;
        }else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;

            currentNode = currentNode.prev;

            currentSize --;
        }
    }

    @Override
    public void add(Trainingseinheit e) {

        if (isEmpty()){
            firstNode = new Node(e, null, null);
            firstNode.prev = firstNode;
            firstNode.next = firstNode;

            currentNode = firstNode;
        } else {
            Node newNode = new Node(e, currentNode.next, currentNode);
            currentNode.next.prev = newNode;
            currentNode.next = newNode;

            currentNode = newNode;
        }
        currentSize++;
    }

    @Override
    public Trainingseinheit getCurrent() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return currentNode.trainingseinheit;
    }

    @Override
    public Trainingseinheit next() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        currentNode = currentNode.next;
        return currentNode.trainingseinheit;
    }

    @Override
    public Trainingseinheit prev() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        currentNode = currentNode.prev;
        return currentNode.trainingseinheit;
    }

    @Override
    public Trainingseinheit get(int offset) {
        Node runPointer = currentNode;

        if (offset < 0 || isEmpty()) throw new NoSuchElementException();

        for (int i = 0 ; i < offset ; i++) {
            runPointer = runPointer.next;
        }

        return runPointer.trainingseinheit ;
    }

    @Override
    public boolean isEmpty() {
        return currentNode == null;
    }

    @Override
    public int size() {
        return currentSize;
    }

}
