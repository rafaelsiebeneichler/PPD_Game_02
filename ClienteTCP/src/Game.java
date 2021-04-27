
import java.awt.Color;
import java.awt.Dimension;
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

    public void setGameSettings(GameSettings gs) {
        this.gs = gs;
        this.gz.setGameSettings(gs);
    }

    public Game() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gz = new GameZone();
        gz.setPreferredSize(new Dimension(this.gs.getWidth(), this.gs.getHeight()));
        frame.getContentPane().add(gz);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);

        desenha();
    }

    public void desenha() {
        frame.repaint();
        try {
            Thread.sleep(45);
        } catch (java.lang.InterruptedException e) {
        }
    }
}
