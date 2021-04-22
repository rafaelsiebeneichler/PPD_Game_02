package server_game2;
import java.net.SocketException;

/**
 *
 * @author Rafa_
 */
public class Server {

    public static void main(String[] args) throws SocketException {

        new EchoServer().start(); //inicia o servidor

    }

}
