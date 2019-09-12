package jarekjal.nauka;

public abstract class BankAccountWrapper implements BankAccount {

    protected BankAccount ba;

    protected BankAccountWrapper(BankAccount ba){
        this.ba = ba;
    }

    @Override
    public int getAcctnum() {
        return ba.getAcctnum();
    }

    @Override
    public int getBalance() {
        return ba.getBalance();
    }

    @Override
    public boolean isForeign() {
        return ba.isForeign();
    }

    @Override
    public void setForeign(boolean foreign) {
        ba.setForeign(foreign);
    }

    @Override
    public void deposit(int amount) {
        ba.deposit(amount);
    }

    @Override
    public void addInterest() {
        ba.addInterest();
    }

    @Override
    public boolean hasEnoughCollateral(int amount) {
        return ba.hasEnoughCollateral(amount);
    }

    @Override
    public int compareTo(BankAccount o) {
        return ba.compareTo(o);
    }
}
