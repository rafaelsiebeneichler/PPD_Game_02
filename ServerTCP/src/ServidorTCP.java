
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static final int PORTA = 5000;

    public static void main(String[] args) {

        try {
            MultiThreadedServer server = new MultiThreadedServer(PORTA);
            new Thread(server).start();

            System.out.println("Servidor ouvindo a porta: " + PORTA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
