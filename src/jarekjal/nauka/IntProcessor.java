package jarekjal.nauka;

public class IntProcessor {

    private Operator op;

    public IntProcessor(Operator o){
        op = o;
    }

    public void process(int x){
        int result = op.f(x);
        System.out.println("Wartosc x= " + x + ", po przetworzeniu: " + result);
    }

    public static void main(String[] args){

        IntProcessor ip = new IntProcessor( new AddTwo());
        ip.process(5);
    }
}

