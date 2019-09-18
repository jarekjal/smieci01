package jarekjal.nauka;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Szyfrowanie {

    public static void main(String[] args) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56);
        SecretKey secretKey = kg.generateKey();

        encrypt("mobydick.txt", "encrypted.txt", secretKey, Cipher.ENCRYPT_MODE);
        encrypt("encrypted.txt", "decrypted.txt", secretKey, Cipher.DECRYPT_MODE);


    }

    private static void encrypt(String src, String output, SecretKey key, int mode) throws Exception{
        Cipher c = Cipher.getInstance("DES");
        c.init(mode, key);
        try( InputStream is = new FileInputStream(src);
             CipherInputStream cis = new CipherInputStream(is, c);
             OutputStream os = new FileOutputStream(output);){

            int x;
            while((x = cis.read()) >= 0){
                byte b = (byte) x;
                os.write(b);
            }

        }

    }


}
