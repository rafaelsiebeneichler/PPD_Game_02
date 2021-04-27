
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafaelsiebeneichler
 */
public class Echo {

    private final String SERVER_IP = "127.0.0.1";
    private final int PORTA = 5000;

    public String Echo(String comando) {
        Socket cliente;
        String mens = "";
        try {
            cliente = new Socket(SERVER_IP, PORTA);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

            saida.writeObject(comando);
            mens = (String) entrada.readObject();

            entrada.close();
            saida.close();
            cliente.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Echo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mens;
    }

}
