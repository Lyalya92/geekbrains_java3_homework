package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private int finishCounter = 0;
    private CyclicBarrier startBarrier;
    private CyclicBarrier finishBarrier;
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void startRace(int carsCount) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        startBarrier = new CyclicBarrier(carsCount, () -> {
            System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        });
        finishBarrier = new CyclicBarrier(carsCount, () -> {
            System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        });
        Car[] cars = new Car[carsCount];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10));

        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

    }

    public synchronized void finishRace(Car car) {
        if (finishCounter==0) {
            System.out.printf("\nПобедитель: %s!\n\n", car.getName());
            finishCounter++;
        }
    }

    public CyclicBarrier getStartBarrier() {
        return startBarrier;
    }

    public CyclicBarrier getFinishBarrier() {
        return finishBarrier;
    }
}
