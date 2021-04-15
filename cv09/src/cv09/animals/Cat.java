package cv09.animals;

public class Cat extends AbstractAnimal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Cat] mnau, age: " + age);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }
}
