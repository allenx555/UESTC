import java.io.*;
import java.net.*;

public class ClientChat {
    public static final Integer port = 9001;
    public static final String host = "127.0.0.1";

    public static void main(String []args) {
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());
            System.out.println("ready send info to server!!");
            out.println("HELLO WORLD!");
            System.out.println("send info to server: "+ "HELLO WORLD!");
            out.close();
            input.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    socket = null;
                }
            }
        }
    }
}
