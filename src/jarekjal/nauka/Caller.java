package jarekjal.nauka;

public class Caller implements Runnable{
    public Calle target;
    public Thread t;
    public String msg;

    public Caller(String msg, Calle target){
        this.target = target;
        this.msg = msg;
        this.t = new Thread(this);
    }

    @Override
    public void run() {
        target.callme(msg);
    }
}
