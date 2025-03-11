import java.util.*;

public class Zadanie {
    public static void main(String[] args) {
        HashMap<Wspolrzedna, String> mapa = new HashMap<Wspolrzedna, String>();
        mapa.put(new Wspolrzedna(2, 3), new String("czerwony"));
        mapa.put(new Wspolrzedna(-3, 0), new String("czarny"));
        mapa.put(new Wspolrzedna(-1, 2), new String("czerwony"));
        mapa.put(new Wspolrzedna(2, -1), new String("czarny"));
        Wspolrzedna w = new Wspolrzedna(-1, 2);
        System.out.println("Punkt " + w.toString()
                + " ma kolor " + mapa.get(w));
    }
}
