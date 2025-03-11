import java.util.ArrayList;

import javax.swing.*;

class Cenzor extends Thread {
    JTextArea okno;
    volatile boolean zakonczyc;
    StringBuffer messageBuilder;
    private ArrayList<String> foundBadWords = new ArrayList<String>();
    public static final String[] BAD_WORDS = {
            "cholera", "cholibka"
    };

    public Cenzor(JTextArea comp) {
        okno = comp;
        zakonczyc = false;
    }

    public void run() {
        while (!zakonczyc) {
            try {
                sleep(10000);
                this.foundBadWords.clear();
                String tekst = (okno.getText()).toLowerCase();
                for (String badWord : BAD_WORDS) {
                    if (tekst.contains(badWord)) {
                        this.foundBadWords.add(badWord);
                    }
                }
                if (foundBadWords.size() > 0) {
                    this.messageBuilder = new StringBuffer();
                    this.messageBuilder.append("Your message contains bad words, like: ");
                    for (String badWord : foundBadWords) {
                        this.messageBuilder.append(badWord);
                        this.messageBuilder.append(", ");
                    }
                    this.messageBuilder.delete(
                            this.messageBuilder.length() - 2,
                            this.messageBuilder.length());
                    this.messageBuilder.append(".");
                    JOptionPane.showMessageDialog(
                            null,
                            this.messageBuilder.toString(),
                            "BAD WORDS DETECTED",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
            }
        }
    }
}
