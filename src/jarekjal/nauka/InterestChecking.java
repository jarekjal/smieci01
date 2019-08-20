package jarekjal.nauka;

public class InterestChecking extends CheckingAccount{

    protected double rate = 0.01;

    public InterestChecking(int acctnum) {
        super(acctnum);
    }

    @Override
    public String toString(){
        return "Interest checking account nr: " + acctnum + " is " + ( isForeign ? "foreign" : "domestic") +" and has balance: " + balance + "\n";
    }

    @Override
    public void addInterest(){
        balance = (int)(balance * (1+rate));
    }
}
