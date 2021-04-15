// CV05, Stefan Olenocin, 231 262

public class Test {
    public static void main(String[] args) {
        Zbozi[] zbozi = new Zbozi[4];
        zbozi[0] = new Potravina("rohlik", 1.5, 1);
        zbozi[1] = new Naradie("klieste", 278, 24);
        zbozi[2] = new Potravina("chlieb", 20.8, 6);
        zbozi[3] = new Potravina("jablko", 51, 20);

        for(Zbozi z : zbozi){
            if (z instanceof Potravina){
                System.out.format("%s, cena: %.2f, trvanlivost: %d %s%n", z.getName(), z.getPrice(), ((Potravina) z).getTrvanlivost(), ((Potravina) z).getJednotka());
            }
            else {
                System.out.format("%s, cena: %.2f%n", z.getName(), z.getPrice());
            }
        }
    }
}
