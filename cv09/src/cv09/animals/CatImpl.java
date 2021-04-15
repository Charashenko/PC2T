package cv09.animals;

public class CatImpl implements Animal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Cat] mnau, age: " + age);
    }

    @Override
    public String toString() {
        return "CatImpl{" +
                "age=" + age +
                '}';
    }
}
