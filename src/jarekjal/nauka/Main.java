package jarekjal.nauka;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    private enum Dni {
        PON(1, ""), WTO(2, ""), SRO(3, ""), CZW(4, ""), PIA(5, ""), SOB(6, ""), NIE(7, "");
        private int num;
        private String opis;

        Dni(int a, String s) {
            num = a;
            opis = s;
        }

        public void setOpis(String s) {
            opis = s;
        }

        public String getOpis() {
            return opis;
        }
    }


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

        Dni dni[] = Dni.values();
        Dni d = Dni.valueOf("WTO");
        System.out.println(d);
        d.setOpis("dupa");
        System.out.println(d.getOpis());

        Class<?> klasa = calee1.getClass();

        try {

            Method m = klasa.getDeclaredMethod("callme", String.class);
            Annotation[] aa = m.getDeclaredAnnotations();
            if (aa.length != 0) {
                System.out.println(aa[0]);
                MyAnno ma = (MyAnno)aa[0];
                System.out.println(ma.str()+ ma.val());
            } else {
                System.out.println("Metoda nie ma annotacji");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Nie znaleziono takiej metody w klasie " + klasa.getName());
        }

        System.out.println("main ending");

    }

}
