import java.util.HashMap;
import java.util.Set;

public class SynchronicznaMapa {
    private HashMap<String, Integer> mapa = new HashMap<String, Integer>();

    public synchronized Integer odbierz(String klucz) {
        if (this.mapa.size() == 0) {
            return null;
        }
        return this.mapa.get(klucz);
    }

    public synchronized void wyslij(String klucz, Integer wartosc) {
        this.mapa.put(klucz, wartosc);
    }

    public synchronized Set<HashMap.Entry<String, Integer>> entrySet() {
        return mapa.entrySet();
    }
}
