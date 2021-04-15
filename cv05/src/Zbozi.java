public abstract class Zbozi {
    private String name;
    private double price;
    private static double dph = 21;

    public Zbozi(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price*(dph/100+1);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static double getDph() {
        return dph;
    }

    public static void setDph(double dph) {
        Zbozi.dph = dph;
    }
}
