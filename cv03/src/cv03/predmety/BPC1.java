package cv03.predmety;

import cv03.Predmet;

import java.util.Scanner;

public class BPC1 implements Predmet {

    private int points = 0;
    private static final Scanner input = new Scanner(System.in);

    @Override
    public String getName() {
        return "BPC1";
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public boolean getZapocetStatus() { // ak aktualny pocet bodov z predmetu presahuje minPoints, je uznany zapocet z predmetu
        if (points >= minPoints){
            return true;
        }
        return false;
    }

    public boolean addPointsCvicenie(int points){ // pridanie bodov za cvicenie
        if(points > 20){
            System.out.println("[Error] Pocet bodov presahuje maximum 20 bodov");
            return false;
        }
        this.points += points;
        return true;
    }

    public boolean addPointsSkuska(int points) { // pridanie bodov za skusku
        if(points > 80){
            System.out.println("[Error] Pocet bodov presahuje maximum 80 bodov");
            return false;
        }
        this.points += points;
        return true;
    }


}
