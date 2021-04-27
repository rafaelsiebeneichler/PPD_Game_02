
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafaelsiebeneichler
 */
public class GameZone extends JPanel {

    private GameSettings gs = new GameSettings();

    public void setGameSettings(GameSettings gs) {
        this.gs = gs;
    }

    public void paintComponent(Graphics g) {
        int width = getWidth() / gs.getPixelSize();
        int height = getHeight() / gs.getPixelSize();
        g.setColor(Color.black);

        if (gs.getMap().length > 0) {
            drawMsg(g, 1, 1, gs.getMap());
        }
        g.setColor(Color.black);

        /*if (gameOver) {
            drawMsg(g, 35, 35, game);
            drawMsg(g, 65, 35, over);

        }*/

 /*if (youWin) {
            drawMsg(g, 10, 10, you);
            drawMsg(g, 26, 20, win);
        }*/
        g.setColor(Color.lightGray);
        for (int i = 0; i < height; i++) {
            g.drawLine(0, i * gs.getPixelSize(), gs.getWidth() * gs.getPixelSize(), i * gs.getPixelSize());
        }

        for (int i = 0; i < width; i++) {
            g.drawLine(i * gs.getPixelSize(), 0, i * gs.getPixelSize(), gs.getHeight() * gs.getPixelSize());
        }

    }

    private void drawMsg(Graphics g, int x, int y, String[][] msg) {
        for (int i = 0; i < msg[0].length; i++) {
            for (int j = 0; j < msg.length; j++) {
                String pos = msg[j][i];
                if (pos.equals(".")) {
                    g.setColor(Color.gray);
                } else if (pos.equals("-")) {
                    g.setColor(Color.black);
                } else if (pos.equals(gs.getLetraJogador())) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.red);
                } 
                //g.drawOval((i + x) * gs.getPixelSize() - gs.getPixelSize(), (j + y) * gs.getPixelSize() - gs.getPixelSize(), gs.getPixelSize(), gs.getPixelSize());
                //g.fillOval((i + x) * gs.getPixelSize() - gs.getPixelSize(), (j + y) * gs.getPixelSize() - gs.getPixelSize(), gs.getPixelSize(), gs.getPixelSize());
                g.drawRect((i + x) * gs.getPixelSize() - gs.getPixelSize(), (j + y) * gs.getPixelSize() - gs.getPixelSize(), gs.getPixelSize(), gs.getPixelSize());
                g.fillRect((i + x) * gs.getPixelSize() - gs.getPixelSize(), (j + y) * gs.getPixelSize() - gs.getPixelSize(), gs.getPixelSize(), gs.getPixelSize());
            }
        }
    }
}
