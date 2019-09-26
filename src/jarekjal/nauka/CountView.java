package jarekjal.nauka;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CountView {

    private CountController controller;
    private Pane root;
    private Label label;
    private static final String labelText = "Counter value: ";

    public CountView(CountController c){
        controller = c;
        root = createWindow();
    }

    public Pane getRoot(){
        return root;
    }

    private Pane createWindow(){
        label = new Label(labelText);
        Button buttonPlus = new Button("Increase");
        Button buttonMinus = new Button("Decrease");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, buttonPlus, buttonMinus);
        buttonPlus.setOnAction(event -> label.setText(labelText + controller.incrementButtonPressed()));
        buttonMinus.setOnAction(event -> label.setText(labelText + controller.decrementButtonPressed()));
        return vbox;
    }

}
