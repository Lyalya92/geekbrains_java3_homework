package lesson1;


public class Apple implements Weightable{
    private Float weight;

    public Apple(Float weight) {
        this.weight = weight;
    }

    @Override
    public Float getWeight() {
        return this.weight;
    }
}

