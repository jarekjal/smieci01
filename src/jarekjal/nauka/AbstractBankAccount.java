package jarekjal.nauka;

public abstract class AbstractBankAccount implements BankAccount{

    protected int acctnum;
    protected int balance = 0;
    protected boolean isForeign = false;

    protected AbstractBankAccount(int num){
        acctnum = num;
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
    public int compareTo(BankAccount o) {
        int bal1 = this.getBalance();
        int bal2 = o.getBalance();
        if (bal1 == bal2){
            return this.getAcctnum() - o.getAcctnum();
        } else {
            return bal1 - bal2;
        }
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof BankAccount) {
            BankAccount ba = (BankAccount) o;
            return ba.getAcctnum() == getAcctnum();
        } else return false;
    }

    public abstract void addInterest();
    public abstract String toString();
    public abstract boolean hasEnoughCollateral(int amount);

}
