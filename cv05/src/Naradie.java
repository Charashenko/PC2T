public class Naradie extends Zbozi {

    private int zaruka;

    public Naradie(String name, double price, int zaruka) {
        super(name, price);
        this.zaruka = zaruka;
    }

    public int getZaruka() {
        return zaruka;
    }

    public void setZaruka(int zaruka) {
        this.zaruka = zaruka;
    }

    public String getJednotka(){
        return "mesiacov";
    }
}
