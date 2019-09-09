package jarekjal.nauka;

public class RegularCheckingFactory implements AccountFactory {
    @Override
    public BankAccount create(int accnum) {
        return new RegularChecking(accnum);
    }
}
