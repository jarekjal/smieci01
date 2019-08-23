package jarekjal.nauka;

public class InterestChecking extends CheckingAccount{

    protected double rate = 0.01;

    public InterestChecking(int acctnum) {
        super(acctnum);
    }

    @Override
    protected double interestRate() {
        return 0.01;
    }

    @Override
    protected String accountType() {
        return "Interest checking";
    }


}
