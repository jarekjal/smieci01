package jarekjal.nauka;

public abstract class CheckingAccount extends AbstractBankAccount {

    public CheckingAccount(int a){
        super(a);
    }

    public double collateralRatio(){
        return 2.0 / 3.0;
    }

    protected abstract double interestRate();
    protected abstract String accountType();
}
