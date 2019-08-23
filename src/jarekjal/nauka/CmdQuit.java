package jarekjal.nauka;

import java.util.Scanner;

public class CmdQuit implements InputCommand {

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println("Good bye!");
        return -1; // means set done to true
    }
}
