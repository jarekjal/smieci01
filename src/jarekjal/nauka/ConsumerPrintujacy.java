package jarekjal.nauka;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerPrintujacy implements Consumer<Integer> {

    private Predicate<Integer> predicate;
    private List<Integer> lista = new ArrayList<>();

    public ConsumerPrintujacy(Predicate<Integer> pred){
        predicate = pred;
    }

    public List<Integer> getLista(){
        return lista;
    }

    @Override
    public void accept(Integer integer) {
        if(predicate.test(integer)){
            lista.add(integer);
            System.out.print(" " + integer);
        }
    }
}
