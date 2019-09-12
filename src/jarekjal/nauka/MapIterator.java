package jarekjal.nauka;

import java.util.Iterator;
import java.util.function.Function;

public class MapIterator <T, R> implements Iterator<R> {

    private Iterator<T> it;
    private Function<T, R> fun;

    public MapIterator(Iterator<T> i, Function<T, R> f){
        it = i;
        fun = f;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public R next() {
        R res = fun.apply(it.next());
        return res;
    }
}
