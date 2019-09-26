package jarekjal.nauka;

import javafx.geometry.Point2D;

import java.util.List;

public class VisibleObjects {
    private List<Point2D> visiblePoints;
    private List<Odcinek> scanLines;

    public VisibleObjects(List<Point2D> v, List<Odcinek> s){
        visiblePoints = v;
        scanLines = s;
    }

    public List<Point2D> getVisiblePoints() {
        return visiblePoints;
    }

    public List<Odcinek> getScanLines() {
        return scanLines;
    }

    public void setVisiblePoints(List<Point2D> visiblePoints) {
        this.visiblePoints = visiblePoints;
    }

    public void setScanLines(List<Odcinek> scanLines) {
        this.scanLines = scanLines;
    }
}
