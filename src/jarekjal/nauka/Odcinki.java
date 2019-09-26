package jarekjal.nauka;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Odcinki {

    // find intersection point of 2 line segments
    //
    // https://gist.github.com/Roland09/e72296d8de55f3051d6a
    // http://stackoverflow.com/questions/563198/how-do-you-detect-where-two-line-segments-intersect
    // http://www.openprocessing.org/sketch/135314
    // http://www-cs.ccny.cuny.edu/~wolberg/capstone/intersection/Intersection%20point%20of%20two%20lines.html

    public static Point2D getLineIntersection(Odcinek lineA, Odcinek lineB) {
        double x1 = lineA.getA().getX();
        double y1 = lineA.getA().getY();
        double x2 = lineA.getB().getX();
        double y2 = lineA.getB().getY();

        double x3 = lineB.getA().getX();
        double y3 = lineB.getA().getY();
        double x4 = lineB.getB().getX();
        double y4 = lineB.getB().getY();

        double ax = x2 - x1;
        double ay = y2 - y1;
        double bx = x4 - x3;
        double by = y4 - y3;

        double denominator = ax * by - ay * bx;

        if (denominator == 0)
            return null;

        double cx = x3 - x1;
        double cy = y3 - y1;

        double t = (cx * by - cy * bx) / denominator;
        if (t < 0 || t > 1)
            return null;

        double u = (cx * ay - cy * ax) / denominator;
        if (u < 0 || u > 1)
            return null;

        return new Point2D(x1 + t * ax, y1 + t * ay);
    }

}
