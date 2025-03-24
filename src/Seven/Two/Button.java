import java.util.function.Consumer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
    protected final static String emptyName = "";
    private Consumer<ActionEvent> callback;

    public Button(String s) {
        this(s, null);
    }

    public Button(String s, Consumer<ActionEvent> fn) {
        super (s);
        this.callback = fn;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (this.callback != null) {
            this.callback.accept(e);
        }
    }

    public void setCallback(Consumer<ActionEvent> fn) {
        if (fn != null) {
            this.callback = fn;
        }
    }
}
