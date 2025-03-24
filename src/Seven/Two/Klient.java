import java.net.*;
import java.io.*;

// this is poorly written as presentation is closely mixed with logic 

public class Klient {
    static Socket gniazdo;
    static InputStream strumien;
    static BufferedReader bufor;
    static PrintWriter output;
    static boolean shouldContinue = true; 
    static String nazwahosta;
    static KlientOkno okno;
    static final int initialLeftMines = 71;
    static int leftMines = Klient.initialLeftMines; // could be better, like part of initail communication, and not a static var
    public static void main(String[] args) {
        if (args.length > 0) {
            Klient.nazwahosta = args[0];
        } else {
            Klient.nazwahosta = "localhost";
        }

        Klient.okno = new KlientOkno();

        if (Klient.startConnection() == false) {
            Klient.okno.showNoConnetionDialog();
        }
        while (shouldContinue) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) { }
        }
        Klient.closeConnection();
        System.exit(0);
    }

    public static boolean sendMineNumberAndCheckIfShouldLock(int i) {
        output.println(i + "");
        String tmp = null;
        try {
            tmp = bufor.readLine();
        } catch (IOException e) {
            Klient.okno.reset(i);
            return false;
        }
        if (tmp.contains("bum")) {
            Klient.lose();
            return false;
        }
        --(Klient.leftMines);
        if (Klient.leftMines > 0) {
            Klient.okno.update(i, tmp);
        } else {
            Klient.leftMines = 0;
            Klient.okno.update(i, tmp);
            Klient.win();
        }
        return true;
    }

    public static void resetConnection() {
        Klient.closeConnection();
        if (Klient.startConnection() == false) {
            Klient.okno.showNoConnetionDialog();
        }
    }

    public static void closeConnection() {
        if (Klient.output != null) {
            Klient.output.close();
            Klient.output = null;
        }
        if (Klient.bufor != null) {
            try {
                Klient.bufor.close();
            } catch (IOException e) { } 
            Klient.bufor = null;
        }
        if (Klient.strumien != null) {
            try {
                Klient.strumien.close();
            } catch (IOException e) { } 
            Klient.strumien = null;
        }
        if (Klient.gniazdo != null) {
            try {
                Klient.gniazdo.close();
            } catch (IOException e) { } 
            Klient.gniazdo = null;
        }
    }

    public static boolean startConnection() {
        Klient.leftMines = Klient.initialLeftMines;
        try {
            Klient.gniazdo = new Socket(Klient.nazwahosta, 9696);
            Klient.strumien = Klient.gniazdo.getInputStream();
            Klient.bufor = new BufferedReader(
                new InputStreamReader(Klient.strumien)
            );
            Klient.output = new PrintWriter(Klient.gniazdo.getOutputStream(), true);
            Klient.okno.reset();
            return Klient.bufor.readLine().contains("OK.");
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return false;
    }

    public static void win() {
        Klient.okno.showVictoryDialog();
        Klient.okno.reset();
    }

    public static void lose() {
        Klient.okno.showLossDialog();
        Klient.okno.reset();
    }
}
