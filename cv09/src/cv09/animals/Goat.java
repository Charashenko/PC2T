package cv09.animals;

public class Goat extends AbstractAnimal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Goat] mee, age: " + age);
    }

    @Override
    public String toString() {
        return "Goat{" +
                "age=" + age +
                '}';
    }
}
