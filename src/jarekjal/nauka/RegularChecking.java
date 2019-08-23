package jarekjal.nauka;

public class RegularChecking extends CheckingAccount {

    public RegularChecking(int accnum){
        super(accnum);
    }

    @Override
    protected double interestRate() {
        return 0.0;
    }

    @Override
    protected String accountType() {
        return "Regular Checking";
    }


}
