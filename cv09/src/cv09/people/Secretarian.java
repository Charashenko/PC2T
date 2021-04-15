package cv09.people;

public class Secretarian extends Employee {

    private int age;

    public Secretarian(String nickname, String email, char[] password, EmployeeType employeeType, int age) {
        super(nickname, email, password, employeeType);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Secretarian{" +
                "age=" + age +
                "}";
    }
}
