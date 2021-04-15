package cv09.people;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    private String nickname;
    private String email;
    private char[] password;
    private EmployeeType employeeType;

    public Employee(String nickname, String email, char[] password, EmployeeType employeeType) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.employeeType = employeeType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public void sortEmployees(List<Employee> employeeList){
        System.out.println("\n[Sorted employees]");
        for (Employee e : employeeList.stream().sorted(Comparator.comparing(Employee::getEmail)).collect(Collectors.toList())) {
            System.out.println("[Employee]");
            System.out.println("\t[Nickname] " + e.getNickname());
            System.out.println("\t[Email] " + e.getEmail());
            System.out.println("\t[Password] " + Arrays.toString(e.getPassword()));
            System.out.println("\t[Type] " + e.getEmployeeType());
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\n\tnickname='" + nickname + '\'' +
                ", \n\temail='" + email + '\'' +
                ", \n\tpassword=" + Arrays.toString(password) +
                ", \n\temployeeType=" + employeeType +
                "}\n";
    }
}
