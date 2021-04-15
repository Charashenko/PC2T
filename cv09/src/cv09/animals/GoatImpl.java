package cv09.animals;

public class GoatImpl implements Animal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Goat] mee, age: " + age);
    }

    @Override
    public String toString() {
        return "GoatImpl{" +
                "age=" + age +
                '}';
    }
}
