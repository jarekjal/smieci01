package jarekjal.nauka;

import java.util.Scanner;

public class BankClient {

    private Scanner scanner = new Scanner(System.in);
    private boolean done = false;
    private Bank bank = new Bank();



    public void run(){
        while(!done) {
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
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
        else System.out.println("Illegal command!");
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
        boolean result = bank.authorizeLoan(amount);
        if(result) {
            System.out.println("Authorized!");
        } else {
            System.out.println("Not authorized :(");
        }
    }

    private void deposit() {
        System.out.print("Enter money amount: ");
        int amount = scanner.nextInt();
        bank.deposit(amount);
        System.out.println("Deposited money");
    }

    private void select() {
        System.out.print("Enter account nr: ");
        int id = scanner.nextInt();
        int balance = bank.select(id);
        System.out.println("Balance of account nr " + id + " is " + balance);
    }

    private void newAccount() {
        int id = bank.newAccount();
        System.out.println("New acount nr is: " + id);
    }

    private void quit() {
        System.out.println("Good bye!");
        done = true;
    }
    
}
