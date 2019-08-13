package jarekjal.nauka;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BankProgram {

    private HashMap<Integer, Integer> accounts = new HashMap<>();
    private double rate = 0.01;
    private int nextacct = 0;
    private int current = -1;
    private Scanner scanner;
    private boolean done = false;

    public static void main(String[] args){
        BankProgram program = new BankProgram();
        program.run();
    }

    public void run(){
        scanner = new Scanner(System.in);
        while(!done) {
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest: ");
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
        Set<Integer> accountIds = accounts.keySet();
        for(int i : accountIds){
            int balance = accounts.get(i);
            int newbalance = (int) (balance * (1 + rate));
            accounts.put(i, newbalance);
        }
    }

    private void showAll() {
        Set<Integer> accountIds = accounts.keySet();
        for (int i : accountIds){
            System.out.println("Balance of account nr: " + i + " is " + accounts.get(i));
        }
    }

    private void authorizeLoan() {
        System.out.print("Enter loan amount to authorize: ");
        int amount = scanner.nextInt();
        int balance = accounts.get(current);
        if(amount <= balance / 2) {
            System.out.println("Authorized!");
        } else {
            System.out.println("Not authorized :(");
        }
    }

    private void deposit() {
        System.out.print("Enter money amount: ");
        int amount = scanner.nextInt();
        int balance = accounts.get(current);
        accounts.put(current, balance + amount);
        System.out.println("Deposited money");
    }

    private void select() {
        System.out.print("Enter account nr: ");
        current = scanner.nextInt();
        int balance = accounts.get(current);
        System.out.println("Balance of account nr " + current + " is " + balance);
    }

    private void newAccount() {
        current = nextacct++;
        accounts.put(current, 0);
        System.out.println("New acount nr is: " + current);
    }

    private void quit() {
        System.out.println("Good bye!");
        done = true;
    }


}
