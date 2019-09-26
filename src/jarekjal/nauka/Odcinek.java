package jarekjal.nauka;

import javafx.geometry.Point2D;

public class Odcinek {

    private Point2D a, b;
    private boolean visible = true;

    public Odcinek(Point2D p1, Point2D p2){
        a = p1;
        b = p2;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Point2D getA(){
        return a;
    }

    public Point2D getB(){
        return b;
    }

    @Override
    public String toString(){
        return "" + a + "->" + b ;
    }

    public static void main(String[] args){

        Odcinek odc2 = new Odcinek(new Point2D(-5.0, -2.0), new Point2D(1.0, 3.0));
        OdcinekIterator oi = new OdcinekIterator(new Point2D(0.0, 0.0), 360, 100);
        while (oi.hasNext()){
            System.out.println(Odcinki.getLineIntersection(odc2,oi.next()));
        }

    }

}
