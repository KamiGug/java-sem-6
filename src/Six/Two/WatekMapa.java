import java.nio.charset.Charset;
import java.util.Random;

class WatekMapa extends Thread {
    private SynchronicznaMapa mapa;
    private int istart;
    private final int MIN_LEN = 3;
    private final int MAX_LEN = 10;
    private Random rand = new Random();

    public WatekMapa(SynchronicznaMapa mapa, int istart) {
        this.mapa = mapa;
        this.istart = istart;
    }

    public void run() {
        try {
            for (int i = istart; i <= 10; i += 2) {
                mapa.wyslij(this.getRandomString(), new Integer(i));
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
        }
    }

    private String getRandomString() {
        int len = rand.nextInt((this.MAX_LEN - this.MIN_LEN) + 1) + this.MIN_LEN;
        byte[] array = new byte[len];
        rand.nextBytes(array);
        int leftLimit = 'a'; // letter 'a'
        int rightLimit = 'z'; // letter 'z'
        StringBuilder buffer = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int randomLimitedInt = leftLimit + (int) (this.rand.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
