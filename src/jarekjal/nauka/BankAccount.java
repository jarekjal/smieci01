package jarekjal.nauka;

import java.io.Serializable;

public interface BankAccount extends Comparable<BankAccount>, Serializable {

    public int getAcctnum();

    public int getBalance();

    public boolean isForeign();

    public void setForeign(boolean foreign);

    public void deposit(int amount);

    public void addInterest();

    public String toString();

    public boolean hasEnoughCollateral(int amount);

    public static BankAccount createAccountWithDeposit(int accnum, int deposit){
        BankAccount ba;
        AccountFactory af = AccountFactories.SAVINGS;
        ba = af.create(accnum);
        ba.deposit(deposit);
        return ba;
    }

    public default boolean isEmpty(){
        return getBalance() == 0;
    }
}
