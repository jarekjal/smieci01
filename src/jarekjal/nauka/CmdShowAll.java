package jarekjal.nauka;

import java.util.Scanner;

public class CmdShowAll  implements InputCommand{
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println(bank.toString());
        return current;
    }
}
