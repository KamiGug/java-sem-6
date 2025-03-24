import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ForceCloseDialog extends JDialog  {
    private JFrame frame;

    public ForceCloseDialog(final JFrame frame) {
        this(
            frame, 
            "The application is unable to proceed. Closing now."
        );
     }
    
    public ForceCloseDialog(final JFrame frame, String message) {
        super(frame, "WARNING", true);
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
                    this.frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    dispose();
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
