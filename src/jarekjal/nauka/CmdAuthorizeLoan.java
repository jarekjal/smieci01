package jarekjal.nauka;

import java.util.Scanner;

public enum CmdAuthorizeLoan implements InputCommand{
    INSTANCE;

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.print("Enter loan amount to authorize: ");
        int amount = sc.nextInt();
        boolean result = bank.authorizeLoan(current, amount);
        if(result) {
            System.out.println("Authorized!");
        } else {
            System.out.println("Not authorized :(");
        }
        return current;
    }

    @Override
    public String toString(){
        return "loan";
    }
}
