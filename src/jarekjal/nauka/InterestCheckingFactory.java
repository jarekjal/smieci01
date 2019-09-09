package jarekjal.nauka;

public class InterestCheckingFactory implements AccountFactory {
    @Override
    public BankAccount create(int accnum) {
        return new InterestChecking(accnum);
    }
}
