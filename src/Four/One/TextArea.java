import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TextArea extends JScrollPane {
    JTextPane text = null;

    public TextArea() {
        super(new JTextPane());
        this.text = (JTextPane) this.getViewport().getView();
        this.text.setVisible(true);
        this.setVisible(true);
    }

    public String getText() {
        return this.text.getText();
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public void clear() {
        this.text.setText("");
    }
}
