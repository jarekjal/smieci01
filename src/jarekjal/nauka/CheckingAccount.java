package jarekjal.nauka;

public abstract class CheckingAccount extends AbstractBankAccount {

    protected CheckingAccount(int a){
        super(a);
    }

    public abstract void addInterest();
    public abstract String toString();

    @Override
    public boolean hasEnoughCollateral(int amount) {
        return balance >= 2 * amount / 3;
    }

}
