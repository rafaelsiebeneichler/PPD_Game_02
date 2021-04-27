
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP {

    public static final int PORTA = 5000;
    private static Game g;
    private static GameSettings gs;

    public static String Echo(String comando) throws IOException, ClassNotFoundException {
        Socket cliente = new Socket("127.0.0.1", PORTA);

        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

        saida.writeObject(comando);
        String mens = (String) entrada.readObject();

        entrada.close();
        saida.close();
        cliente.close();
        return mens;
    }

    public static void main(String[] args) {
        try {
            g = new Game();
            gs = new GameSettings();
            g.setGameSettings(gs);

            String lLetra = Echo("sorteiaLetra;");
            String lMapa = Echo("getMapa;");            
            gs.readStringMap(lMapa);
            g.desenha();

            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
