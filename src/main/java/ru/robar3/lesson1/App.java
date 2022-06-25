package ru.robar3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        App app = new App();
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Integer[] arr={1,2,3,4,5};
        System.out.println(Arrays.toString(arr)+" первоначальный массив");

        app.arrayTransfer(arr,0,3);
        System.out.println(Arrays.toString(arr)+" измененный массив");
        ArrayList<Integer> integers = app.arrayToList(arr);
        System.out.println(integers+" лист");

        for (int i = 0; i < 5; i++) {
            appleBox1.addFruit(new Apple());
            appleBox2.addFruit(new Apple());
        }
        for (int i = 0; i < 5; i++) {
            orangeBox.addFruit(new Orange());
            orangeBox1.addFruit(new Orange());
        }
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox1.compare(appleBox2));
        appleBox1.shiftFruit(appleBox2);
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox.compare(appleBox1));
        orangeBox.shiftFruit(orangeBox1);
        System.out.println(orangeBox1.getWeight());
    }

   public <T> T[] arrayTransfer(T[] arr,int index1,int index2){
       T firstElem = arr[index1];
       arr[index1]=arr[index2];
       arr[index2]=firstElem;
       return arr;
   }

   public <T> ArrayList<T> arrayToList(T[] arr){
       return new ArrayList<>(Arrays.asList(arr));
   }

}
