package jarekjal.nauka;

public enum Domestic implements OwnerStrategy {
    INSTANCE;

    @Override
    public boolean isForeign() {
        return false;
    }

    @Override
    public int fee() {
        return 0;
    }

    @Override
    public String toString(){
        return "domestic";
    }
}
