package jarekjal.nauka;

import java.util.Scanner;

public class CmdNewAccount implements InputCommand {

    private Scanner scanner;

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        scanner = sc;
        boolean isForeign = requestForeign();
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
