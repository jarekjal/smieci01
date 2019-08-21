package jarekjal.nauka;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankProgram {
    public static void main(String[] args) throws FileNotFoundException {

        SavedBankInfo info = new SavedBankInfo("C:\\testy\\data.info");
        InputStream is = System.in; //new FileInputStream("C:\\testfile.txt");//
        Scanner scanner = new Scanner(is);
        Map<Integer , BankAccount> accounts = info.getAccounts();
        int nextacct = info.nextAccNum();
        Bank bank = new Bank(accounts, nextacct);
        BankClient client = new BankClient(scanner,bank);
        client.run();
        info.saveMap(accounts, bank.getNextacct());
    }
}
