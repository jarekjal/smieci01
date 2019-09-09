package jarekjal.nauka;

public interface AccountFactory {

    BankAccount create(int accnum);

    static AccountFactory[] factories = AccountFactories.values();

    static BankAccount createAccount (int accnum, int type){
        AccountFactory af = factories[type - 1];
        return af.create(accnum);
    }
}
