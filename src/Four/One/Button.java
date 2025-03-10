import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
    TextEditorVars vars;
    Consumer<ActionEvent> callback;

    public Button(String s, Consumer<ActionEvent> fn) {
        this(s, fn, null);
    }

    public Button(String s, Consumer<ActionEvent> fn, TextEditorVars vars) {
        super(s);
        this.vars = vars;
        this.callback = fn;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        this.callback.accept(e);
    }
}
