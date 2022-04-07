import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {

    public static final Integer port = 9001;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientContent = input.readLine();
                System.out.println(clientContent);
                PrintStream out = new PrintStream(socket.getOutputStream());
                String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
                out.println("open");

                out.close();
                input.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
