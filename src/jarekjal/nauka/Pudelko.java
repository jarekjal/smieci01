package jarekjal.nauka;

public class Pudelko<T> {

    private T ob;

    public Pudelko(T ob){
        this.ob = ob;
    }

    public T getOb(){
        return ob;
    }

    public void setOb(T ob){
        this.ob = ob;
    }

    public void showStoredType(){
        String result = this.ob.getClass().getName();
        System.out.println(result);
    }
}
