/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafaelsiebeneichler
 */
public class GameSettings {

    private int pixelSize = 16;
    private int height = 320;
    private int width = 320;
    private String[][] map = new String[20][20];

    public void preencheMatriz() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = ".";
            }
        }
    }
    
    public GameSettings(){
        preencheMatriz();
    }

    public String[][] getMap() {
        return map;
    }

    public void readStringMap(String m) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == '\t') {
                y++;
            } else if (m.charAt(i) == '\n') {
                x++;
                y = 0;
            } else {
                map[x][y] = "" + m.charAt(i);
            }
        }
    }

    public String imprimirMatriz() {
        String matriz = "";
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                matriz = matriz + map[i][j] + "\t";
            }
            matriz = matriz + '\n';
        }
        return matriz;
    }

    public int getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(int pixelSize) {
        this.pixelSize = pixelSize;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
