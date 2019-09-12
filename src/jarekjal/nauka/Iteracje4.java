package jarekjal.nauka;

import java.util.Arrays;
import java.util.Collection;


public class Iteracje4 {

    public static void main(String[] args) {
        Collection<String> list = Arrays.asList("aa", "bbb", "c", "dddd", "eee", "ffffff", "gggg");
        SimpleStream<String> ss = new SimpleStream<>(list.iterator());
        ss.filter(s -> s.length() < 4)
                .filter(s -> s.length() > 1)
                .map(s -> s.length())
                .forEach(s -> System.out.println(s));

        ss = new SimpleStream<>(list.iterator());
        Integer max = ss.filter(s -> s.length() > 1)
                .map(s -> s.length())
                .reduce(0, (i1, i2) -> Math.max(i1, i2));
        System.out.println("max: " + max);
    }

}
