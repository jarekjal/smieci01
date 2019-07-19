package jarekjal.nauka;

import java.util.ArrayList;
import java.util.List;

public class Magazyn {

    private List<Towar> store = new ArrayList<>();

    public void addItem(Towar t){
        if (!itemExistInStore(t)) {
            store.add(t);
            System.out.println("Dodano: " + t.toString());
        } else {
            System.out.println("Nie mozna dodac");
        }
    }

    private boolean itemExistInStore(Towar t){
        for (Towar e : store) {
            if (e.getName().equals(t.getName())) {
                return true;
            }
        }
        return false;
    }

}
