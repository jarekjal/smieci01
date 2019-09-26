package jarekjal.nauka;

import java.util.ArrayList;
import java.util.Collection;

public class CountModel  {

    private int value = 0;
    private Collection<CountObserver> observers = new ArrayList<CountObserver>();

    public void addObserver(CountObserver obs){
        observers.add(obs);
    }

    private void notifyObservers(){
        for(CountObserver obs : observers){
            obs.update(value);
        }
    }

    public int getValue(){
        return value;
    }

    public void updateValue(int n){
        value += n;
        notifyObservers();
    }


}
