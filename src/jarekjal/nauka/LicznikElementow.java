package jarekjal.nauka;

public class LicznikElementow {
    public static <T> int count(T[] tablica, WarunekFunc<T> warunek ){
        int count = 0;
        for(T e : tablica){
            if (warunek.warunekSpelniony(e)) count++;
        }
        return count;
    }

}
