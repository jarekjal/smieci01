package jarekjal.nauka;

import java.util.Scanner;

public class CmdSelect implements InputCommand {
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.print("Enter account nr: ");
        current = sc.nextInt();
        int balance = bank.select(current);
        System.out.println("Balance of account nr " + current + " is " + balance);
        return current;
    }

    @Override
    public String toString(){
        return "select";
    }
}
