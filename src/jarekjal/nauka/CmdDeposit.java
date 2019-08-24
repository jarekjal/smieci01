package jarekjal.nauka;

import java.util.Scanner;

public enum CmdDeposit  implements InputCommand{
    INSTANCE;

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.print("Enter money amount: ");
        int amount = sc.nextInt();
        bank.deposit(current, amount);
        System.out.println("Deposited money");
        return current;
    }

    @Override
    public String toString(){
        return "deposit";
    }
}
