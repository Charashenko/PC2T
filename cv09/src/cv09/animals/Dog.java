package cv09.animals;

public class Dog extends AbstractAnimal {

    private byte age;

    @Override
    public void sound(byte age) {
        this.age = age;
        System.out.println("[Dog] haf, age: " + age);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}
