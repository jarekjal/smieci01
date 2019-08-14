package jarekjal.nauka;

public class BankAccount {

    private int acctnum;
    private int balance = 0;
    private boolean isForeign = false;

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
}
