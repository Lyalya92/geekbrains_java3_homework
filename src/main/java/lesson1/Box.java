package lesson1;

import java.util.ArrayList;

public class Box {
    private String fruitType;
    private ArrayList fruits;

    public Box() {
        this.fruitType = null;
        this.fruits = new ArrayList();
    }

    // Добавить фрукт в коробку
    public <T> void addFruit(T fruit) {
        if (fruitType==null) {
            fruitType = fruit.getClass().getSimpleName();
        }
        if(fruitType!=fruit.getClass().getSimpleName()) {
            String message = "This box is only for " + this.fruitType + "!\n";
            System.out.println(message);
        } else {
            fruits.add(fruit);
        }

    }

    // Определить вес коробки
    public Float getBoxWeight(){
        Float sum = 0f;
       for (int i = 0; i <fruits.size(); i++) {
           sum = sum + ((Weightable) fruits.get(i)).getWeight();
       }
         return sum;
        }


    // Сравнить вес двух коробок
    public boolean compareTo (Box anotherBox){
        return Math.abs(this.getBoxWeight() - anotherBox.getBoxWeight()) < 0.00001;
    }


    // Пересыпать фрукты в другую коробку
    public void moveFruitsTo(Box anotherBox) {
        for (int i = 0; i < this.fruits.size(); i++) {
            anotherBox.addFruit(this.fruits.get(i));
        }
        this.fruits.clear();
        this.fruitType = null;
    }
}
