package jarekjal.nauka;


import javafx.geometry.Point2D;

import java.util.Iterator;

public class OdcinekIterator implements Iterator<Odcinek> {

    private Point2D centerPoint;
    private AngleIterator ai;
    private double R;

    public OdcinekIterator(Point2D p, int n, double R){
        centerPoint = p;
        ai = new AngleIterator(n);
        this.R = R;
    }

    @Override
    public boolean hasNext() {
        return ai.hasNext();
    }

    @Override
    public Odcinek next() {
        double alfa = Math.toRadians(ai.next());
        double x = centerPoint.getX() + R * Math.cos(alfa);
        double y = centerPoint.getY() + R * Math.sin(alfa);
        Point2D newPoint = new Point2D( x, y );
        return new Odcinek(centerPoint, newPoint);
    }

    public double getR() {
        return R;
    }
}
