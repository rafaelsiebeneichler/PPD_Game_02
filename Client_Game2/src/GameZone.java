
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

public class GameZone extends JPanel {

    /**
     *
     */
    private int velocidade;

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    private static final long serialVersionUID = 1L;

    int[][] game = {
        {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
        {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0},
        {1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
        {1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1}
    };

    int[][] over = {
        {1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
        {1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1}
    };

    int[][] you = {
        {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0}
    };

    int[][] win = {
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1},
        {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1}
    };

    private static int[][] draw;

    private static int pixelSize = 6;

    private static int boardWidth;
    private static int boardHeight;

    private static boolean esquerda = false;
    private static boolean direita = false;
    private static boolean frente = false;
    private static boolean esc = false;
    private static boolean baixo = false;
    private static boolean espaco = false;
    private static boolean pause = false;
    private static boolean save = false;
    private static boolean load = false;
    private static boolean posicao = false;

    private static boolean gameOver = false;
    private static boolean youWin = false;

    private final static JFrame frame = new JFrame("RoboWar");

    public static int getBoardWidth() {
        return boardWidth;
    }

    public static int getBoardHeight() {
        return boardHeight;
    }

    public GameZone() {
    }

    /*
   * Desenha na tela o jogo. 
     */
    public static void desenha() {
        frame.repaint();
        try {
            Thread.sleep(45);
        } catch (java.lang.InterruptedException e) {
        }
    }

    public void paintComponent(Graphics g) {
        int width = getWidth() / pixelSize;
        int height = getHeight() / pixelSize;
        g.setColor(Color.black);

        drawMsg(g, 1, 1, draw);

        g.setColor(Color.black);

        if (gameOver) {
            drawMsg(g, 35, 35, game);
            drawMsg(g, 65, 35, over);

        }

        if (youWin) {
            drawMsg(g, 10, 10, you);
            drawMsg(g, 26, 20, win);
        }

        g.setColor(Color.lightGray);
        for (int i = 0; i < height; i++) {
            g.drawLine(0, i * pixelSize, boardWidth * pixelSize, i * pixelSize);
        }

        for (int i = 0; i < width; i++) {
            g.drawLine(i * pixelSize, 0, i * pixelSize, boardHeight * pixelSize);
        }

    }

    /* 
   * Desenha uma mensagem na tela na posi��o x, y.
   * 
     */
    private void drawMsg(Graphics g, int x, int y, int[][] msg) {
        for (int i = 0; i < msg[0].length; i++) {
            for (int j = 0; j < msg.length; j++) {
                if (msg[j][i] != 0) {
                    switch (msg[j][i]) {
                        case 1:
                            g.setColor(Color.black);
                            break;
                        case 2:
                            g.setColor(Color.orange);
                            break;
                        case 3:
                            g.setColor(Color.green);
                            break;
                        case 4:
                            g.setColor(Color.red);
                            break;
                        case 5:
                            g.setColor(Color.pink);
                            break;
                        case 6:
                            g.setColor(Color.blue);
                            break;
                        case 7:
                            g.setColor(Color.yellow);
                            break;

                        default:
                            g.setColor(Color.black);
                            break;
                    }

                    g.drawOval((i + x) * pixelSize - pixelSize, (j + y) * pixelSize - pixelSize, pixelSize, pixelSize);
                    g.fillOval((i + x) * pixelSize - pixelSize, (j + y) * pixelSize - pixelSize, pixelSize, pixelSize);
                }
            }
        }
    }

    /*
   * Desenha uma mensagem de game over na pr�xima
   * vez que chamar desenha(). 
     */
    public static void gameOver() {
        gameOver = true;
    }

    /*
   * Desenha uma mensagem de you win na pr�xima
   * vez que chamar desenha(). 
     */
    public static void youWin() {
        youWin = true;
    }


    /*
   * Copia uma matriz na posi��o x, y, coluna, linha da matrix para
   * a matriz principal do jogo. 
   * 
   * @param x posi��o da coluna para desenhar.
   * @param y posi��o da linha para desenhar.
   * @param m matriz pra ser desenhada onde o valor inteiro indica a cor
   * 	como segue: 
   *    0 indica nada,
   * 	1 preto
   * 	2 laranja
   * 	3 verde
   * 	4 vermelho
   * 	5 rosa
   * 
   * 
     */
    public static void setMatrix(int x, int y, int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (j + x >= 0 && j + x < draw[0].length && i + y >= 0 && i + y < draw.length) {
                    if (m[i][j] != 0) {
                        draw[i + y][j + x] = m[i][j];
                    }
                }
            }
        }

    }

