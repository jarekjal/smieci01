package jarekjal.nauka;

import java.lang.reflect.Array;
import java.util.*;

public class Iteracje {

    public static void main(String[] args){

        String[] array = {"123", "456", "789"};

        List<String> list;
        list = new ArrayList<>(Arrays.asList(array));
        list.add((String)"trr");

        try {
            Iterator<String> it = list.iterator();
            list.remove(0);
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (ConcurrentModificationException ex){
            System.out.println("Ktos modyfikuje cos!");
        }
/*
        RandomIterator ri = new Iteracje().new RandomIterator();
        int i = 0;
        while(ri.hasNext() && i < 10){
            i++;
            System.out.println(ri.next());
        }
*/
        PrimeIterator pi = new Iteracje.PrimeIterator(7);
        while (pi.hasNext()){
            System.out.println(pi.next());
        }

    }

    public class RandomIterator implements Iterator<Integer>{

        private Random rand = new Random();

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return rand.nextInt();
        }
    }

    public static class PrimeIterator implements Iterator<Integer>{

        private int howmany;
        private int count = 0;
        private int current = 1;

        public PrimeIterator(int h){
            howmany = h;

        }

        @Override
        public boolean hasNext() {
            return count < howmany;
        }

        @Override
        public Integer next() {
           current++;
           while(!isPrime(current)) {
               current++;
           }
           count++;
           return current;
        }

        private boolean isPrime(int n){
            for (int i = 2; i*i <= n; i++){
                if (n%i == 0) return false;
            }
            return true;
        }
    }



}
