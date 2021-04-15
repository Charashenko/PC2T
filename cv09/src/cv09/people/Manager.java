package cv09.people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager<T> extends Employee {

    private List<Employee> listOfEmployees;
    private List<T> listOfRelationships = new ArrayList<>();

    public Manager(String nickname, String email, char[] password, EmployeeType employeeType) {
        super(nickname, email, password, employeeType);
    }


    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public void addEmployee(Employee e){
        listOfEmployees.add(e);
    }

    public void addRelationShip(T e){
        listOfRelationships.add(e);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "\nlistOfEmployees=\n" + listOfEmployees +
                "\nlistOfRelationships=\n" + listOfRelationships +
                '}';
    }
}