    /*
   * Limpa a matriz da tela.
     */
    public static void clear() {
        for (int i = 0; i < draw.length; i++) {
            for (int j = 0; j < draw[0].length; j++) {
                draw[i][j] = 0;
            }
        }
    }

    /*
   * Retorna verdadeiro se a ESC estiver sendo
   * pressionada pelo usu�rio.
   * 
   * @return verdadeiro (true) caso a ESC estiver
   * sendo precionada, falso (false) caso contr�rio.
     */
    public static boolean apertouEsc() {
        return esc;
    }

    /*
   * Retorna verdadeiro se a seta para a esquerda estiver sendo
   * pressionada pelo usu�rio.
   * 
   * @return verdadeiro (true) caso a seta para a esquerda estiver
   * sendo precionada, falso (false) caso contr�rio.
     */
    public static boolean apertouEsquerda() {
        return esquerda;
    }

    /*
   * Retorna verdadeiro se a seta para a direita estiver sendo
   * pressionada pelo usu�rio.
   * 
   * @return verdadeiro (true) caso a seta para a direita estiver
   * sendo precionada, falso (false) caso contr�rio.
     */
    public static boolean apertouDireita() {
        return direita;
    }

    /*
   * Retorna verdadeiro se a seta para a cima estiver sendo
   * pressionada pelo usu�rio.
   * 
   * @return verdadeiro (true) caso a seta para a cima estiver
   * sendo precionada, falso (false) caso contr�rio.
     */
    public static boolean apertouFrente() {
        return frente;

    }

    /*
   * Retorna verdadeiro se a seta para a cima estiver sendo
   * pressionada pelo usu�rio.
   * 
   * @return verdadeiro (true) caso a seta para a cima estiver
   * sendo precionada, falso (false) caso contr�rio.
     */
    public static boolean apertouBaixo() {
        return baixo;
    }

    /*
   * Retorna verdadeiro se a seta para a cima estiver sendo
   * pressionada pelo usu�rio.
   * 
   * @return verdadeiro (true) caso a seta para a cima estiver
   * sendo precionada, falso (false) caso contr�rio.
     */
    public static boolean apertouEspaco() {
        boolean save = espaco;
        espaco = false;
        return save;
    }

    public static boolean apertouP() {
        boolean save = pause;
        pause = false;
        return save;
    }

    public static boolean apertouS() {
        return save;
    }

    public static boolean apertouT() {
        return posicao;
    }

    public static boolean apertouL() {
        return load;
    }

    /*
   * Inicia a janela do jogo. Este m�todo deve ser chamado
   * somente uma vez em todo o programa.
     */
    public static void init() {
        boardWidth = 120;
        boardHeight = 80;

        draw = new int[boardHeight][boardWidth];

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameZone a = new GameZone();
        a.setPreferredSize(new Dimension(boardWidth * pixelSize, boardHeight * pixelSize));
        frame.getContentPane().add(a);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    pause = true;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    //seta para a direita
                    direita = true;
                    espaco = false;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    //seta para a esquerda
                    esquerda = true;
                    espaco = false;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    frente = true;
                    espaco = false;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    baixo = true;
                    espaco = false;
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    esc = true;
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    espaco = true;
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    save = true;
                } else if (e.getKeyCode() == KeyEvent.VK_L) {
                    load = true;
                }else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    posicao = true;
                }

            }

            public void keyReleased(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    //seta para a direita
                    direita = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    //seta para a esquerda
                    esquerda = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    frente = false;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    baixo = false;
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    esc = false;
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    espaco = false;
                } else if (e.getKeyCode() == KeyEvent.VK_P) {
                    pause = false;
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    save = false;
                } else if (e.getKeyCode() == KeyEvent.VK_L) {
                    load = false;
                }else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    posicao = true;
                }
            }

            public void keyTyped(KeyEvent e) {
            }

        });

    }

}
