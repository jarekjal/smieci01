package jarekjal.nauka;

import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStream<T> {

    private Iterator<T> it;

    public SimpleStream(Iterator<T> i){
        it = i;
    }

    public Iterator<T> iterator(){
        return it;
    }

    public void forEach(Consumer<T> consumer){
        while(it.hasNext()){
            consumer.accept(it.next());
        }
    }

    public SimpleStream<T> filter(Predicate<T> predicate){
        FilterIterator<T> fi = new FilterIterator<>(it, predicate);
        return new SimpleStream<T>(fi);
    }

    public <R> SimpleStream<R> map(Function<T,R> f){
        MapIterator<T, R> mi = new MapIterator<>(it, f);
        return new SimpleStream<R>(mi);
    }

    public T reduce(T identity, BinaryOperator<T> bo){
        T result = identity;
        while (it.hasNext()) {
            T t = it.next();
            result = bo.apply(result, t);
        }
        return result;
    }

}
