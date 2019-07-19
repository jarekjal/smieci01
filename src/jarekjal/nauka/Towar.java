package jarekjal.nauka;

import java.math.BigDecimal;

public class Towar {

    private String name;
    private BigDecimal price;
    private BigDecimal quantity;

    public Towar() {
        this("unknown", "0.0", "0.0");
    }

    public Towar(String name, String price, String quantity) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.quantity = new BigDecimal(quantity);
    }

    public Towar(Towar t){
        this.name = t.name;
        this.price = t.price;
        this.quantity = t.quantity;
    }

    @Override
    public String toString() {
        return super.toString() + "[name: " + name + ", price: " + price.toString() + ", quantity: " + quantity.toString() + "]";
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
