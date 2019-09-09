package jarekjal.nauka;

public class SavingsFactory implements AccountFactory {

    @Override
    public BankAccount create(int accnum) {
        return new SavingsAccount(accnum);
    }
}
