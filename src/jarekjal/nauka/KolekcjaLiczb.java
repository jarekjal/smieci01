package jarekjal.nauka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class KolekcjaLiczb implements Iterable<Integer>{

    private Integer[] tablica = {8, 0, 0, 4, 1, 0, 5, 3, 7, 9, 1, 0, 4, 2};
    private List<Integer> lista = new ArrayList<>(Arrays.asList(tablica));


    @Override
    public Iterator<Integer> iterator() {
        return lista.iterator();
    }

    Stream<Integer> stream(){
        return lista.stream();
    }
}
