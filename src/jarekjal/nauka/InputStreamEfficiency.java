package jarekjal.nauka;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamEfficiency {

    public static void main(String[] args) throws IOException {

        String src = "mobydick.txt";
        long t1 = readFileUnbuffered(src);
        long t2 = readFileArrayBuffer(src);
        long t3 = readFileDecoratorBuffer(src);
        long t4 = readProgressMonitor(src);
        System.out.println("File unbuffered: " + t1);
        System.out.println("File array buffer: " + t2);
        System.out.println("File decorator buffer: " + t3);
        System.out.println("Progress monitor: " + t4);

    }

    public static long readFileUnbuffered(String src) throws IOException{
        long begintime = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(src)){
            int x;
            while ( (x = is.read()) >= 0){
                byte b = (byte) x;
                // process byte
            }
        }
        return System.currentTimeMillis() - begintime;
    }

    public static long readFileArrayBuffer(String src) throws IOException{
        long begintime = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(src)){
            byte[] a = new byte[1024];
            int howmany;
            while ((howmany  = is.read(a)) > 0){
                for (int pos = 0; pos < howmany; pos++ ){
                    byte b = a[pos];
                    // process byte
                }
            }
        }
        return System.currentTimeMillis() - begintime;
    }

    public static long readFileDecoratorBuffer(String src) throws IOException{
        long begintime = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(src);
            BufferedInputStream bis = new BufferedInputStream(is)){
            int x;
            while ((x = bis.read()) >= 0){
                byte b = (byte) x;
                // process byte
            }

        }
        return System.currentTimeMillis() - begintime;
    }

    public static long readProgressMonitor(String src) throws IOException{
        long begintime = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(src);
             ProgressMonitorInputStream bis = new ProgressMonitorInputStream(null, "reading" + src, is)){
            int x;
            while ((x = bis.read()) >= 0){
                byte b = (byte) x;
                // process byte
            }

        }
        return System.currentTimeMillis() - begintime;
    }
}
