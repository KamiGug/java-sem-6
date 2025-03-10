class Dzialanie extends Wierzcholek {
    private char op; // operator +, -, / lub *

    public Dzialanie(char znak) {
        op = znak;
    }

    public void dodajLewyArg(Wierzcholek arg) {
        lewy = arg;
    }

    public void dodajPrawyArg(Wierzcholek arg) {
        prawy = arg;
    }

    public int wartosc() {
        switch (op) {
            case Consts.PLUS: {
                return lewy.wartosc() + prawy.wartosc();
            }
            case Consts.MINUS: {
                return lewy.wartosc() - prawy.wartosc();
            }
            case Consts.DIV: {
                int prawyWartosc = prawy.wartosc();
                // if (prawyWartosc == 0) {
                // throw new ArithmeticException();
                // }
                return lewy.wartosc() / prawyWartosc;
            }
            case Consts.MUL: {
                return lewy.wartosc() * prawy.wartosc();
            }
        }
        return 0;
    }
}
