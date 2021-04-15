package Opravene;

import java.util.Scanner;

public class Pole {

    // Konstruktor s velikosti pole
    Pole(int velikost)
    {
        mojeHranoly=new Hranol[velikost];
        sc=new Scanner(System.in);
    }

    // vlozeni hranolu do pole na prvni volnou pozici
    void zadejHranol(){
        boolean drevena=false;
        float delka=0;
        float vyska=0;
        System.out.println("Zadejte delku podstavy hranolu");
        while(!sc.hasNextFloat())
        {
            sc.next();
        }
        delka=sc.nextFloat();
        System.out.println("Zadejte vysku hranolu");
        while(!sc.hasNextFloat())
        {
            sc.next();
        }
        vyska=sc.nextFloat();
        System.out.println("Je drevena?");
        while(!sc.hasNextBoolean())
        {
            sc.next();
        }
        drevena=sc.nextBoolean();
        if (Hranol.getPocetHranolu()==mojeHranoly.length)
        {
            System.out.println("Pole uz je zaplneno");
            return;
        }
        mojeHranoly[Hranol.getPocetHranolu()] = new Hranol(delka, vyska, drevena);
        mojeHranoly[Hranol.getPocetHranolu()-1].setHrana(delka);
        mojeHranoly[Hranol.getPocetHranolu()-1].setHrana(vyska);
        mojeHranoly[Hranol.getPocetHranolu()-1].setDreveny(drevena);
    }

    // vypis objemu vsech hranolu
    void vypoctiObsah()
    {
        for (int i = 0; i< Hranol.getPocetHranolu(); i++)
            System.out.printf("Objem %d. hranolu je %.2f\n", i+1, mojeHranoly[i].vypoctiObjem());
    }

    // vypis obsahu podstavy vsech hranolu
    void vypoctiObsahPodstavy() //nazov vypoctiObsahPodstavy pre vypocet objemu
    {
        for (int i = 0; i< Hranol.getPocetHranolu(); i++)
            System.out.printf("Obsah %d. hranolu je %d\n", i+1, mojeHranoly[i].vypoctiObsah());
    }

    // nalezeni indexu nejmensiho hranolu
    int najdiNejmensiObjem()
    {
        float min=Float.MAX_VALUE;
        int idx=0;
        for (int i = 0; i< Hranol.getPocetHranolu(); i++)
        {
            if (mojeHranoly[i].vypoctiObjem()<min){
                min=mojeHranoly[i].vypoctiObjem();
                idx=i;
            }
        }
        return idx;
    }

    // zjisteni celkoveho poctu drevenych kostek
    int zjistiPocetDrevenych(){
        int pocetDrevenych=0;
        for (int i= 0; i< mojeHranoly.length; i++)
        {
            if (mojeHranoly[i].zeDreva)
                pocetDrevenych++;
        }
        return pocetDrevenych;
    }

    public Hranol[] getMojeHranoly() {
        return mojeHranoly;
    }

    private Scanner sc;
    private Hranol[] mojeHranoly;

}
