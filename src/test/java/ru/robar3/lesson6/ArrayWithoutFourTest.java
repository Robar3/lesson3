package ru.robar3.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayWithoutFourTest {

    ArrayWithoutFour arrayWithoutFour = new ArrayWithoutFour();
    private static Stream<Arguments> provideArgs(){
        return Stream.of(
                Arguments.of(new int[]{5, 2, 4, 23, 6, 1, 2, 4, 2, 5, 6}, new int[]{2, 5, 6}),
                Arguments.of(new int[]{3,5,3,4,6,5,7,3}, new int[]{6,5,7,3}),
                Arguments.of(new int[]{4,3,2,4}, new int[]{}),
                Arguments.of(new int[]{1,4,5,7,5,4,6,6,5,4,6,7,8,5}, new int[]{6,7,8,5})
        );
    }
    private static Stream<Arguments> provideArgs2(){
        return Stream.of(
                Arguments.of(new int[]{5, 2, 4, 23, 6, 1, 2, 4, 2, 5, 6}),
                Arguments.of(new int[]{3,5,3,4,6,1,5,7,3}),
                Arguments.of(new int[]{4,3,2,1,4}),
                Arguments.of(new int[]{1,4,5,7,5,4,6,6,5,4,6,7,8,5})
        );
    }
    int[] arr= {5,7,5,9,7};
    int[]arr1 = {};
    @ParameterizedTest
    @MethodSource("provideArgs")
    public void testArrWithoutFour(int[] arr,int[] res){
        int[] ints = arrayWithoutFour.arrAfterLast4(arr);
        Assertions.assertArrayEquals(res,ints);
    }

    @Test
    public void testArrWithoutFourNoFour(){

        Assertions.assertThrows(RuntimeException.class, ()->arrayWithoutFour.arrAfterLast4(arr));
    }
    @Test
    public void testArrWithoutFourEmptyArr(){
        Assertions.assertThrows(RuntimeException.class, ()->arrayWithoutFour.arrAfterLast4(arr1));
    }

    @ParameterizedTest
    @MethodSource("provideArgs2")
    public void testContainOneAndFour(int[] arr){
        Assertions.assertTrue(arrayWithoutFour.containOneAndFour(arr));
    }

    @Test
    public void testContainOneAndFourFalse(){
        Assertions.assertFalse(arrayWithoutFour.containOneAndFour(arr));
    }
    @Test
    public void testContainOneAndFourNullArr(){
        Assertions.assertFalse(arrayWithoutFour.containOneAndFour(arr1));
    }
}