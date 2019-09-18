package jarekjal.nauka;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

public class Cookbook {

    private static Map<String, Recipe> cbook = new HashMap<>();

    public static void main(String[] args){

        addRecipes();
        System.out.println("\n---VEGAN RECIPES---");
        printRecipes(r->r.isVegan());

        System.out.println("\n---RECIPES USING 4+ ITEMS---");
        printRecipes(r -> foodsUsed1(r)>=4);
        printRecipes(r -> foodsUsed2(r)>=4);
        printRecipes(r -> foodsUsed3(r)>=4);
        System.out.println("\n---RECIPES COMPRISING SALAD---");
        printRecipesUsedIn1(cbook.get("salad"));
        printRecipesUsedIn2(cbook.get("salad"));
        System.out.println("\n---SHOPPING LIST FOR SALAD---");
        printShoppingList(cbook.get("salad"),2);

    }

    private static int foodsUsed1(FoodItem f){
        int cnt = 0;
        if (f instanceof BasicFood) {
            cnt = 1;
        } else {
            Iterator<FoodItem> it = f.childIterator();
            while (it.hasNext()) {
                cnt += foodsUsed1(it.next());
            }
        }
        return cnt;
    }

    private static int foodsUsed2(FoodItem r) {
        int count = 0;
        Iterator<FoodItem> iter = r.iterator();
        while (iter.hasNext())
            if (iter.next() instanceof BasicFood)
                count++;
        return count;
    }

    private static int foodsUsed3(FoodItem r) {
        int count = 0;

        for (FoodItem item : r) {
            if (item instanceof BasicFood)
                count++;
        }
        return count;
    }

    private static void printRecipesUsedIn2(Recipe r) {
        r.forEach(item -> {
            if (item instanceof Recipe) {
                System.out.println(item.name());
            }});
    }

    private static void printRecipesUsedIn1(Recipe r) {
        for (FoodItem item : r) {
            if (item instanceof Recipe)
                System.out.println(item.name());
        }
    }

    private static void printRecipes(Predicate<Recipe> pred){
        for(Recipe r : cbook.values()){
            if (pred.test(r)) {
                System.out.println(r);
            }
        }
    }

    private static void printShoppingList(Recipe r, int howmany) {
        Iterator<FoodItem> iter = r.childIterator();
        while (iter.hasNext()) {
            FoodItem item = iter.next();
            int amt = r.getQty(item) * howmany;
            if (item instanceof BasicFood)
                System.out.println(item.name() + " " + amt);
            else
                printShoppingList((Recipe) item, amt);
        }
    }
    private static void addRecipes(){
        Recipe dressing = new Recipe("dressing", "Mix well.");
        dressing.addIngredient(new BasicFood("oil", true), 4);
        dressing.addIngredient(new BasicFood("vinegar", true), 2);
        cbook.put("dressing", dressing);
        Recipe salad = new Recipe("salad",
                "Chop lettuce, add bacon. Pour dressing over it.");
        salad.addIngredient(new BasicFood("lettuce", true), 1);
        salad.addIngredient(new BasicFood("bacon", false), 6);
        salad.addIngredient(dressing, 1);
        cbook.put("salad", salad);
    }


}
