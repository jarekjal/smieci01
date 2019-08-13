package jarekjal.nauka;

public class Towar implements Comparable<Towar>{

    private static int nextid = 0;
    private int id;
    private String name;
    private int price;
    private double quantity;

    public Towar() {
        this("unknown", 0, 0.0);
    }

    public Towar(String name, int price, double quantity) {
        if (!name.equals("") && price > 0 && quantity > 0.0){
            this.id = nextid++;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        } else throw new IllegalArgumentException("Bad constructor arguments");
    }

    public Towar(Towar t){
        this.name = t.name;
        this.price = t.price;
        this.quantity = t.quantity;
    }

    @Override
    public String toString() {
        return //super.toString() +
                "["
                + "id: " + id
                + ", name: " + name
                + ", price: " + formatIntAsDecimal(price)
                + ", quantity: " + quantity
                + ", value: " + formatIntAsDecimal(getValue())
                + "]";
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double qty){
        quantity = qty;
    }

    public int getValue(){
        return (int)Math.round(quantity * price);
    }

    private String formatIntAsDecimal(int num) {
        int gr = num % 100;
        String grStr ;
        if (gr == 0) {
            grStr = "00";
        } else {
            grStr = "" + gr;
        }
        int zl = num / 100;
        return  "" + zl + "." + grStr;
    }

    @Override
    public int compareTo(Towar o) {
        int result =  this.getName().compareTo(o.getName());
        if (result == 0) {
            result = this.price - o.price;
        }
        return result;
    }
}
