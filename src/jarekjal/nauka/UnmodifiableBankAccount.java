package jarekjal.nauka;

public class UnmodifiableBankAccount extends BankAccountWrapper {

    public UnmodifiableBankAccount(BankAccount ba) {
        super(ba);
    }

    @Override
    public void setForeign(boolean foreign) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deposit(int amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addInterest() {
        throw new UnsupportedOperationException();
    }
}
