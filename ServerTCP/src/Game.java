
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.Map;
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

    class Shot implements Runnable {

        private int x, y;
        private char direcao, jogador;
        private char[][] map;

        public Shot(int x, int y, char direcao, char jogador) {
            this.x = x;
            this.y = y;
            this.direcao = direcao;
            this.jogador = jogador;
            this.map = map;
        }

        private Boolean verificarShot(int x, int y, int xa, int ya) {
            Boolean lHit = false;
            Boolean lTemLetra = false;
            char lJogador = ' ';
            for (int i = 0; i < letras.length; i++) {
                if (!lTemLetra) {
                    lTemLetra = getMatriz[x][y] == letras[i];
                    lJogador = letras[i];
                }
            }
            if (lTemLetra) {
                jogadores.get(lJogador).morreu = true;
                getMatriz[xa][ya] = '.';
                getMatriz[x][y] = '.';
                lHit = true;
            } else if (getMatriz[x][y] == '-') {
                getMatriz[xa][ya] = '.';
                lHit = true;
            } else {
                getMatriz[xa][ya] = '.';
                getMatriz[x][y] = '*';
            }
            return lHit;
        }

        @Override
        public void run() {
            jogadores.get(jogador).lastTimeShot = System.currentTimeMillis();
            if (this.direcao == 'w') {
                x = x - 1;
            } else if (this.direcao == 's') {
                x = x + 1;
            } else if (this.direcao == 'a') {
                y = y - 1;
            } else if (this.direcao == 'd') {
                y = y + 1;
            }
            int lCount = 0;
            try {
                Boolean lHit = false;
                while (lHit == false) {
                    if (this.direcao == 'w') {
                        if (x > 0) {
                            lHit = verificarShot(x - 1, y, x, y);
                            x = x - 1;
                        } else {
                            getMatriz[x][y] = '.';
                            lHit = true;
                        }
                    } else if (this.direcao == 's') {
                        if (x < (getAltura - 1)) {
                            lHit = verificarShot(x + 1, y, x, y);
                            x = x + 1;
                        } else {
                            getMatriz[x][y] = '.';
                            lHit = true;
                        }
                    } else if (this.direcao == 'a') {
                        if (y > 0) {
                            lHit = verificarShot(x, y - 1, x, y);
                            y = y - 1;
                        } else {
                            getMatriz[x][y] = '.';
                            lHit = true;
                        }
                    } else if (this.direcao == 'd') {
                        if (y < (getLargura - 1)) {
                            lHit = verificarShot(x, y + 1, x, y);
                            y = y + 1;
                        } else {
                            getMatriz[x][y] = '.';
                            lHit = true;
                        }
                    }
                    sleep(100);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class Jogador {

        char jogador = ' ';
        boolean morreu = false;
        long lastTimeShot = 0;
        char direcao = ' ';
        int jogoAtual = 0;
        int killCountPlayers = 0;
        int killCountBots = 0;
        int vitorias = 0;
        int derrotas = 0;
        int qtdJogos = 0;
        int x = 9999;
        int y = 9999;
        String inetAdress = "Unknow";
        long timeLastMove = 0;

        public Jogador(char letra, int nJogo) {
            jogador = letra;
            jogoAtual = nJogo;
            timeLastMove = System.currentTimeMillis();
        }
    }

    private char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; //vetor de letras para os jogadores
    private Map<Character, Jogador> jogadores = new HashMap<Character, Jogador>(); //map de jogadores
    private int contLetraHeroi = 0;
    private int numJogo = 0;

    public Game() {
        preencheLabirinto1();
        // System.out.println(imprimirMatriz());
    }

    public char sorteiaLetra() {
        char jogador = '&';
        for (int i = contLetraHeroi; i < letras.length; i++) {
            contLetraHeroi++;
            jogador = letras[i];
            jogadores.put(jogador, new Jogador(jogador, numJogo));
            return jogador;
        }
        return jogador;
    }

    public void sorteiaPosicao(char jogador) {
        jogadores.get(jogador).qtdJogos = jogadores.get(jogador).qtdJogos + 1;
        int linha = 0 + (int) (Math.random() * (getAltura - 1)); //sorteia número da linha
        jogadores.get(jogador).x = linha;
        int coluna = 0 + (int) (Math.random() * (getLargura - 1)); //sorteia número da coluna
        jogadores.get(jogador).y = coluna;
        while (getMatriz[linha][coluna] != '.') { //se a posição sorteada for diferente de chão limpo, sorteia novamente
            linha = 0 + (int) (Math.random() * (getAltura - 1)); //sorteia número da linha
            jogadores.get(jogador).x = linha;
            coluna = 0 + (int) (Math.random() * (getLargura - 1)); //sorteia número da coluna
            jogadores.get(jogador).y = coluna;
        }
        getMatriz[linha][coluna] = jogador; //coloca jogador na posição sorteada (linha e coluna)
    }

    public String moverJogador(char jogador, String comando) {
        String ret = "OK";
        if (jogadores.get(jogador).morreu) {
            return "MORREU";
        }
        comando = comando.toLowerCase();
        int x = jogadores.get(jogador).x;
        int y = jogadores.get(jogador).y;
        if (comando.equals("w")) {
            if (x > 0) {
                ret = verificarJogador(x - 1, y, jogador, x, y);
            }
            jogadores.get(jogador).direcao = 'w';
        } else if (comando.equals("s")) {
            if (x < (getAltura - 1)) {
                ret = verificarJogador(x + 1, y, jogador, x, y);
            }
            jogadores.get(jogador).direcao = 's';
        } else if (comando.equals("a")) {
            if (y > 0) {
                ret = verificarJogador(x, y - 1, jogador, x, y);
            }
            jogadores.get(jogador).direcao = 'a';
        } else if (comando.equals("d")) {
            if (y < (getLargura - 1)) {
                ret = verificarJogador(x, y + 1, jogador, x, y);
            }
            jogadores.get(jogador).direcao = 'd';
        }
        return ret;
    }

    public String atirarJogador(char jogador) {
        String ret = "OK";
        if ((System.currentTimeMillis() - jogadores.get(jogador).lastTimeShot) > 500) {
            new Thread(new Shot(jogadores.get(jogador).x, jogadores.get(jogador).y, jogadores.get(jogador).direcao, jogador)).start();
        }
        return ret;
    }

    public String verificarJogador(int x, int y, char jogador, int xa, int ya) {
        String ret = "OK";
        Boolean lTemLetra = false;
        for (int i = 0; i < letras.length; i++) {
            if (!lTemLetra) {
                lTemLetra = getMatriz[x][y] == letras[i];
            }
        }
        if (lTemLetra) {
            //Faz nada
        } else if (getMatriz[x][y] == '-') {
            //Se é parede faz nada
        } else {
            getMatriz[xa][ya] = '.';
            getMatriz[x][y] = jogador;
            jogadores.get(jogador).x = x;
            jogadores.get(jogador).y = y;
        }
        return ret;
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
