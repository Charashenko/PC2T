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


    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
            System.out.println("5 .. ukonceni aplikace");
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
                    run = false;
                    break;
            }

        }
    }

}
