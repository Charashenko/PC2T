package cv09.animals;

public class PigImpl implements Animal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Pig] squeak, age: " + age);
    }

    @Override
    public String toString() {
        return "PigImpl{" +
                "age=" + age +
                '}';
    }
}
