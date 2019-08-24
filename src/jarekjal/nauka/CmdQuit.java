package jarekjal.nauka;

import java.util.Scanner;

public enum CmdQuit implements InputCommand {
    INSTANCE;

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println("Good bye!");
        return -1; // means set done to true
    }

    @Override
    public String toString(){
        return "quit";
    }
}
