package lesson6;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static int [] allElementsAfterFour (int [] arr) {
        int [] result;
        var position = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                position=i+1;
                if(position == arr.length) {return new int []{};}
                result = new int[arr.length-position];
                System.arraycopy(arr, position, result, 0, arr.length-position);
                return result;
            }
        }
            if (position < 0) {
                throw new RuntimeException("В массиве нет цифры 4!");
            }
        return null;
    }

    public static boolean chekArrayOnlyOneOrFour(int[] arr) {
        boolean oneExists = false;
        boolean fourExists = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
            if (arr[i] == 1) {oneExists = true;}
            if (arr[i] == 4) {fourExists = true;}
        }
        return oneExists && fourExists;
    }


}
