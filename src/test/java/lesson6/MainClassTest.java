package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainClassTest {
    private MainClass mainClass = new MainClass();

    @Test
    void allElementsAfterFour() {
        Assertions.assertArrayEquals(new int[] {1,3,2}, mainClass.allElementsAfterFour(new int[] {0, 4, 1, 3, 2}));
        Assertions.assertArrayEquals(new int[] {}, mainClass.allElementsAfterFour(new int[] {0, 1, 1, 3, 4}));
        Assertions.assertArrayEquals(new int[] {2}, mainClass.allElementsAfterFour(new int[] {0, 4, 1, 3, 4, 2}));
        Assertions.assertThrows(RuntimeException.class, ()-> mainClass.allElementsAfterFour(new int[] {0, 1, 5, 3, 0}));
    }

    @Test
    void chekArrayOnlyOneOrFour() {
        int [] arr1 = {1, 1, 4, 4, 1};
        int [] arr2 = {5, 4, 2, 4, 0};
        int [] arr3 = {4, 4};
        int [] arr4 = {1, 1,1};
        int [] arr5 = {};

        Assertions.assertTrue(mainClass.chekArrayOnlyOneOrFour(arr1));
        Assertions.assertFalse(mainClass.chekArrayOnlyOneOrFour(arr2));
        Assertions.assertFalse(mainClass.chekArrayOnlyOneOrFour(arr3));
        Assertions.assertFalse( mainClass.chekArrayOnlyOneOrFour(arr4));
        Assertions.assertFalse( mainClass.chekArrayOnlyOneOrFour(arr5));

    }
}