package cv03.predmety;

import cv03.Predmet;

public class BPIS implements Predmet {

    private int points = 0;
    private boolean zapocet = false;

    @Override
    public String getName() {
        return "BPIS";
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public boolean getZapocetStatus() {
        return this.zapocet;
    }

    public boolean giveZapocet(String choice){ // uznanie zapoctu
        if(choice.equalsIgnoreCase("y")) {
            this.zapocet = true;
            return true;
        } else if (choice.equalsIgnoreCase("n"))
            return true;
        else{
            System.out.println("[Error] Nespravna volba");
            return false;
        }

    }
}
