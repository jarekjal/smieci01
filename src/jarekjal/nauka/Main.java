package jarekjal.nauka;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here

        Magazyn magazyn = new Magazyn();
        Towar towar1 = new Towar("papierosy", "14.99", "27");
        System.out.println(towar1);
        magazyn.addItem(towar1);
        magazyn.addItem(towar1);

        Towar towar2 = new Towar(towar1);
        System.out.println(towar2);
        magazyn.addItem(towar2);
/*
        Thread thread = Thread.currentThread();
        String threadInfo = thread.getId() + thread.getName() + thread.getPriority() + thread.getState();
        System.out.println(thread + " " + threadInfo);
        Watek w = new Watek();
        Watek w2 = new Watek();
        w2.setNum(5);
        Thread t = new Thread(w, "watek_nowy");
        Thread t2 = new Thread(w2, "watek_nowy2");
        t.start();
        t2.start();

        t.join();
        t2.join();
*/
        Calle calee1 = new Calle();

        Caller c1 = new Caller("Hello", calee1);
        Caller c2 = new Caller("synchronized", calee1);
        Caller c3 = new Caller("world!", calee1);

        c1.t.start();
        c2.t.start();
        c3.t.start();


        c1.t.join();
        c2.t.join();
        c3.t.join();


        System.out.println("main ending");

    }

}
