import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelMin extends JPanel {
    private JFrame frame;
    private MineButton[][] buttons;

    public PanelMin(JFrame frame) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(1, 1, 1, 1);
        this.frame = frame;
        buttons = new MineButton[9][];
        int n = 1;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new MineButton[9];
            constraints.gridx = 0;
            constraints.gridy = i;
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new MineButton("", n++);
                constraints.gridx++;
                this.add(buttons[i][j], constraints);
            }
        }
    }

    public void reset() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].reset();
            }
        }
    }

    public void reset(int i) {
        i--;
        int x = i / 9;
        int y = i % 9;
        buttons[x][y].reset();
    }

    public void update(int i, String newNumber) {
        i--;
        int x = i / 9;
        int y = i % 9;
        buttons[x][y].setNumber(newNumber);
    }

    public void lock() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].lock();
            }
        }
    }

}
