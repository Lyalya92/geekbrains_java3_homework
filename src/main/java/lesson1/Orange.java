package lesson1;

public class Orange implements Weightable{
    private Float weight;

    public Orange(Float weight) {
        this.weight = weight;
    }

    @Override
    public Float getWeight() {
        return this.weight;
    }
}
