package jarekjal.nauka;

import java.util.Iterator;

public class AngleIterator implements Iterator<Double> {

    private int n;
    private int cnt = 0;

    public AngleIterator(int n){
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        return cnt < n;
    }

    @Override
    public Double next() {
        return (360.0 / n) * cnt++;
    }
}
