package jarekjal.nauka;

import java.io.InputStream;
import java.util.Scanner;

public class BankClient {

    private Scanner scanner;
    private boolean done = false;
    private Bank bank;
    private int current = 0;
    private InputCommand[] inputCommands = { new CmdQuit(), new CmdNewAccount(), new CmdSelect(),
                                             new CmdDeposit(), new CmdAuthorizeLoan(), new CmdShowAll(),
                                             new CmdShowAll(), new CmdSetForeign()
                                            };

    public BankClient(Scanner scanner, Bank bank){
       this.bank = bank;
       this.scanner = scanner;
    }


    public void run(){
        while(!done) {
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest, 7=setForeign): ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
    }

    private void processCommand(int cmd) {
        if (cmd < 0 || cmd >= inputCommands.length) {
            System.out.println("Illegal command!");
        }
        current = inputCommands[cmd].execute(scanner, bank, current);
        if (current < 0) { done = true;}
    }

}
