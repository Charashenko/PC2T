public class Potravina extends Zbozi {

    private int trvanlivost;

    public Potravina(String name, double price, int trvanlivost) {
        super(name, price);
        this.trvanlivost = trvanlivost;
    }

    public int getTrvanlivost() {
        return trvanlivost;
    }

    public void setTrvanlivost(int trvanlivost) {
        this.trvanlivost = trvanlivost;
    }

    public String getJednotka(){
        return "dni";
    }
}
