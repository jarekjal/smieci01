package jarekjal.nauka;

import java.util.Scanner;

public class BankClient {

    private Scanner scanner;
    private boolean done = false;
    private Bank bank;
    private int current = 0;
    private InputCommand[] inputCommands = { new CmdQuit(), new CmdNewAccount(), new CmdSelect(),
                                             new CmdDeposit(), new CmdAuthorizeLoan(), new CmdShowAll(),
                                             new CmdAddInterest(), new CmdSetForeign()
                                            };

    public BankClient(Scanner scanner, Bank bank){
       this.bank = bank;
       this.scanner = scanner;
    }


    public void run(){
        while(!done) {
            String commands = constructMessage();
            System.out.print(commands);
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
    }

    private String constructMessage() {
        String msg = "Enter command (";
        for (int i = 0; i < inputCommands.length - 1; i++){
            msg += "" + i + "=" + inputCommands[i].toString() + ", ";
        }
        int lastInd = inputCommands.length - 1;
        msg += "" + (lastInd) + "=" + inputCommands[lastInd].toString() +"): ";
        return msg;
    }

    private void processCommand(int cmd) {
        if (cmd < 0 || cmd >= inputCommands.length) {
            System.out.println("Illegal command!");
        }
        current = inputCommands[cmd].execute(scanner, bank, current);
        if (current < 0) { done = true;}
    }

}
