import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP {

    public static final int PORTA = 5000;

    public static void main(String[] args) {
        try {
            Game g = new Game();  
            GameSettings gs = new GameSettings();
            g.setGameSettings(gs);
                        
            Socket cliente = new Socket("127.0.0.1", PORTA);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

            String aviso = "getMapa";
            saida.writeObject(aviso);
            
            String mens = (String) entrada.readObject();
            gs.readStringMap(mens);
            g.desenha();
            System.out.println("Mapa: ");
            System.out.println(mens);
            System.out.println("Mapa releito: ");
            System.out.println(gs.imprimirMatriz());

            entrada.close();
            saida.close();
            cliente.close();

            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}