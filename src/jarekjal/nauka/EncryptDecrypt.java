package jarekjal.nauka;

import java.io.*;

public class EncryptDecrypt {

    public static void main(String[] args) throws IOException {

        try(
        InputStream is = new FileInputStream("C:\\testy\\plik.jpg");
        OutputStream os = new FileOutputStream("C:\\testy\\decr.txt");) {
            int x;
            int cnt = 0;
            int offset = 0;
            int bytesToRead = 100;
            while ((x = is.read()) >= 0 && cnt < bytesToRead) {
                os.write(((byte) x) + offset);
                cnt++;
            }
        }
    }

}
