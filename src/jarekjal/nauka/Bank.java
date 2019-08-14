package jarekjal.nauka;

import java.util.HashMap;
import java.util.Set;

public class Bank {

    private HashMap<Integer, Integer> accounts = new HashMap<>();
    private double rate = 0.01;
    private int nextacct = 0;
    private int current = -1;

    public void addInterest() {
        Set<Integer> accountIds = accounts.keySet();
        for(int i : accountIds){
            int balance = accounts.get(i);
            int newbalance = (int) (balance * (1 + rate));
            accounts.put(i, newbalance);
        }
    }

    public String toString() {
        String result= "";
        Set<Integer> accountIds = accounts.keySet();
        for (int i : accountIds){
            result +="Balance of account nr: " + i + " is " + accounts.get(i) + "\n";
        }
        return result;
    }

    public boolean authorizeLoan( int amount) {
        int balance = accounts.get(current);
        if(amount <= balance / 2) {
            return true;
        } else {
            return false;
        }
    }

    public void deposit(int amount) {
        int balance = accounts.get(current);
        accounts.put(current, balance + amount);
    }

    public int select(int cur) {
        current = cur;
        int balance = accounts.get(current);
        return balance;
    }

    public int newAccount() {
        current = nextacct++;
        accounts.put(current, 0);
        return current;
    }

}
