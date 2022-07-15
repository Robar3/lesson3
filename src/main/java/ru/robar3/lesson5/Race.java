package ru.robar3.lesson5;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    Car winner=null;
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
    public synchronized void setWinner(Car winner){
        if (this.winner==null){
            System.out.println("# # # Победил "+winner.getName());
            this.winner=winner;
        }
    }
}