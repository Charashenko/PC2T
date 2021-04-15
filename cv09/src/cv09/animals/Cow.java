package cv09.animals;

public class Cow extends AbstractAnimal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Cow] muu, age: " + age);
    }

    @Override
    public String toString() {
        return "Cow{" +
                "age=" + age +
                '}';
    }
}
