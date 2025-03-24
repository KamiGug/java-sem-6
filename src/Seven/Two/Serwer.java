import java.net.*;
import java.io.*;

public class Serwer {
    static Integer port = 9696;

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(Serwer.port);
            System.out.println("Server started at port " + Serwer.port);
            while (true) {
                Socket polaczenie = server.accept();
                Thread t = new Thread(
                        new Gracz(polaczenie));
                t.start();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}