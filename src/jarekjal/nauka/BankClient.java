package jarekjal.nauka;

import java.util.Scanner;

public class BankClient {

    private Scanner scanner;
    private boolean done = false;
    private Bank bank;
    private int current = -1;

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
        if      (cmd == 0) quit();
        else if (cmd == 1) newAccount();
        else if (cmd == 2) select();
        else if (cmd == 3) deposit();
        else if (cmd == 4) authorizeLoan();
        else if (cmd == 5) showAll();
        else if (cmd == 6) addInterest();
        else if (cmd == 7) setForeign();
        else System.out.println("Illegal command!");
    }

    private void setForeign() {
        boolean foreign = requestForeign();
        bank.setForeign(current, foreign);
        System.out.println("Foreign option for account nr: " + current + " set to: " + foreign);
    }


    private void addInterest() {
        bank.addInterest();
    }

    private void showAll() {
        System.out.println(bank.toString());
    }

    private void authorizeLoan() {
        System.out.print("Enter loan amount to authorize: ");
        int amount = scanner.nextInt();
        boolean result = bank.authorizeLoan(current, amount);
        if(result) {
            System.out.println("Authorized!");
        } else {
            System.out.println("Not authorized :(");
        }
    }

    private void deposit() {
        System.out.print("Enter money amount: ");
        int amount = scanner.nextInt();
        bank.deposit(current, amount);
        System.out.println("Deposited money");
    }

    private void select() {
        System.out.print("Enter account nr: ");
        current = scanner.nextInt();
        int balance = bank.select(current);
        System.out.println("Balance of account nr " + current + " is " + balance);
    }

    private void newAccount() {
        boolean isForeign = requestForeign();
        int id = bank.newAccount(isForeign);
        current = id;
        System.out.println("New acount nr is: " + id);
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

    private void quit() {
        System.out.println("Good bye!");
        done = true;
    }

}
