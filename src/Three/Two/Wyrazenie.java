class Wyrazenie {
    private Wierzcholek korzen;

    private Wierzcholek utworzDrzewo(String w, int p, int q) {
        if (p == q)
            return new Stala(Character.digit(w.charAt(p), 10));
        else {
            int i = p + 1, nawiasy = 0;
            while ((nawiasy != 0)
                    || (w.charAt(i) == Consts.OPEN_PAR)
                    || (w.charAt(i) == Consts.CLOSE_PAR)
                    || (Character.isDigit(w.charAt(i)))) {
                if (w.charAt(i) == Consts.OPEN_PAR) {
                    ++nawiasy;
                }
                if (w.charAt(i) == Consts.CLOSE_PAR) {
                    --nawiasy;
                }
                ++i;
            }
            Dzialanie nowy = new Dzialanie(w.charAt(i));
            // if (q == 0 || p == w.length() - 1) {
            // throw new
            // }
            nowy.dodajLewyArg(utworzDrzewo(w, p + 1, i - 1));
            nowy.dodajPrawyArg(utworzDrzewo(w, i + 1, q - 1));
            return nowy;
        }
    }

    public Wyrazenie(String w) {
        // if ()
        korzen = utworzDrzewo(w, 0, w.length() - 1);
    }

    public int oblicz() {
        return korzen.wartosc();
    }
}
