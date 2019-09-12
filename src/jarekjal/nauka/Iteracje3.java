package jarekjal.nauka;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class Iteracje3 {


    public static void main(String[] args) {
        Collection<String> stringList = Arrays.asList("aa", "bbb", "c", "dddd", "eee", "ffffff", "gggg");
        Iterator<String> i1, i2, i3, i4;
        i1 = stringList.iterator();
        i2 = new FilterIterator<String>(i1, s -> s.length() <= 3 );
        i3 = new FilterIterator<String>(i2, s -> s.length() >= 2 );
        i4 = new MapIterator<String, String>(i3, s -> s.toUpperCase());

        while (i4.hasNext()){
            System.out.println(i4.next());
        }

        Iterator<String> j1, j2, j3;
        Iterator<Integer> j4;
        j1 = stringList.iterator();
        j2 = new FilterIterator<String>(j1, s -> s.length() <= 7 );
        j3 = new FilterIterator<String>(j2, s -> s.length() >= 2 );
        j4 = new MapIterator<String, Integer>(j3, s -> s.length());
        int max = -1;
        while(j4.hasNext()){
            int n = j4.next();
            if (n > max) {
                max = n;
            }
        }
        System.out.println("Max length: " + max);

    }

}
