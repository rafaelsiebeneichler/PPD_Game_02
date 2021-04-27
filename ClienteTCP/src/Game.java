
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafaelsiebeneichler
 */
public class Game {

    private final JFrame frame = new JFrame("Labirint Warzone - TCP");
    private GameSettings gs = new GameSettings();
    private GameZone gz;
    private Echo conn;

    public void setGameSettings(GameSettings gs) {
        this.gs = gs;
        this.gz.setGameSettings(gs);
    }

    public Game() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gz = new GameZone();
        gz.setPreferredSize(new Dimension(this.gs.getWidth(), this.gs.getHeight()));
        gz.setGameSettings(gs);
        frame.getContentPane().add(gz);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_P:
                        break;
                    case KeyEvent.VK_RIGHT:
                        break;
                    case KeyEvent.VK_LEFT:
                        break;
                    case KeyEvent.VK_UP:
                        break;
                    case KeyEvent.VK_DOWN:
                        break;
                    case KeyEvent.VK_ESCAPE:
                        break;
                    case KeyEvent.VK_SPACE:
                        break;
                    case KeyEvent.VK_S:
                        break;
                    case KeyEvent.VK_L:
                        break;
                    case KeyEvent.VK_CONTROL:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        break;
                    case KeyEvent.VK_LEFT:
                        break;
                    case KeyEvent.VK_UP:
                        break;
                    case KeyEvent.VK_DOWN:
                        break;
                    case KeyEvent.VK_ESCAPE:
                        break;
                    case KeyEvent.VK_SPACE:
                        break;
                    case KeyEvent.VK_P:
                        break;
                    case KeyEvent.VK_S:
                        break;
                    case KeyEvent.VK_L:
                        break;
                    case KeyEvent.VK_CONTROL:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
        conn = new Echo();
        try {
            init();
        } catch (IOException | ClassNotFoundException e) {

        }
        desenha();
    }

    private void init() throws IOException, ClassNotFoundException {
        String lLetra = conn.Echo("sorteiaLetra;");
        gs.setLetraJogador(lLetra);
        String lMapa = conn.Echo("getMapa;");
        gs.readStringMap(lMapa);
    }

    private void desenha() {
        frame.repaint();
        try {
            Thread.sleep(45);
        } catch (java.lang.InterruptedException e) {
        }
    }
}
