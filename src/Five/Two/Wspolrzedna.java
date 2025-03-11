import java.util.Objects;

public class Wspolrzedna {
    private int x, y;

    public Wspolrzedna(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != this.getClass()) {
            return false;
        }
        return this.equals((Wspolrzedna) other);
    }

    public boolean equals(Wspolrzedna other) {
        return this.x == other.x && this.y == other.y;
    }
}
