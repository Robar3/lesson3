package ru.robar3.lesson1;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private ArrayList<T> list=new ArrayList<>();


    public void addFruit(T fruit){
        list.add(fruit);
    }
    public double getWeight(){

        if (!list.isEmpty()){
            return list.size()* list.get(0).getWeight();
        }else {
          return 0;
        }

    }

    public boolean compare(Box box) {

        return this.getWeight() == box.getWeight();
    }

    public void shiftFruit(Box box){
        for (T fruit: list ) {
            box.addFruit(fruit);
        }
        list.clear();
    }


}
