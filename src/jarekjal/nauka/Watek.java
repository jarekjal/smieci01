package jarekjal.nauka;

public class Watek implements Runnable {
    int num = 10;

    public void setNum(int n){
        num = n;
    }

    @Override
    public void run() {
        String nazwa = Thread.currentThread().getName();
        for (int i = 0; i <num; i++) {
            System.out.println("Watek..." + nazwa + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
