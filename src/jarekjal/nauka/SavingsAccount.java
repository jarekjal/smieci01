package jarekjal.nauka;

public class SavingsAccount implements BankAccount {

    private int acctnum;
    private int balance = 0;
    private boolean isForeign = false;
    private static double rate = 0.01;

    public SavingsAccount(int a){
        acctnum = a;
    }

    @Override
    public int getAcctnum() {
        return acctnum;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean isForeign() {
        return isForeign;
    }

    @Override
    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    @Override
    public void deposit(int amount){
        balance += amount;
    }


    @Override
    public String toString(){
        return "Savings account nr: " + acctnum + " is " + ( isForeign ? "foreign" : "domestic") +" and has balance: " + balance + "\n";
    }

    @Override
    public boolean hasEnoughCollateral(int amount) {
        return balance >= amount / 2 ;
    }

    @Override
    public void addInterest() {
        balance = (int)(balance * (1+rate));
    }
}