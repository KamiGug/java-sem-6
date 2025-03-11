import java.util.*;

//Tu wstaw zmodyfikowaną klasę przechowującą współrzędne punktu
public class Zadanie {
    private static void wypiszElementy(TreeSet<Wspolrzedna> zbior) {
        Iterator<Wspolrzedna> it = zbior.iterator();
        while (it.hasNext()) {
            System.out.println((it.next()).toString());
        }
    }

    public static void main(String[] args) {
        TreeSet<Wspolrzedna> zbior = new TreeSet<Wspolrzedna>();
        zbior.add(new Wspolrzedna(2, 3));
        zbior.add(new Wspolrzedna(-3, 0));
        zbior.add(new Wspolrzedna(-1, 2));
        zbior.add(new Wspolrzedna(-1, 2));
        zbior.add(new Wspolrzedna(-3, -2));
        wypiszElementy(zbior);
    }
}
