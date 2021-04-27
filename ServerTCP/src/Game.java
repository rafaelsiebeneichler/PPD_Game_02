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
    
    /* MATRIZ HELP
    . = chão
    - = parede
    * = tiro
    A-Z = Campeão
    a-z = bot
    */

    //MATRIZ
    private int getAltura = 20;
    private int getLargura = 20;
    private char[][] getMatriz = new char[getAltura][getLargura];

    public Game() {
        preencheLabirinto1();
        // System.out.println(imprimirMatriz());
    }

    public void preencheMatriz() {
        for (int i = 0; i < getAltura; i++) {
            for (int j = 0; j < getLargura; j++) {
                getMatriz[i][j] = '.';
            }
        }
    }

    public String imprimirMatriz() {
        String matriz = "";
        for (int i = 0; i < getAltura; i++) {
            for (int j = 0; j < getLargura; j++) {
                matriz = matriz + getMatriz[i][j] + "\t";
            }
            matriz = matriz + '\n';
        }
        return matriz;
    }

    public void preencheLabirinto1() {
        preencheMatriz();
        getMatriz[2][2] = '-';
        getMatriz[2][3] = '-';
        getMatriz[2][4] = '-';
        getMatriz[2][5] = '-';
        getMatriz[2][6] = '-';
        getMatriz[3][2] = '-';
        getMatriz[4][2] = '-';
        getMatriz[5][2] = '-';
        getMatriz[6][2] = '-';

        getMatriz[2][13] = '-';
        getMatriz[2][14] = '-';
        getMatriz[2][15] = '-';
        getMatriz[2][16] = '-';
        getMatriz[2][17] = '-';
        getMatriz[3][17] = '-';
        getMatriz[4][17] = '-';
        getMatriz[5][17] = '-';
        getMatriz[6][17] = '-';

        getMatriz[17][2] = '-';
        getMatriz[17][3] = '-';
        getMatriz[17][4] = '-';
        getMatriz[17][5] = '-';
        getMatriz[17][6] = '-';
        getMatriz[16][2] = '-';
        getMatriz[15][2] = '-';
        getMatriz[14][2] = '-';
        getMatriz[13][2] = '-';

        getMatriz[17][13] = '-';
        getMatriz[17][14] = '-';
        getMatriz[17][15] = '-';
        getMatriz[17][16] = '-';
        getMatriz[17][17] = '-';
        getMatriz[16][17] = '-';
        getMatriz[15][17] = '-';
        getMatriz[14][17] = '-';
        getMatriz[13][17] = '-';
    }

}
