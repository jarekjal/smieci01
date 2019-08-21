package jarekjal.nauka;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class SavedBankInfo {

    private String fname;
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private int nextaccount = 0;
    private ByteBuffer bb = ByteBuffer.allocate(16);

    public SavedBankInfo(String fname){
        this.fname = fname;
        File file = new File(fname);
        if (!file.exists()) return;  // nie ma pliku uprzednio zapisanego danymi
        try (InputStream is = new FileInputStream(file.getAbsolutePath())){
            readMap(is);
        } catch (IOException ex) {
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
        try(OutputStream os = new FileOutputStream(fname)){
            writeMap(os, map, nextaccount);
        } catch (IOException ex) {
            throw new RuntimeException("file write exception");
        }
    }

    private void writeMap(OutputStream os, Map<Integer,BankAccount> map, int nextaccount) throws IOException {
        writeInt(os, nextaccount);
        for (BankAccount ba : map.values()){
            writeAccount(os, ba);
        }
    }

    private void writeAccount(OutputStream os, BankAccount ba) throws IOException {
        bb.putInt(0, ba.getAcctnum());
        int type = (ba instanceof SavingsAccount) ? 1 :
                (ba instanceof RegularChecking) ? 2 : 3;
        bb.putInt(4, type);
        bb.putInt(8, ba.getBalance());
        bb.putInt(12, ba.isForeign() ? 1 : 2);
        os.write(bb.array());
    }

    private void writeInt(OutputStream os, int n) throws IOException {
        bb.putInt(0, n);
        os.write(bb.array(), 0, 4);
    }

    private void readMap(InputStream is) throws IOException {
        nextaccount = readInt(is);
        BankAccount ba;
        while( (ba = readAccount(is)) != null ){
            accounts.put(ba.getAcctnum(), ba);
        }
    }

    private BankAccount readAccount(InputStream is) throws IOException {
        int n = is.read(bb.array()); // liczba odczytanych bajtow
        if (n < 0) return null;
        int num = bb.getInt(0);
        int type = bb.getInt(4);
        int balance = bb.getInt(8);
        int isforeign = bb.getInt(12);
        BankAccount ba;
        if (type == 1) {
            ba = new SavingsAccount(num);
        } else if (type == 2) {
            ba = new RegularChecking(num);
        } else {
            ba = new InterestChecking(num);
        }
        ba.deposit(balance);
        ba.setForeign(isforeign == 1);
        return  ba;
    }

    private int readInt(InputStream is) throws IOException {
        is.read(bb.array(), 0, 4);
        return bb.getInt();
    }

}
