package jarekjal.nauka;

public class Candle {

    private String date;
    private String time;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;

    public Candle(String[] l){
        assert l.length == 7;
        date = l[0];
        time = l[1];
        open = Double.parseDouble(l[2]);
        high = Double.parseDouble(l[3]);
        low = Double.parseDouble(l[4]);
        close = Double.parseDouble(l[5]);
        volume = Double.parseDouble(l[6]);
    }

    public double getOpen(){
        return open;
    }
}
