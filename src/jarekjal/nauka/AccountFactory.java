package jarekjal.nauka;

public interface AccountFactory {

    static BankAccount createSavings(int accnum){
        return new SavingsAccount(accnum);
    }

    static BankAccount createReguralChecking(int accnum){
        return new RegularChecking(accnum);
    }

    static BankAccount createInterestChecking(int accnum){
        return new InterestChecking(accnum);
    }

    static BankAccount createAccount (int accnum, int type){
        BankAccount ba;
        if (type == 1 ){
            ba = createSavings(accnum);
        } else if (type == 2) {
            ba = createReguralChecking(accnum);
        } else {
            ba = createInterestChecking(accnum);
        }
        return ba;
    }
}
