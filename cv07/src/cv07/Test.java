package cv07;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

    public static int pouzeCelaCisla(Scanner sc) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = pouzeCelaCisla(sc);
        }
        return cislo;
    }


    public static void main(String[] args) throws CustomException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Databaze mojeDatabaze = new Databaze();
        int volba;
        boolean run = true;
        while (run) {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vytvoreni nove databaze");
            System.out.println("2 .. vlozeni noveho studenta");
            System.out.println("3 .. nastaveni prumeru studenta");
            System.out.println("4 .. vypis informace o studentovi");
            System.out.println("5 .. vypis vsetkych studentov");
            System.out.println("6 .. odstran studenta z databazi");
            System.out.println("7 .. ukonceni aplikace");
            volba = pouzeCelaCisla(sc);
            switch (volba) {
                case 1:
                    mojeDatabaze = new Databaze();
                    System.out.println("[Info] Nova databaza bola vytvorena");
                    break;
                case 2:
                    while (true){
                        try {
                            mojeDatabaze.setStudent();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 3:
                    while (true){
                        try {
                            mojeDatabaze.setPrumer();
                            break;
                        } catch (InputMismatchException | CustomException e) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 4:
                    try {
                        if(!mojeDatabaze.getStudent())
                            System.out.println("[Info] Student nebol najdeny");
                    } catch (CustomException e) {
                        System.out.println(e.toString());
                    }
                    break;
                case 5:
                    mojeDatabaze.printNames();
                    break;
                case 6:
                    mojeDatabaze.removeStudent();
                    break;
                case 7:
                    run = false;
                    break;
            }
        }
    }
}
