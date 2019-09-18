package jarekjal.nauka;

import java.util.*;

public class Recipe implements FoodItem {

    private String name;
    private Map<FoodItem, Integer> ingredients = new HashMap<>();
    private String directions;

    public Recipe(String n, String d){
        name = n;
        directions = d;
    }

    public void addIngredient(FoodItem f, int qty){
        ingredients.put(f, qty);
    }

    @Override
    public boolean isVegan() {
        for (FoodItem fi : ingredients.keySet()){
            if (!fi.isVegan()) return false;
        }
        return true;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Iterator<FoodItem> childIterator() {
        return ingredients.keySet().iterator();
    }

    public int getQty(FoodItem f){
        return ingredients.get(f);
    }

    @Override
    public String toString(){
        String veg = isVegan() ? " (vegan)" : "";
        String result = "Recipe for " + name + veg + "\n";
        result += "Ingredients:\n";
        for (FoodItem item : ingredients.keySet()) {
            int qty = ingredients.get(item);
            result += "\t" + qty + " " + item.name() + "\n";
        }
        return result + "Directions: " + directions + "\n";
    }

}
