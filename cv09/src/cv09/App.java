package cv09;                                                                                                                                                                                                                                                                                                                       //211211

import cv09.animals.*;
import cv09.people.Employee;
import cv09.people.EmployeeType;
import cv09.people.Manager;
import cv09.people.Secretarian;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Abstratktnú triedu používame ak nepotrebujeme použiť viacero "templateov". Taktiež môžeme abstraktnú triedu použiť ak chceme využiť niektoré prvky normálnej triedy, ako napr. končtruktor, nie abstraktné metody...
 * Interface je naopak jednoduchší a trieda môže pracovať s nekočným počtom interfacov.
 * Pretože výčtový typ z hladiska použitelnosti je lepší ako samostatné definovanie konštánt. Je prehľadnejší a jednoduchšie sa s ním pracuje
 * @author Stefan Olenocin
 */
public class App {

    public static void main(String[] args) {
	    Employee e1 = new Employee("First employee", "1e@mail.com", "abc".toCharArray(), EmployeeType.ACTIVE);
        Employee e2 = new Employee("Second employee", "2e@mail.com", "def".toCharArray(), EmployeeType.INACTIVE);
        Employee e3 = new Employee("Third employee", "3e@mail.com", "ghi".toCharArray(), EmployeeType.DELETED);
        Employee e4 = new Employee("Fourth employee", "4e@mail.com", "jkl".toCharArray(), EmployeeType.INACTIVE);
        Employee e5 = new Employee("Fifth employee", "5e@mail.com", "mno".toCharArray(), EmployeeType.ACTIVE);
        Manager<Employee> m = new Manager("Main manager", "mm@mail.com", "pqr".toCharArray(), EmployeeType.ACTIVE);
        Secretarian s1 = new Secretarian("First secretarian", "1s@mail.com", "stu".toCharArray(), EmployeeType.ACTIVE, 25);
        Secretarian s2 = new Secretarian("Second secretarian", "2s@mail.com", "vwx".toCharArray(), EmployeeType.INACTIVE, 34);

        m.setListOfEmployees(List.of(e5, e4, e3, e2, e1));
        m.addRelationShip(s1);
        System.out.println(m.toString());
        m.sortEmployees(List.of(e1, e2, e3, e4, e5));

        List<AbstractAnimal> abstractAnimals = new ArrayList<>();
        abstractAnimals.add(new Cat());
        abstractAnimals.add(new Dog());
        abstractAnimals.add(new Pig());
        abstractAnimals.add(new Cow());
        abstractAnimals.add(new Goat());
        System.out.println("\nAbstract animals");
        for (AbstractAnimal a : abstractAnimals) {
            a.sound((byte) 5);
        }

        List<Animal> implAnimals = new ArrayList<>();
        implAnimals.add(new CatImpl());
        implAnimals.add(new DogImpl());
        implAnimals.add(new PigImpl());
        implAnimals.add(new CowImpl());
        implAnimals.add(new GoatImpl());
        System.out.println("\nInterface animals");
        for (Animal a : implAnimals) {
            a.sound((byte) 5);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("[Choice] Save implAnimals to file?");
        System.out.println("\t[0] Yes");
        System.out.println("\t[1] No");
        try {
            int choice = sc.nextInt();
            while (choice != 0 && choice != 1) {
                System.out.println("[Info] wrong choices");
                choice = sc.nextInt();
            }
            if(choice == 0){
                saveToFile(implAnimals);
            } else {
                System.out.println("Didn't save to file");
            }
        } catch (InputMismatchException e){
            System.out.println("[Info] NaN, exiting app");
        }

    }

    public static void saveToFile(List<Animal> list){
        try(FileWriter fw = new FileWriter("animals.txt")) {
            for (Animal a : list) {
                fw.write(a.toString() + "\n");
            }
            System.out.println("Saved to file");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
