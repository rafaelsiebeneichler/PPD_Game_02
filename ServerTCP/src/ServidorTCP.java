import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static final int PORTA = 5000;

    public static void main(String[] args) {

        String mensagem = "A vaca morreu ontem de noite";

        try {

            ServerSocket servidor = new ServerSocket(PORTA);
            System.out.println("Servidor ouvindo a porta: " + PORTA);

            while (true) {

                Socket cliente = servidor.accept();

                System.out.println("Cliente : " + cliente.getInetAddress().getHostAddress());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

                System.out.println("Limpando o buffer e enviando mensagem");
                saida.flush();
                saida.writeObject(mensagem);

                System.out.println("Recebendo a mensagem");
                String resposta = (String) entrada.readObject();

                System.out.println("O cliente respondeu:\n" + resposta);
                
                System.out.println("Conexão encerrada");

                saida.close();
                entrada.close();
                cliente.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}