package jarekjal.nauka;

import java.io.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws InterruptedException, IOException {


        InputStream input = System.in;
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(isr);
        int read;
        ArrayList<Integer> buffer = new ArrayList<>();
        do {
            read = br.read();
            buffer.add(read);
            System.out.println(read);
        } while (read != (int)'x' && buffer.size() < 50 );
        System.out.print("Pobrano znakow: " + buffer.size() + "\n");
        for (int i : buffer) {
            System.out.print((char)i);
        }
        

    }

}
