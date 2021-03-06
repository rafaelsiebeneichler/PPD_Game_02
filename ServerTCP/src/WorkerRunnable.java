
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
            String received = (String) entrada.readObject();
            System.out.println("O cliente " + clientSocket.getInetAddress() + " enviou: " + received);
            String array[] = new String[3]; //criar um array de três posições
            array = received.split(";");

            String mensagem = "";
            if (array[0].equals("getMapa")) {
                mensagem = game.imprimirMatriz();
            } else if (array[0].equals("sorteiaLetra")) {
                char j = game.sorteiaLetra(); 
                mensagem = "" + j;
                game.sorteiaPosicao(j); //sorteia posição
            } else if (array[0].equals("movimento")) { 
                mensagem = game.moverJogador(array[1].charAt(0), array[2]);
            } else if (array[0].equals("atirar")) { 
                mensagem = game.atirarJogador(array[1].charAt(0));
            }

            System.out.println("Limpando o buffer e retornando cliente " + clientSocket.getInetAddress());
            saida.flush();
            saida.writeObject(mensagem);

            String strTime = String.format("%.4f", ((System.currentTimeMillis() - time) / 1000.000));
            System.out.println("Tempo para resposta: " + strTime + "s");

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
