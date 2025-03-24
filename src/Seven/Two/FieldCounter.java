import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldCounter extends JPanel {
    private JLabel label;
    private JLabel counter;

    public FieldCounter() {
        super();
        this.label = new JLabel("Fields left before win:");
        this.add(this.label);
        this.counter = new JLabel(String.valueOf(Klient.initialLeftMines));
        this.add(this.counter);
    }

    public void update() {
        this.counter.setText(String.valueOf(Klient.leftMines));
    }

    public void reset() {
        this.counter.setText(String.valueOf(Klient.initialLeftMines));
    }

    public void setNumber(String number) {
        this.setName(number);
    }
}
