package jarekjal.nauka;

public enum Owners implements OwnerStrategy {
    DOMESTIC(false, 0, "domestic" ), FOREIGN(true, 500, "foreign");

    private boolean isForeign;
    private int fee;
    private String msg;
    private Owners(boolean isForeign, int fee, String msg){
        this.isForeign = isForeign;
        this.fee = fee;
        this.msg = msg;
    }

    @Override
    public boolean isForeign() {
        return isForeign;
    }

    @Override
    public int fee() {
        return fee;
    }

    @Override
    public String toString(){
        return msg;
    }
}
