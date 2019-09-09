package jarekjal.nauka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Iteracje2 {

    public static void main(String[] args){

        KolekcjaLiczb kolekcjaLiczb = new KolekcjaLiczb();
        ConsumerPrintujacy cp;
        kolekcjaLiczb.forEach(cp = new ConsumerPrintujacy((i) -> i > 5 ));
        List<Integer> wynik = cp.getLista();
        System.out.println(wynik);



    }



}
