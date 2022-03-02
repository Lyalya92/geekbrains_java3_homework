package lesson5;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(80, CARS_COUNT/2), new Road(40));
        race.startRace(CARS_COUNT);
    }
}
