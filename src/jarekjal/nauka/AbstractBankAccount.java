package jarekjal.nauka;

public abstract class AbstractBankAccount implements BankAccount{

    protected int acctnum;
    protected int balance = 0;
    private OwnerStrategy owner = new Domestic();

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
        return owner.isForeign();
    }

    @Override
    public void setForeign(boolean foreign) {
        owner = foreign ? new Foreign() : new Domestic();
    }

    public int fee(){
        return owner.fee();
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

    public boolean hasEnoughCollateral(int amount){
        return balance >= amount * collateralRatio();
    }

    public void addInterest(){
        balance += (int)(balance * interestRate());
    }

    public String toString(){
        return accountType() + " account nr: " + acctnum + " is " + owner +" and has balance: " + balance
                + ", fee=" + owner.fee() +"\n";
    }

    protected abstract double collateralRatio();
    protected abstract double interestRate();
    protected abstract String accountType();

}
