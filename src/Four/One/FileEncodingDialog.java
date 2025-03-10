import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JDialog;

public class FileEncodingDialog extends JDialog {
    final static private String[] AVAILABLE_ENCODINGS = { "UTF8", "ISO8859-2", "Cp1250" };

    private JFrame frame;
    private TextEditorVars vars;
    private JLabel filePathLabel;
    private JTextField filePathField;
    private Button filePathPickerButton;
    private JLabel encodingLabel;
    private JComboBox encodingSelect;

    public FileEncodingDialog(JFrame frame, TextEditorVars vars, String title) {
        super(frame, title, true);
        this.frame = frame;
        this.vars = vars;
        this.fill();
        this.pack();
    }

    public FileEncodingDialog(JFrame frame, TextEditorVars vars) {
        this(frame, vars, "Pick a file");
    }

    public void fill() {
        this.filePathLabel = new JLabel("Select File:");
        this.encodingLabel = new JLabel("Select Encoding:");

        this.filePathField = new JTextField(32);
        if (this.vars.filePath != null && this.vars.filePath.length() > 0) {
            this.filePathField.setText(this.vars.filePath);
        }

        this.filePathPickerButton = new Button(
                "Choose...",
                e -> {
                    String filePath = FileHelper.chooseFile(vars.currentTextEditor.getFrame());
                    if (filePath.length() > 0) {
                        this.filePathField.setText(filePath);
                    }
                },
                vars);

        this.encodingSelect = new JComboBox<>(AVAILABLE_ENCODINGS);
        if (this.vars.encoding != null && this.vars.encoding.length() > 0) {
            this.encodingSelect.setSelectedItem(this.vars.encoding);
        }

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); // like margin: 5px
        constraints.fill = GridBagConstraints.HORIZONTAL; // like grow on row flex

        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(this.filePathLabel, constraints);

        constraints.gridx++;
        mainPanel.add(this.filePathField, constraints);

        constraints.gridx++;
        mainPanel.add(this.filePathPickerButton, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        mainPanel.add(this.encodingLabel, constraints);

        constraints.gridx++;
        mainPanel.add(this.encodingSelect, constraints);

        this.getContentPane().add(mainPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(new Button(
                "OK",
                e -> {
                    this.vars.filePath = filePathField.getText();
                    this.vars.encoding = (String) encodingSelect.getSelectedItem();
                    dispose();
                },
                this.vars));
        buttonPanel.add(new Button(
                "Cancel",
                e -> {
                    dispose();
                },
                this.vars));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

}
