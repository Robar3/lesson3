package ru.robar3.lesson6;

import java.util.*;

public class ArrayWithoutFour {
    public static void main(String[] args) {
        ArrayWithoutFour arrayWithoutFour = new ArrayWithoutFour();
        int[] arr= {5,7,5,9,7};
        System.out.println(arrayWithoutFour.containOneAndFour(arr));
    }
    public int[] arrAfterLast4(int[] arr) {
        if (arr.length==0) {
            throw new IndexOutOfBoundsException();
        }
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==4){
                index = i+1;
            }
        }
        if (index==0){
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(arr,index,arr.length);
    }
    public boolean containOneAndFour(int[] arr){
        OptionalInt first = Arrays.stream(arr).filter(p -> p == 4).findFirst();
        OptionalInt first2 = Arrays.stream(arr).filter(p -> p == 1).findFirst();
        return first.isPresent() && first2.isPresent();
    }
}