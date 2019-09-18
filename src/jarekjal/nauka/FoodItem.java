package jarekjal.nauka;

import java.util.Iterator;

public interface FoodItem extends Iterable<FoodItem> {

    boolean isVegan();
    String name();
    Iterator<FoodItem> childIterator();
    default Iterator<FoodItem> iterator(){
        return  new FoodIterator(this);
    }
}
