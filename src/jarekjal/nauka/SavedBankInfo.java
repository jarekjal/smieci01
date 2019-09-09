package jarekjal.nauka;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class SavedBankInfo {

    private String fname;
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private int nextaccount = 0;


    public SavedBankInfo(String fname){
        this.fname = fname;
        File file = new File(fname);
        if (!file.exists()) return;  // nie ma pliku uprzednio zapisanego danymi
        try (InputStream is = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(is);){

            accounts = (Map<Integer, BankAccount>) ois.readObject();
            nextaccount = ois.readInt();
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException("file read exception");
        }
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public int nextAccNum(){
        return nextaccount;
    }

    public void saveMap(Map<Integer, BankAccount> map, int nextaccount){
        try(OutputStream os = new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(os);){

            oos.writeObject(map);
            oos.writeInt(nextaccount);
        } catch (IOException ex) {
            System.out.println(ex);
            throw new RuntimeException("file write exception");
        }
    }



}
