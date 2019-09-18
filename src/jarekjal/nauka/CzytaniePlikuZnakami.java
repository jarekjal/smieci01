package jarekjal.nauka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class CzytaniePlikuZnakami {

    static final int N = 7;
    public static void main(String[] args) throws Exception {
        Reader reader = new BufferedReader(new FileReader("mobydickshort.txt"));
        int i;
        while((i = reader.read()) >= 0){
            char ch = (char) i;
            check(reader, ch);
        }


    }

    private static void check(Reader reader, char ch) throws Exception{
        reader.mark(N+1);
        char[] t = new char[N+1];
        int howmany = reader.read(t);
        if( howmany == N+1 && t[N] == ch ) {
            System.out.print(ch); System.out.println(t);
        }
        reader.reset();
    }
}
