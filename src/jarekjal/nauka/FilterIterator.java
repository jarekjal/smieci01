package jarekjal.nauka;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {

    private Iterator<T> it;
    private Predicate<T> predicate;
    private T next;
    private boolean found = false;

    public FilterIterator(Iterator<T> i1, Predicate<T> p) {
        it = i1;
        predicate = p;
    }

    @Override
    public boolean hasNext() {
        found = false;
        while (it.hasNext()) {
            T n = it.next();
            if( predicate.test(n) ) {
                next = n;
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public T next() {
        if (found == false) {
            throw new NoSuchElementException();
        } else {
            return next;
        }
    }
}
