import javax.swing.JMenu;

public class FileMenu extends JMenu {
    TextEditorVars vars;

    public FileMenu(String s, TextEditorVars vars) {
        super(s);
        this.vars = vars;
        this.add(new MenuItem(
                "New...",
                e -> {
                    this.vars.currentTextEditor.clear();
                },
                this.vars));
        this.add(new MenuItem(
                "Open",
                e -> {
                    this.vars.currentTextEditor.openFile();
                },
                this.vars));
        this.add(new MenuItem(
                "Save",
                e -> {
                    this.vars.currentTextEditor.saveToFile();
                },
                this.vars));
        this.add(new MenuItem(
                "Save as...",
                e -> {
                    this.vars.currentTextEditor.saveAsToFile();
                },
                this.vars));
    }
}
