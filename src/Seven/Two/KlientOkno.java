import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KlientOkno {
    private JFrame frame;
    private PanelMin mines;
    private JPanel menuBar;
    private FieldCounter fieldCounter;
    private ForceCloseDialog noConnetionDialog;
    private RestartDialog victoryDialog;
    private RestartDialog lossDialog;

    public KlientOkno() {
        this.start();
    }

    public void start() {
        this.frame = new JFrame();
        this.setTitle("Mine Sweeper");
        this.fill();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.noConnetionDialog = new ForceCloseDialog(frame, "No connection! Please make sure the server is running.");
        this.victoryDialog = new RestartDialog(this.frame, "You have won!");
        this.lossDialog = new RestartDialog(this.frame, "You have exploded!");
        
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void fill() {
        this.frame.setLayout(new BorderLayout());
        this.menuBar = new JPanel();

        this.fieldCounter = new FieldCounter();
        this.menuBar.add(this.fieldCounter);

        this.menuBar.add(new ResetButton());
        this.frame.add(this.menuBar, BorderLayout.NORTH);

        this.mines = new PanelMin(frame);
        
        this.frame.add(this.mines, BorderLayout.CENTER);
    }

    public void setTitle(String title) {
        this.frame.setTitle(title);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    // bad practice - should use observer pattern!
    public void reset() {
        this.fieldCounter.reset();
        this.mines.reset();
    }

    public void reset(int fieldId) {
        this.fieldCounter.update();
        this.mines.reset(fieldId);
    }

    // bad practice - should use observer pattern!
    public void update(int fieldId, String newNumber) {
        this.fieldCounter.update();
        this.mines.update(fieldId, newNumber);
    }

    public void showNoConnetionDialog() {
        this.noConnetionDialog.setVisible(true);
    }

    public void showVictoryDialog() {
        this.victoryDialog.setVisible(true);
    }

    public void showLossDialog() {
        this.lossDialog.setVisible(true);
    }

    public void lock() {
        this.mines.lock();
    }
}
