package jarekjal.nauka;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class WatchersView {

    private Pane root;
    private Label changes;
    private Label odd;
    private static final String text = "Zmian: ";
    private int cnt = 0;

    public WatchersView(){
        changes = new Label(text);
        odd = new Label();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(changes,odd);
        root = vBox;
    }

    public Pane getRoot(){
        return root;
    }

    public void notifyWatcher(int val){
        cnt++;
        changes.setText(text + cnt);
        odd.setText( val%2==0 ? "parzysta" : "nieparzysta");
    }
}
