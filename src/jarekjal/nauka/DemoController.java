package jarekjal.nauka;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

import java.util.Iterator;
import java.util.List;

public class DemoController implements DemoObserver {

    private DemoModel model;
    private DemoView view;

    public void setView(DemoView v){
        view = v;
        model.addObserver(this);
    }

    public DemoController(DemoModel m){
        model = m;
    }

    public void btn1Pressed() {
        model.start();
    }

    public void btn2Pressed() {
        model.clear();
    }


    @Override
    public void update(Iterator<Odcinek> it) {
        view.draw(it);
    }

    public void canvas2MouseMoved(MouseEvent mouseEvent) {
        Point2D mousePoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());

        VisibleObjects vo = model.getVisiblePoints(new OdcinekIterator(mousePoint, 360, 200.0));

        view.drawPoints(mousePoint, vo.getVisiblePoints(), vo.getScanLines());
    }
}
