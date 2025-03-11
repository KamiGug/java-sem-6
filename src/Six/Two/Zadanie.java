import java.util.Map;

public class Zadanie {
    public static void main(String args[]) {
        KolejkaKomunikatow k = new KolejkaKomunikatow();
        SynchronicznaMapa mapa = new SynchronicznaMapa();
        Watek w1 = new Watek(k, 1);
        Watek w2 = new Watek(k, 2);
        WatekMapa w3 = new WatekMapa(mapa, 1);
        WatekMapa w4 = new WatekMapa(mapa, 2);
        w1.start();
        w2.start();
        w3.start();
        w4.start();
        try {
            w1.join();
            w2.join();
            w3.join();
            w4.join();
        } catch (InterruptedException e) {
        }

        Object ob = k.odbierz();
        while (ob != null) {
            System.out.println(((Integer) ob).toString());
            ob = k.odbierz();
        }

        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
