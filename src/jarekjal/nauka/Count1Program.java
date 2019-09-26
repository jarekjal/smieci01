package jarekjal.nauka;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Count1Program extends Application {

    private int value = 0;
    private Label label;


    @Override
    public void start(Stage stage) throws Exception {
        Pane root = createWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Counter1");
        stage.show();
    }

    private Pane createWindow() {
        String text = "Counter value: ";
        label = new Label(text + value);
        Button buttonPlus = new Button("Increase");
        Button buttonMinus = new Button("Decrease");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, buttonPlus, buttonMinus);
        buttonPlus.setOnAction(event -> label.setText(text + (++value)));
        buttonMinus.setOnAction(event -> label.setText(text + (--value)));
        return vbox;
    }

    public static void main(String[] args){
        System.out.println("Program starting...");
        Application.launch(args);
        System.out.println("Program exiting...");
    }

}
