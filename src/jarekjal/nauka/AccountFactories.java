package jarekjal.nauka;

public enum AccountFactories implements AccountFactory {
    SAVINGS("Savings", accnum -> new SavingsAccount(accnum)),
    REGULAR_CHEKING("Regular checking", accnum -> new RegularChecking(accnum)),
    INTEREST_CHECKING("Interest checking", accnum -> new InterestChecking(accnum));

    private String name;
    private AccountFactory af;
    private AccountFactories(String name, AccountFactory af){
        this.name = name;
        this.af= af;
    }


    @Override
    public BankAccount create(int accnum) {
        return af.create(accnum);
    }

    @Override
    public String toString(){
        return name;
    }
}
