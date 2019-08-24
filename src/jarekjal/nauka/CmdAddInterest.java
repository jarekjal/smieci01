package jarekjal.nauka;

import java.util.Scanner;

public enum CmdAddInterest implements InputCommand {
    INSTANCE;

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        bank.addInterest();
        return current;
    }

    @Override
    public String toString(){
        return "interest";
    }
}
