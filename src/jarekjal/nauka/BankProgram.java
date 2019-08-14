package jarekjal.nauka;

import java.util.HashMap;
import java.util.Scanner;

public class BankProgram {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer , BankAccount> accounts = new HashMap<>();
        Bank bank = new Bank(accounts, 0);
        BankClient client = new BankClient(scanner,bank);
        client.run();
    }
}
