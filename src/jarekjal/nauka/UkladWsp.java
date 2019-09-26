package jarekjal.nauka;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class UkladWsp extends Application {

    private Canvas canvas;

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = createGraph();
        drawCoordinates();
        stage.addEventHandler(KeyEvent.KEY_TYPED, ke -> System.out.println(ke.getCharacter()));
        stage.setScene(new Scene(root));
        stage.setTitle("Graph");
        stage.show();
    }

    private void drawCoordinates() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(canvasWidth/2, 0, canvasWidth/2, canvasHeight);
        gc.strokeLine(0, canvasHeight/2, canvasWidth, canvasHeight/2);
    }

    private Pane createGraph() {
        Pane vBox = new VBox();
        canvas = new Canvas(800, 600);
        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, mouseEvent -> {
            System.out.println("" + mouseEvent.getSceneX() + " , " + mouseEvent.getSceneY());
            canvas.getGraphicsContext2D().fillOval(mouseEvent.getSceneX(),mouseEvent.getSceneY(),2,2);
        });
        vBox.getChildren().add(canvas);
        return vBox;
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
