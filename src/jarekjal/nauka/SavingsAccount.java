package jarekjal.nauka;

public class SavingsAccount extends AbstractBankAccount {


    public SavingsAccount(int a){
        super(a);
    }

    @Override
    protected double collateralRatio() {
        return 0.5;
    }

    @Override
    protected double interestRate() {
        return 0.01;
    }

    @Override
    protected String accountType() {
        return "Savings";
    }



}
