package jarekjal.nauka;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Bank {

    private HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private double rate = 0.01;
    private int nextacct = 0;


    public void addInterest() {
        Collection<BankAccount> accs = accounts.values();
        for(BankAccount a : accs){
            a.addInterest();
        }
    }

    public String toString() {
        String result= "";
        Collection<BankAccount> accs = accounts.values();
        for (BankAccount a : accs){
            result += a.toString();
        }
        return result;
    }

    public boolean authorizeLoan(int id, int amount) {
        BankAccount a = accounts.get(id);
        return a.hasEnoughCollateral(amount);
    }

    public void deposit(int id,int amount) {
        BankAccount act = accounts.get(id);
        act.deposit(amount);
    }

    public int select(int id) {
        int balance = accounts.get(id).getBalance();
        return balance;
    }

    public int newAccount(boolean foreign) {
        int id = nextacct++;
        BankAccount newAcc = new BankAccount(id);
        newAcc.setForeign(foreign);
        accounts.put(id, newAcc);
        return id;
    }

    public boolean isForeign(int id) {
        return accounts.get(id).isForeign();
    }

    public void setForeign(int id, boolean foreign) {
        accounts.get(id).setForeign(foreign);
    }
}
