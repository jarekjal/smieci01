package jarekjal.nauka;

import java.util.Scanner;

public enum CmdShowAll  implements InputCommand{
    INSTANCE;

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println(bank.toString());
        return current;
    }

    @Override
    public String toString(){
        return "show";
    }

}
