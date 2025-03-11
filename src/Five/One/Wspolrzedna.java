public class Wspolrzedna implements Comparable<Wspolrzedna> {
    private int x, y;

    public Wspolrzedna(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Wspolrzedna other) {
        if (this.x < other.x) {
            return -1;
        }
        if (this.x > other.x) {
            return 1;
        }
        if (this.y < other.y) {
            return -1;
        }
        if (this.y > other.y) {
            return 1;
        }
        return 0;
    }
}
