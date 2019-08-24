package jarekjal.nauka;

import java.util.Scanner;

public enum CmdNewAccount implements InputCommand {
    INSTANCE;

    private Scanner scanner;

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        scanner = sc;
        boolean isForeign = CmdSetForeign.requestForeign(scanner);
        int accType = requestType();
        int id = bank.newAccount(accType, isForeign);
        System.out.println("New acount nr is: " + id);
        return id;
    }

    private int requestType() {
        System.out.print("Enter account type: (1=savings, 2=checking, 3=interestChecking): ");
        int type = scanner.nextInt();
        return type;
    }

    @Override
    public String toString(){
        return "new";
    }
}
