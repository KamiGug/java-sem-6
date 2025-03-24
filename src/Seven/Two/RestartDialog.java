import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RestartDialog extends JDialog  {
    private JFrame frame;

    public RestartDialog(JFrame frame) {
        this(
            frame, 
            "A restart of the game is needed."
        );
     }
    
    public RestartDialog(JFrame frame, String message) {
        super(frame, "THE END", true);
        this.frame = frame;
        setLayout(new BorderLayout());

        this.add(
            new JLabel("<html>" + message + "</html>", SwingConstants.CENTER), 
            BorderLayout.CENTER
        );
        
        this.add(
            new Button(
                "OK.", 
                e -> {
                    Klient.resetConnection();
                    this.setVisible(false);
                }
            ),
            BorderLayout.SOUTH
        );

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                dispose();
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(frame);
    }
}
