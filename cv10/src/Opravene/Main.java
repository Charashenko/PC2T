package Opravene;

public class Main {

    public static void main(String[] args) {
        Pole pole = new Pole(2);
        pole.zadejHranol();
        pole.zadejHranol();
        pole.vypoctiObsah();
        pole.vypoctiObsahPodstavy();
        System.out.println("Najmensi objem: " + pole.getMojeHranoly()[pole.najdiNejmensiObjem()].vypoctiObjem() +
                " ma hranol s indexom: " + pole.najdiNejmensiObjem());
        System.out.println("Pocet drevenych: " + pole.zjistiPocetDrevenych()); ;
    }

}
