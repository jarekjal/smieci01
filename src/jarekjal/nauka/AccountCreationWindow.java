package jarekjal.nauka;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AccountCreationWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = createNodeHierarchy();
        stage.setScene(new Scene(root));
        stage.setTitle("Bank Account Demo");
        stage.show();
        printAllNodes(root);
        System.out.println(getWidestControl(root));
    }

    private Pane createNodeHierarchy() {
        VBox p3 = new VBox(8);
        p3.setAlignment(Pos.CENTER);
        p3.setPadding(new Insets(10));
        p3.setBackground(
                new Background(
                        new BackgroundFill(Color.SKYBLUE,
                                new CornerRadii(20), new Insets(0))));
        p3.setId("VBox p3");
        Label type = new Label("Select Account Type:");
        type.setId("Label type");
        ChoiceBox<String> chbx = new ChoiceBox<>();
        chbx.setId("ChoiceBox chbx");
        chbx.getItems().addAll("Savings", "Checking",
                "Interest Checking");
        p3.getChildren().addAll(type, chbx);
        VBox p4 = new VBox(8);
        p4.setId("VBox p4");
        p4.setAlignment(Pos.CENTER);
        p4.setPadding(new Insets(10));
        CheckBox ckbx = new CheckBox("foreign owned?");
        Button btn = new Button("CREATE ACCT");
        btn.setId("Button btn");
        p4.getChildren().addAll(ckbx, btn);
        HBox p2 = new HBox(8);
        p2.setAlignment(Pos.CENTER);
        p2.setPadding(new Insets(10));
        p2.getChildren().addAll(p3, p4);
        p2.setId("HBox p2");
        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER);
        p1.setPadding(new Insets(10));
        p1.setId("VBox p1");
        Label title = new Label("Create a New Bank Account");
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        title.setTextFill(Color.GREEN);
        title.setId("Label title");
        p1.getChildren().addAll(title, p2);
        btn.setOnAction(event -> {
            String foreign = ckbx.isSelected() ? "Foreign " : "";
            String acct = chbx.getValue();
            title.setText(foreign + acct + " Account Created");
        });
        return p1;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void printAllNodes(Node n) {
        printNodeSize(n);
        if (n instanceof Pane) {
            Pane p = (Pane) n;
            for (Node child : p.getChildren()) {
                printAllNodes(child);
            }
        }
    }

    private Node getWidestControl(Node n) {
        if (n instanceof Control)
            return n;
        Node widest = null;
        int maxwidth = -1;
        Pane p = (Pane) n;
        for (Node child : p.getChildren()) {
            if(!(child instanceof Control)){
                getWidestControl(child);
            } else {
                Control c = (Control) child;
                int w = (int) c.getLayoutBounds().getWidth();
                if (w > maxwidth) {
                    maxwidth = w;
                    widest = child;
                }
            }
        }
        return widest;
    }

    private void printNodeSize(Node n) {
        Bounds bounds = n.getLayoutBounds();
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();
        System.out.println(n.getId() + " w: " + width + " h: " + height);
    }

}
