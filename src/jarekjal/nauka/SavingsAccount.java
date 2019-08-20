package jarekjal.nauka;

public class SavingsAccount extends AbstractBankAccount {

    private static double rate = 0.01;

    public SavingsAccount(int a){
        super(a);
    }

    @Override
    public String toString(){
        return "Savings account nr: " + acctnum + " is " + ( isForeign ? "foreign" : "domestic") +" and has balance: " + balance + "\n";
    }

    @Override
    public boolean hasEnoughCollateral(int amount) {
        return balance >= amount / 2 ;
    }

    @Override
    public void addInterest() {
        balance = (int)(balance * (1+rate));
    }

}
