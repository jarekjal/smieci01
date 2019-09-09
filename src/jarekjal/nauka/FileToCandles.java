package jarekjal.nauka;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileToCandles {

    private String filePath;
    private List<Candle> candles;
    private List<String> fileLines = new ArrayList<>();
    private boolean fileLoaded = false;

    public FileToCandles(String path, List<Candle> list){
        filePath = path;
        candles = list;
        readFile();
        convert();
    }

    public boolean fileLoaded(){
        return fileLoaded;
    }

    private boolean readFile(){
        File file = new File(filePath);
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                fileLines.add(line);
                System.out.println(line);
            }
            System.out.println("Lines loaded: " + fileLines.size());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean convert(){
        for(String l : fileLines ){
            Candle candle = convertLine(l);
            candles.add(candle);
        }
        return true;
    }

    private Candle convertLine(String l){
        String[] tokens = l.split(",");
        assert tokens.length == 7;
        Candle c = new Candle(tokens);
        return c;
    }

    public static void main(String[] args){
        List<Candle> candles = new ArrayList<>();
        FileToCandles ftc = new FileToCandles("C:\\Users\\jarekjal\\Downloads\\FGOLD.1440.csv", candles);
        //candles.forEach(candle -> {System.out.println(candle.getOpen());});
        Stream<Candle> candleStream = candles.parallelStream();
        candleStream.filter(candle -> candle.getOpen() > 1700.0).forEach(candle -> System.out.println(candle.getOpen()));
        StringReader sr = new StringReader("Jaloszynski");
        char[] buf = new char[100];
        System.out.println(sr.read(buf, 0, 5) + " : " + print(buf));

    }

    private static String print(char[] b){
        int cnt = 0;
        String s = "";
        while ( cnt < b.length ){
            s += b[cnt++];
        }
        return s;
    }
}
