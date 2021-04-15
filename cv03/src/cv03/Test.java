package cv03;

import cv03.predmety.BPC1;
import cv03.predmety.BPC2;
import cv03.predmety.BPIS;

import java.util.Scanner;

public class Test {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Predmet[] predmety = new Predmet[3];

        BPC1 bpc1 = new BPC1();
        BPC2 bpc2 = new BPC2();
        BPIS bpis = new BPIS();

        predmety[0] = bpc1;
        predmety[1] = bpc2; // pridanie predmetov do pola
        predmety[2] = bpis;

        do {
            System.out.print("[BPC1] Zadaj body za cvicenie: "); // Zadavanie bodov pokial sa nezada spravna hodnota, cize nepresiahne sa hranica max bodov
        }
        while (!bpc1.addPointsCvicenie(input.nextInt()));

        do {
            System.out.print("[BPC1] Zadaj body za skusku: "); // Zadavanie bodov pokial sa nezada spravna hodnota, cize nepresiahne sa hranica max bodov
        }
        while (!bpc1.addPointsSkuska(input.nextInt()));

        do {
            System.out.print("[BPC2] Zadaj body za projekt: "); // Zadavanie bodov pokial sa nezada spravna hodnota, cize nepresiahne sa hranica max bodov
        }
        while (!bpc2.addPointsProjekt(input.nextInt()));

        do {
            System.out.print("[BPC2] Zadaj body za pol semestralku: "); // Zadavanie bodov pokial sa nezada spravna hodnota, cize nepresiahne sa hranica max bodov
        }
        while (!bpc2.addPointsPolSemestralka(input.nextInt()));

        do {
            System.out.print("[BPC2] Zadaj body za skusku: "); // Zadavanie bodov pokial sa nezada spravna hodnota, cize nepresiahne sa hranica max bodov
        }
        while (!bpc2.addPointsSkuska(input.nextInt()));

        input.nextLine(); // osetrenie enteru
        do {
            System.out.print("[BPIS] Uznat zapocet? (y/n): "); // Zadavanie ci sa uzna zapocet alebo nie, dokedy sa nezada spravna volba y/n
        }
        while (!bpis.giveZapocet(input.nextLine()));

        for (Predmet predmet : predmety) { // vypis predmetov, ich bodov a zapoctov
            System.out.println("\n---- " + predmet.getName() + " ----");
            System.out.println("[Body] " + predmet.getPoints());
            System.out.println("[Zapocet] " + (predmet.getZapocetStatus()?"ano":"nie"));
            System.out.println("--------------");
        }

    }
}
