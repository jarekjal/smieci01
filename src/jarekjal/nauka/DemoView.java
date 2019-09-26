package jarekjal.nauka;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.List;


public class DemoView {

    private DemoController controller;
    private Pane root;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Canvas canvas, canvas2;
    private GraphicsContext gc, gc2;

    public DemoView(DemoController c) {
        controller = c;
        controller.setView(this);
        root = createWindow();
        addButtonActions();
        addCanvasActions();
    }

    private void addCanvasActions() {

    }

    private void addButtonActions() {
        btn1.setOnAction(event -> controller.btn1Pressed());
        btn2.setOnAction(event -> controller.btn2Pressed());

        btn4.setOnAction(event -> btn4Pressed());
    }

    private void btn4Pressed() {
        btn4.setText("Mode: show");
        canvas2.setOnMouseMoved(event -> controller.canvas2MouseMoved(event));
    }


    public Pane getRoot() {
        return root;
    }

    private Pane createWindow() {
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        btn1 = new Button("Generate scene");
        btn2 = new Button("Clear");
        btn3 = new Button("Info");
        btn4 = new Button("Mode");
        hBox.getChildren().addAll(btn1, btn2, btn3, btn4);
        canvas = new Canvas();
        canvas.setHeight(600);
        canvas.setWidth(1200);
        gc = canvas.getGraphicsContext2D();
        canvas2 = new Canvas();
        canvas2.setHeight(600);
        canvas2.setWidth(1200);
        gc2 = canvas2.getGraphicsContext2D();
        Pane p = new Pane();
        p.getChildren().addAll(canvas,canvas2);
        vBox.getChildren().addAll(hBox, p);
        root = vBox;
        return root;
    }

    public void draw(Iterator<Odcinek> it) {
        gc.clearRect(0, 0, 1200, 600);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        Point2D pp, pn;
        while (it.hasNext()) {
            Odcinek odc = it.next();
            if (!odc.isVisible()) continue;
            pp = odc.getA();
            pn = odc.getB();
            gc.strokeLine(pp.getX(), pp.getY(), pn.getX(), pn.getY());
        }
    }

    public void drawScanLines(List<Odcinek> odcinki){
        for (Odcinek odc : odcinki){
            gc2.setStroke(Color.LIGHTBLUE);
            gc2.strokeLine(odc.getA().getX(), odc.getA().getY(), odc.getB().getX(), odc.getB().getY());
        }
    }

    public void drawPoints(Point2D centrer, List<Point2D> visiblePts, List<Odcinek> odcinki) {
        final int POINTSIZE = 4;
        gc2.clearRect(0, 0, 1200, 600);
        drawScanLines(odcinki);
        if (visiblePts == null ) return;
        gc2.setStroke(Color.RED);
        for (Point2D p : visiblePts){
            gc2.setStroke(Color.RED);
            gc2.strokeOval(p.getX()-POINTSIZE/2, p.getY()-POINTSIZE/2, POINTSIZE, POINTSIZE);
            gc2.setStroke(Color.GRAY);
            gc2.strokeLine(centrer.getX(), centrer.getY(), p.getX(), p.getY());
        }
    }
}
