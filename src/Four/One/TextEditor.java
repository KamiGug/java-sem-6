import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextEditor {
    private JFrame frame;
    private JPanel panel;
    private TextArea textArea;
    private MenuBar topMenu;
    private TextEditorVars vars;

    public TextEditor() {
        this.start();
    }

    public void start() {
        this.vars = new TextEditorVars();
        this.vars.currentTextEditor = this;
        this.frame = new JFrame();
        this.setTitle("new");
        this.fill();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setMinimumSize(new Dimension(500, 300));
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void fill() {
        this.textArea = new TextArea();
        this.vars.currentTextArea = this.textArea;
        this.frame.setLayout(new BorderLayout());

        this.topMenu = new MenuBar(this.vars);
        this.frame.setJMenuBar(this.topMenu);

        this.frame.add(this.textArea, BorderLayout.CENTER);
    }

    public void setTitle(String title) {
        this.frame.setTitle(title);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public void clear() {
        this.textArea.clear();
        this.vars.filePath = null;
        this.vars.encoding = null;
        this.setTitle("new");
    }

    public void saveToFile() {
        if (this.vars.filePath == null || this.vars.encoding == null) {
            this.saveAsToFile();
            return;
        }
        justSave();
    }

    public void saveAsToFile() {
        (new FileEncodingDialog(this.frame, this.vars, "Save as")).setVisible(true);
        if (justSave()) {
            this.setTitle(this.vars.filePath);
        }
    }

    public void openFile() {
        (new FileEncodingDialog(this.frame, this.vars, "Open file")).setVisible(true);
        if (justOpen()) {
            this.setTitle(this.vars.filePath);
        }

    }

    public boolean justOpen() {
        boolean success = false;
        try {
            String content = FileHelper.read(
                    this.vars.filePath,
                    this.vars.encoding);
            this.vars.currentTextArea.setText(content);
            success = true;
        } catch (IllegalArgumentException e) {
        } catch (UnsupportedEncodingException e) {
            System.err.println("Bad encoding string!");
        } catch (IOException e) {
            System.err.println("Unable to write to file!");
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
        return success;

    }

    public boolean justSave() {
        boolean success = false;
        try {
            FileHelper.save(
                    this.vars.filePath,
                    this.vars.encoding,
                    this.textArea.getText());
            success = true;
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file!");
        } catch (UnsupportedEncodingException e) {
            System.err.println("Bad encoding string!");
        } catch (IOException e) {
            System.err.println("Unable to write to file!");
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
        return success;
    }
}
