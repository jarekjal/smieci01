package jarekjal.nauka;

import java.util.Collection;
import java.util.HashMap;

public class Bank {

    private HashMap<Integer, BankAccount> accounts;
    private int nextacct;

    public Bank(HashMap<Integer, BankAccount> accounts, int n){
        this.accounts = accounts;
        nextacct = n;
    }

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

    public int newAccount(int type, boolean foreign) {
        int id = nextacct++;
        BankAccount newAcc;
        if (type == 1) {
            newAcc = new SavingsAccount(id);
        } else {
            newAcc = new CheckingAccount(id);
        }
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
