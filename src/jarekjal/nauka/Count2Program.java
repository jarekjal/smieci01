package jarekjal.nauka;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Count2Program extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        CountModel m = new CountModel();
        CountController c = new CountController(m);
        CountView v = new CountView(c);
        WatchersController watchersController = new WatchersController(m);
        WatchersView wv = new WatchersView();
        watchersController.addWatchersView(wv);
        Pane p = new HBox();
        p.getChildren().addAll(v.getRoot(), wv.getRoot());
        stage.setScene(new Scene(p));
        stage.setTitle("Counter2");
        stage.show();
    }

    public static void main(String[] args){
        System.out.println("Program starting...");
        Application.launch(args);
        System.out.println("Program exiting...");
    }
}

