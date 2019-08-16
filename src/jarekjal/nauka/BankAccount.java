package jarekjal.nauka;

public interface BankAccount {

    public int getAcctnum();

    public int getBalance();

    public boolean isForeign();

    public void setForeign(boolean foreign);

    public void deposit(int amount);

    public void addInterest();

    public String toString();

    public boolean hasEnoughCollateral(int amount);
}
