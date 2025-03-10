public class Kolejka {

    static final int N = 5;
    private Object[] tab;
    private int pocz, zaost, lbel;

    public Kolejka() {
        pocz = 0;
        zaost = 0;
        lbel = 0;
        tab = new Object[N];
    }

    void doKolejki(Object el) throws Przepelnienie {
        if (++lbel > N) {
            lbel = N;
            throw new Przepelnienie();
        }
        tab[zaost] = el;
        zaost = (zaost + 1) % N;
    }

    Object zKolejki() throws Niedomiar {
        if (--lbel < 0) {
            lbel = 0;
            throw new Niedomiar();
        }
        int ind = pocz;
        pocz = (pocz + 1) % N;
        return tab[ind];
    }
}
