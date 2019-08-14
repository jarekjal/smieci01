package jarekjal.nauka;

public class BankAccount {

    private int acctnum;
    private int balance = 0;
    private boolean isForeign = false;
    private static double rate = 0.01;

    public BankAccount(int a){
        acctnum = a;
    }

    public int getAcctnum() {
        return acctnum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    public void deposit(int amt){
        balance += amt;
    }

    public String toString(){
        return "Account nr: " + acctnum + " is " + ( isForeign ? "foreign" : "domestic") +" and has balance: " + balance + "\n";
    }

    public void addInterest() {
        balance = (int)(balance * (1+rate));
    }

    public boolean hasEnoughCollateral(int amount) {
        return balance >= amount / 2 ;
    }
}
