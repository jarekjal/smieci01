package jarekjal.nauka;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Bank implements Iterable<BankAccount> {

    private Map<Integer, BankAccount> accounts;
    private int nextacct;

    public Bank(Map<Integer, BankAccount> accounts, int n){
        this.accounts = accounts;
        nextacct = n;
    }

    public int getNextacct(){
        return nextacct;
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
        BankAccount newAcc = AccountFactory.createAccount(id, type);
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

    @Override
    public Iterator<BankAccount> iterator() {
        Iterator<BankAccount> it = accounts.values().iterator();
        return  new UnmodifiableBankIterator(it);
    }
}
