package jarekjal.nauka;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamTest {

    public static void main(String[] args) throws Exception {

        List<String> L = Arrays.asList("a", "b", "c", "d");
        OutputStream os = new FileOutputStream("sav.txt");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(L);
        oos.close();

        InputStream is = new FileInputStream("sav.txt");
        ObjectInputStream ois = new ObjectInputStream(is);
        List<String> L1 = (List<String>) ois.readObject();

        System.out.println(L);
        System.out.println(L1);

    }

}
