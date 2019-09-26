package jarekjal.nauka;

public class CountController implements CountObserver {

    private CountModel model;

    public CountController(CountModel cm) {
        model = cm;
    }

    public String incrementButtonPressed() {
        model.updateValue(1);
        return "" + model.getValue();
    }

    public String decrementButtonPressed() {
        model.updateValue(-1);
        return "" + model.getValue();
    }

    @Override
    public void update(int count) {

    }
}
