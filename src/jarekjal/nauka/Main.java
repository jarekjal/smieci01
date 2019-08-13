package jarekjal.nauka;

import java.io.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        String file = "C:\\plik.txt";

        try(FileInputStream fin = new FileInputStream(file)){
            int i;
            long bytes = 0;
            do{
                i = fin.read();
                if ( i != -1){
                    bytes++;
                    System.out.print((char)i);
                }
            } while (i != -1);
            System.out.println("\nPrzeczytano z pliku " + file + " " + bytes + " B");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("I/O error!");;
        }

        Pudelko<String> pudelko = new Pudelko<>("Jarek");
        pudelko.showStoredType();
        System.out.println(pudelko.getOb());

        VarArgFun<Integer> v = (a) -> {
            for(int e : a){
                System.out.println(e);
            }
            return null;
        };
        v.test(3, 2, 1 );
        useLambda(v);

        StringFunc reverseString = (s) -> {
            String result = "";
            for (int i = s.length() - 1; i >= 0; i--){
                result += s.charAt(i);
            }
            return result;
        };

        System.out.println(reverseString.strOp("jakiś tekst tu napiszę a on się odwróci jak w lustrze!"));
        System.out.println(f(Main::someStrOp, "dupa"));

        Integer[] t = {9, 8, 7, 6};
        WarunekFunc<Integer> w = e -> {return e < 8;};
        int liczbaEl = LicznikElementow.count(t, w);
        System.out.println(liczbaEl);
        String[] tStr = {"dfdsgs", "gsg", "aa", "", "", "oooad"};
        WarunekFunc<String> wStr = e -> {return !"".equals(e);};
        System.out.println(LicznikElementow.count(tStr,wStr));

        Towar papierosy = new Towar("LM light", 1499, 10.35);
        System.out.println(papierosy);
        Towar papierosy2 = new Towar("Marlboro", 1570, 24);
        System.out.println(papierosy2);
        Towar papierosy3 = new Towar("LM light", 1499, 35);
        System.out.println(papierosy3);
        Towar papierosy4 = new Towar("LM light", 1400, 35);
        System.out.println(papierosy4);

        Magazyn magazyn = new Magazyn(new InicjalizatorPlikowy("baza.txt"));
        magazyn.addItem(papierosy);
        magazyn.addItem(papierosy2);
        magazyn.addItem(papierosy3);
        magazyn.addItem(papierosy4);
        System.out.println(magazyn);
        magazyn.sellItem(new Towar("LM light", 1499, 20));
        System.out.println(magazyn);
        magazyn.sellItem(new Towar("LM light", 1499, 25.35));
        System.out.println(magazyn);
    }

    private static String f(StringFunc x, String msg){
            return x.strOp(msg);
    }

    private static String someStrOp (String s){
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--){
            result += s.charAt(i);
        }
        return result;
    }

    private static void useLambda(VarArgFun<Integer> var){
        var.test(6);
    }
}
