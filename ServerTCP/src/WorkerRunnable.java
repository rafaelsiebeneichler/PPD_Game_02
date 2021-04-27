
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class WorkerRunnable implements Runnable {

    protected Socket clientSocket = null;
    protected Game game = null;

    public WorkerRunnable(Socket clientSocket, Game g) {
        this.clientSocket = clientSocket;
        this.game = g;
    }

    public void run() {
        try {
            long time = System.currentTimeMillis();
            ObjectOutputStream saida = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(clientSocket.getInputStream());
            String resposta = (String) entrada.readObject();
            System.out.println("O cliente " + clientSocket.getInetAddress() + " enviou: " + resposta);

            String mensagem = "";
            if (resposta.equals("getMapa")) {
                mensagem = game.imprimirMatriz();
            }

            System.out.println("Limpando o buffer e retornando cliente " + clientSocket.getInetAddress());
            saida.flush();
            saida.writeObject(mensagem);

            System.out.println("Tempo para resposta: " + ((System.currentTimeMillis() - time) / 1000.000) + "s");

            System.out.println("Conexão com cliente " + clientSocket.getInetAddress() + " encerrada");

            saida.close();
            entrada.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkerRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
