package jarekjal.nauka;

@FunctionalInterface
public interface WarunekFunc<T> {
    public boolean warunekSpelniony(T e);
}
