package jarekjal.nauka;

public class Zliczacz {

    private long counter;

    public Zliczacz(long init){
        counter = init;
    }

    public void add(long amt){
        counter += amt;
    }

    public void reset(){
        counter = 0;
    }

    public long getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "" + counter;
    }
}
