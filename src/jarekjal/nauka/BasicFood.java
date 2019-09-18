package jarekjal.nauka;

import java.util.Collections;
import java.util.Iterator;

public class BasicFood implements FoodItem {

    private boolean isvegan;
    private String name;

    public BasicFood(String s, boolean v){
        isvegan = v;
        name = s;
    }

    @Override
    public boolean isVegan() {
        return isvegan;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Iterator<FoodItem> childIterator() {
        return Collections.emptyIterator();
    }

    @Override
    public String toString(){
        String vegan = isVegan() ? " (vegan)" : "";
        return name() + vegan;
    }

}
