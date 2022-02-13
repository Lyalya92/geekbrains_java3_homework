package lesson1;

import java.util.ArrayList;
import java.util.List;

public class HomeworkLesson1 {

    public static void main(String[] args){
        //    1. Написать метод, который меняет два элемента массива местами.
        //    (массив может быть любого ссылочного типа);
        Integer [] intArray = {1,2,3,4,5};
        String [] strArray = {"Tomato", "Potato", "Onion"};

        swapTwoElements(intArray, 1,2);
        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("%d ", intArray[i]);
        }
        System.out.println();


        swapTwoElements(strArray,2,0);
        for (int i = 0; i < strArray.length; i++) {
            System.out.printf("%s ", strArray[i]);
        }
        System.out.println();

//        2. Написать метод, который преобразует массив в ArrayList;
        Integer [] arr = {45, 32, 1, 4, 10};
        System.out.println(arrayToList(strArray));
        System.out.println(arrayToList(intArray));

//        3. Задание с фруктами
        Apple apples [] = {
                new Apple(1.0f),
                new Apple(0.8f),
                new Apple(1.2f),
                new Apple(0.6f)
        };

        Orange oranges [] = {
                new Orange(1.5f),
                new Orange(1.7f),
                new Orange(1.3f)
        };

        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        Box box4 = new Box();

        for (Apple apple: apples) {
            box1.addFruit(apple);
        }

        for (Orange orange: oranges) {
            box2.addFruit(orange);
        }
            box3.addFruit(oranges[2]);
            box3.addFruit(apples[1]);
            box3.addFruit(oranges[0]);

            box3.moveFruitsTo(box4);

        System.out.println("Box1. Weight: " + box1.getBoxWeight());
        System.out.println("Box2. Weight: " + box2.getBoxWeight());
        System.out.println("Boxes have some weight: " + box1.compareTo(box2));

        box1.addFruit(new Apple(0.9f));
        System.out.println("Boxes have some weight: " + box1.compareTo(box2));
    }


    public static <T> void swapTwoElements(T[] array, int index1, int index2) {
     T temp;
     temp = array[index1];
     array[index1] = array[index2];
     array[index2] = temp;
    }

    public static <V> ArrayList arrayToList(V[] array){
        ArrayList<V> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return  list;
    }

}
