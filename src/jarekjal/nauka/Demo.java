package jarekjal.nauka;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Demo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DemoModel model = new DemoModel();
        DemoController controller = new DemoController(model);
        DemoView view = new DemoView(controller);

        Pane root = view.getRoot();
        primaryStage.setTitle("Demo");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
