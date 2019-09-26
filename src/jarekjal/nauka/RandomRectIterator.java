package jarekjal.nauka;

import javafx.geometry.Rectangle2D;

import java.util.Iterator;
import java.util.Random;

public class RandomRectIterator implements Iterator<Rectangle2D> {

    private int num;
    private int cnt = 0;
    private double minX;
    private double minY;
    private double maxX;
    private double maxY;
    private Random rand = new Random();

    public RandomRectIterator(Rectangle2D minSize, Rectangle2D maxSize, int n){
        minX = minSize.getWidth();
        minY = minSize.getHeight();
        maxX = maxSize.getWidth();
        maxY = maxSize.getHeight();
        num = n;
    }

    @Override
    public boolean hasNext() {
        return cnt < num;
    }

    @Override
    public Rectangle2D next() {

        double x = rand.nextInt(1200);
        double y = rand.nextInt(600);
        double w = minX + rand.nextInt((int)(maxX - minX));
        double h = minY + rand.nextInt((int)(maxY - minY));
        cnt++;
        return new Rectangle2D(x, y, w, h);
    }
}
