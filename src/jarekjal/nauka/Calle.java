package jarekjal.nauka;

@MyAnno(str = "jakis tekst" , val = 100)
public class Calle {

    @MyAnno(str = "jakis tekst opisujacy metode", val =50)
    public void callme(String msg){
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }

}
