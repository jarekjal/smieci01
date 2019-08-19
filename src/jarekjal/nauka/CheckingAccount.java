package jarekjal.nauka;

public class CheckingAccount implements BankAccount{

    private int acctnum;
    private int balance = 0;
    private boolean isForeign = false;


    public CheckingAccount(int a){
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
    public void deposit(int amount) {
            balance += amount;
    }

    @Override
    public void addInterest() {
        // do nothing
    }

    @Override
    public String toString(){
        return "Checking account nr: " + acctnum + " is " + ( isForeign ? "foreign" : "domestic") +" and has balance: " + balance + "\n";
    }

    @Override
    public boolean hasEnoughCollateral(int amount) {
        return balance >= 2 * amount / 3;
    }

    @Override
    public int compareTo(BankAccount o) {
        int bal1 = this.getBalance();
        int bal2 = o.getBalance();
        if (bal1 == bal2){
            return this.getAcctnum() - o.getAcctnum();
        } else {
            return bal1 - bal2;
        }
    }

}
