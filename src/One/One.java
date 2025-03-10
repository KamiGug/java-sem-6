import javax.swing.JOptionPane;

public class One {
    public static void main(String[] args) throws Exception {
        String input = (JOptionPane.showInputDialog(
                "Pass string to be turned to lower case")).toLowerCase();
        JOptionPane.showMessageDialog(null, input);
        System.exit(0);
    }
}
