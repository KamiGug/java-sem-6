import java.awt.Dimension;

public class MineButton extends Button {
    private int i;
    private boolean isActive = false;

    public MineButton(String s, int i) {
        super(s);
        this.setCallback(e -> {
            if (this.isActive) {
                this.isActive = !Klient.sendMineNumberAndCheckIfShouldLock(this.i);
            }
        });
        this.i = i;
        this.setPreferredSize(new Dimension(45, 45));
    }

    public MineButton(int i) {
        this(MineButton.emptyName, i);
    }

    public void reset() {
        this.setText(MineButton.emptyName);
        this.isActive = true;
    }

    public void setNumber(String number) {
        this.setText(number);
    }

    public void lock() {
        this.isActive = false;
    }
}
