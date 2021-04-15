package cv06;                                                                                                                                                                                                   //Author: Štefan Olenočin

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Databaze mojeDatabaze = new Databaze(1);
        int idx;
        float prumer;
        int volba;
        boolean run = true;
        while (run) {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vytvoreni nove databaze");
            System.out.println("2 .. vlozeni noveho studenta");
            System.out.println("3 .. nastaveni prumeru studenta");
            System.out.println("4 .. vypis informace o studentovi");
            System.out.println("5 .. vypis celej databazy");
            System.out.println("6 .. zapis databazy do suboru");
            System.out.println("7 .. citanie databazy zo suboru");
            System.out.println("8 .. ukoncenie aplikacie");
            volba = pouzeCelaCisla(sc);
            switch (volba) {
                case 1:
                    while (true) {
                        try {
                            System.out.println("Zadejte pocet studentu");
                            int velkostDatabazy = pouzeCelaCisla(sc);
                            if (velkostDatabazy > 0) {
                                mojeDatabaze = new Databaze(velkostDatabazy);
                                break;
                            } else
                                throw new Exception("Velkost databazy nemoze byt nulova");
                        } catch (Exception e) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        try {
                            mojeDatabaze.setStudent();
                            break;
                        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                            System.out.println(e.toString());
                            if(e instanceof ArrayIndexOutOfBoundsException)
                                break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        try {
                            System.out.println("Zadejte index a prumer studenta");
                            idx = sc.nextInt();
                            prumer = sc.nextFloat();
                            mojeDatabaze.setPrumer(idx, prumer);
                            break;
                        } catch (InputMismatchException | CustomException | ArrayIndexOutOfBoundsException | NullPointerException e) {
                            System.out.println(e.toString());
                            sc.nextLine();
                            if(e instanceof NullPointerException)
                                break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        try {
                            System.out.println("Zadejte index studenta");
                            idx = pouzeCelaCisla(sc);
                            Student info = mojeDatabaze.getStudent(idx);
                            float priemerStudenta = info.getStudijniPrumer();
                            System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + priemerStudenta);
                            break;
                        } catch (ArrayIndexOutOfBoundsException | CustomException | NullPointerException e) {
                            System.out.println(e.toString());
                            if(!(e instanceof ArrayIndexOutOfBoundsException))
                                break;
                        }
                    }
                    break;
                case 5:
                    printDB(mojeDatabaze);
                    break;
                case 6: {
                    System.out.println("Zadaj nazov suboru kde sa ma ulozit databaza");
                    sc = new Scanner(System.in);
                    String fileName = sc.nextLine();
                    printDBtoFile(mojeDatabaze, fileName);
                    break;
                }
                case 7:
                    System.out.println("Zadaj nazov suboru odkial sa ma nacitat databaza");
                    sc = new Scanner(System.in);
                    String fileName = sc.nextLine();
                    mojeDatabaze = readDBfromFile(fileName);
                    break;
                case 8:
                    run = false;
                    break;
            }

        }
    }

    public static void printDB(Databaze db){
        try {
            for (Student s : db.getPrvkyDatabaze()) {
                double priemer = 0;
                try {
                    priemer = s.getStudijniPrumer();
                } catch (CustomException e) {
                    System.out.println("[Warning] Student " + s.getJmeno() + " este nema zadany priemer. Vypisujem 0");
                } finally {
                    System.out.format("Meno: %s, rok narodenia: %d, studijny priemer: %.2f%n", s.getJmeno(), s.getRocnik(), priemer);
                }
            }
        } catch (NullPointerException e){
            System.out.println("[Warning] Databaza neobsahuje ziadnych studentov");
        }
    }

    public static void printDBtoFile(Databaze db, String fileName){
        try (FileWriter fw = new FileWriter(fileName)){
            for (Student s : db.getPrvkyDatabaze()) {
                double priemer = 0;
                try {
                    priemer = s.getStudijniPrumer();
                } catch (CustomException e) {
                    System.out.println("[Warning] Student " + s.getJmeno() + " este nema zadany priemer. Ukladam 0");
                }
                fw.write(String.format("Meno: %s, rok narodenia: %d, studijny priemer: %.2f%n", s.getJmeno(), s.getRocnik(), priemer));
            }
        } catch (NullPointerException e){
            System.out.println("Databaza neobsahuje ziadnych studentov");
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public static Databaze readDBfromFile(String fileName) {
        try (Scanner sc = new Scanner(new File(fileName))){
            List<String> lines = new ArrayList<>();
            String line;
            while (sc.hasNext()) {
                line = sc.nextLine();
                lines.add(line);
            }
            if(lines.isEmpty()){
                throw new CustomException("[Warning] Databaza neobsahuje ziadne zaznamy");
            }
            Databaze db = new Databaze(lines.size());
            for (String l : lines) {
                Scanner s = new Scanner(l);
                s.useDelimiter("Meno: |, rok narodenia: |, studijny priemer: ");
                String name = s.next();
                int age = s.nextInt();
                float avg = s.nextFloat();
                db.addStudent(new Student(name, age, avg));
            }
            return db;
        } catch (IOException | CustomException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
