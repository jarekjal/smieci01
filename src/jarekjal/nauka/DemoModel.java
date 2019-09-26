package jarekjal.nauka;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.List;


public class DemoModel {

    private List<DemoObserver> observers = new ArrayList<>();
    private List<Odcinek> odcinki = new ArrayList<>();

    public void addObserver(DemoObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (DemoObserver observer : observers) {
            observer.update(odcinki.iterator());
        }
    }

    private void generateScene() {
        addSceneBorders();
        RandomRectIterator ri = new RandomRectIterator(new Rectangle2D(0,0, 50, 50),
                new Rectangle2D(0,0, 200, 200), 10);
        while (ri.hasNext()){
            addRect(ri.next(), true);
        }
    }

    private void addSceneBorders() {
        addRect(new Rectangle2D(0, 0,1200, 600), false);
    }

    private void addRect(Rectangle2D rect, boolean visible) {
        Point2D p1 = new Point2D(rect.getMinX(), rect.getMinY());
        Point2D p2 = new Point2D(rect.getMinX(), rect.getMaxY());
        Point2D p3 = new Point2D(rect.getMaxX(), rect.getMinY());
        Point2D p4 = new Point2D(rect.getMaxX(), rect.getMaxY());
        Odcinek odc = new Odcinek(p1, p3);
        odc.setVisible(visible);
        odcinki.add(odc);
        odc = new Odcinek(p3, p4);
        odc.setVisible(visible);
        odcinki.add(odc);
        odc = new Odcinek(p4, p2);
        odc.setVisible(visible);
        odcinki.add(odc);
        odc = new Odcinek(p2, p1);
        odc.setVisible(visible);
        odcinki.add(odc);
    }


    public void clear() {
        odcinki.clear();
        notifyObservers();
    }


    public VisibleObjects getVisiblePoints(OdcinekIterator odcIt) {
        boolean includePointsOnScanLineEnds = false;
        List<Point2D> visiblePoints = new ArrayList<>();
        List<Odcinek> scanLines = new ArrayList<>();
        while (odcIt.hasNext()) {
            Odcinek ray = odcIt.next();
            scanLines.add(ray);
            Point2D center = ray.getA();
            double minDistance = Double.MAX_VALUE;
            double distance;
            Point2D closeToCentrePoint = null;
            for (Odcinek odc : odcinki) {
                Point2D point = Odcinki.getLineIntersection(ray, odc);
                if (point != null) {
                    if ((distance = center.distance(point)) < minDistance) {
                        minDistance = distance;
                        closeToCentrePoint = point;
                    }
                }
            }
            if( includePointsOnScanLineEnds && closeToCentrePoint == null) {
                double R = odcIt.getR();
                double r = ray.getA().distance(ray.getB());
                double x = center.getX() + (ray.getB().getX() - center.getX())*R/r;
                double y = center.getY() + (ray.getB().getY() - center.getY())*R/r;
                closeToCentrePoint = new Point2D(x,y);
            }
            if (closeToCentrePoint != null) visiblePoints.add(closeToCentrePoint);
        }
        VisibleObjects vo = new VisibleObjects(visiblePoints.size() == 0 ? null : visiblePoints, scanLines);
        return vo;
    }


    public void start() {
        generateScene();
        notifyObservers();
    }
}
