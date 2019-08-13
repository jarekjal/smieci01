package jarekjal.nauka;

import java.util.ArrayList;
import java.util.List;

public class Magazyn {

    private List<Towar> store = new ArrayList<>();

    public Magazyn(Inicjalizator ini){
        store = ini.getStore();
    }

    public void sellItem(Towar t){
        List<Integer> records = selectRecords(t.getName());
        if (records.size() == 0) {
            System.out.println("Nie mozna sprzedac - produkt nie istnieje");
            return;
        }
        int recordUpdatedIndex = findPrice(records, t.getPrice());
        if (recordUpdatedIndex == -1) {
            System.out.println("Nie mozna sprzedac - cena nie zgodna");
            return;
        }
        Towar recordUpdated = store.get(recordUpdatedIndex);
        double oldQty = recordUpdated.getQuantity();
        if (oldQty < t.getQuantity()) {
            System.out.println("Nie mozna sprzedac - nie ma tyle w magazynie");
        } else {
            recordUpdated.setQuantity(oldQty - t.getQuantity());
            sortStore();
            System.out.println("Sprzedano: " + t);
            System.out.println(recordUpdated);
        }
    }

    private void sortStore() {
        store.sort((o1, o2) -> {return o1.compareTo(o2);});
    }

    public void addItem(Towar t){
        List<Integer> records = selectRecords(t.getName());
        if (records.size() == 0) {
            store.add(t);
            System.out.println("Dodano: " + t);
        } else {
            int recordUpdatedIndex = findPrice(records, t.getPrice());
            if (recordUpdatedIndex == -1) {
                // dodaj nowy rekord
                store.add(t);
                System.out.println("Dodano z cena: " + t);
            } else {
                // dodaj do istniejacego rekordu
                Towar recordUpdated = store.get(recordUpdatedIndex);
                double oldQty = recordUpdated.getQuantity();
                recordUpdated.setQuantity(t.getQuantity() + oldQty);
                System.out.println("Zaktualizowano sztuki: " + t);
                System.out.println(recordUpdated);
            }
            sortStore();
        }
    }

    private int findPrice(List<Integer> list, int price){
        for(Integer record : list){
            if (store.get(record).getPrice() == price) {
                return record;
            }
        }
        return -1;
    }

    private ArrayList<Integer> selectRecords(String itemName){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < store.size(); i++ ){
            if(store.get(i).getName().equals(itemName)){
                result.add(i);
            }
        }
        return result;
    }

    public String toString(){
        String result= "Stan magazynu:\n";
        for (Towar e : store){
            result = result + e + "\n";
        }
        result += "Ilość towarów w magazynie: " + store.size();
        return result;
    }

}
