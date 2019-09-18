package jarekjal.nauka;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class FoodIterator implements Iterator<FoodItem> {


    private Stack<Iterator<FoodItem>> s = new Stack<>();
    public FoodIterator(FoodItem f) {
        Collection<FoodItem> c = Collections.singleton(f);
        s.push(c.iterator());
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
    public FoodItem next() {
        FoodItem food = s.peek().next(); // return this value
        if (!s.peek().hasNext())
            s.pop(); // pop the iterator when it is empty
        Iterator<FoodItem> iter = food.childIterator();
        if (iter.hasNext())
            s.push(iter); // push the child iterator if non-empty
        return food;
    }
}
