package jarekjal.nauka;

public class RegularChecking extends CheckingAccount {

    public RegularChecking(int accnum){
        super(accnum);
    }

    @Override
    public void addInterest() {
        // do nothing
    }

    @Override
    public String toString() {
        return "Regural checking account " + acctnum + " is " + ( isForeign ? "foreign" : "domestic") +" and has balance: " + balance + "\n";
    }
}
