package jarekjal.nauka;

public class CheckingAccount extends AbstractBankAccount {

    public CheckingAccount(int a){
        super(a);
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

}
