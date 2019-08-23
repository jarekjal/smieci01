package jarekjal.nauka;

import java.util.Scanner;

public class CmdSetForeign implements InputCommand{
    private  Scanner scanner;

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        scanner = sc;
        boolean foreign = requestForeign();
        bank.setForeign(current, foreign);
        System.out.println("Foreign option for account nr: " + current + " set to: " + foreign);
        return current;
    }

    private boolean requestForeign(){
        System.out.print("Is foreign account? (0=no, 1=yes): ");
        int foreign = scanner.nextInt();
        boolean isForeign;
        if (foreign == 1) {
            isForeign = true;
        }
        else {
            isForeign = false;
        }
        return isForeign;
    }
}
