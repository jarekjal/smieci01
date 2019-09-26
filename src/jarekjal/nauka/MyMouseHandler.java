package jarekjal.nauka;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class MyMouseHandler implements EventHandler<MouseEvent> {


    private Canvas canvas;
    public MyMouseHandler(Canvas c) {
        canvas = c;
    }

    private void drawPoint(Canvas canvas, Point2D point) {
        canvas.getGraphicsContext2D().fillOval(point.getX(),point.getY(),2,2);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("" + mouseEvent.getSceneX() + " , " + mouseEvent.getSceneY());
        drawPoint(canvas, new Point2D(mouseEvent.getSceneX(), mouseEvent.getSceneY()));
    }
}
