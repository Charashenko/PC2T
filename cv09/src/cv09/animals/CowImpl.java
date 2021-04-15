package cv09.animals;

public class CowImpl implements Animal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Cow] muu, age: " + age);
    }

    @Override
    public String toString() {
        return "CowImpl{" +
                "age=" + age +
                '}';
    }
}
