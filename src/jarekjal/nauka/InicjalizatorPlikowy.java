package jarekjal.nauka;

import java.util.ArrayList;
import java.util.List;

public class InicjalizatorPlikowy implements Inicjalizator{

    private String plik;

    public InicjalizatorPlikowy(String plik){
        this.plik = plik;
    }

    @Override
    public List<Towar> getStore() {


        return new ArrayList<Towar>();
    }
}
