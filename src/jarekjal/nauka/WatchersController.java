package jarekjal.nauka;

public class WatchersController implements CountObserver{

    private CountModel model;
    private WatchersView watchersView;

    public WatchersController(CountModel m){
        model = m;
        model.addObserver(this);
    }

    public void addWatchersView(WatchersView v){
        watchersView = v;
    }

    @Override
    public void update(int count) {
        watchersView.notifyWatcher(count);
    }
}
