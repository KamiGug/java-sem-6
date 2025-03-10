import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
    private TextEditorVars vars = null;
    private FileMenu fileMenu;

    public MenuBar(TextEditorVars vars) {
        super();
        this.vars = vars;
        this.fileMenu = new FileMenu("File", vars);
        this.add(this.fileMenu);

    }
}
