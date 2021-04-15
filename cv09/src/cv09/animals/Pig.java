package cv09.animals;

public class Pig extends AbstractAnimal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Pig] squeak, age: " + age);
    }

    @Override
    public String toString() {
        return "Pig{" +
                "age=" + age +
                '}';
    }
}
