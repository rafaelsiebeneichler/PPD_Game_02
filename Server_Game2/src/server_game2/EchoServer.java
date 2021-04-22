package server_game2;

public class EchoServer extends Thread {

    public static void main(String ck[]) {
        int delaytime = 0; // variavel para o delay do timer
        int digitmin = 0, min = 0, digitseg = 0, seg = 0; // digitos do timer

        Nave nave = new Nave();
        nave.x = (int) (90 * Math.random() + 1); // sorteia  aleotariamente a posicao x da nave
        nave.y = (int) (65 * Math.random() + 1);  // sorteia aleotoriamente a posicao y da nave

        LifeNave life = new LifeNave();
        //a vida da nave foi setada para 120
        // e possui 4 estagios de life, setando o primeiro como full, ou seja, 0
        int vida_nave = 120, define_life = 0;

        // vetores que controlam o movimento de cada inimigo dentro do frame
        int controleet1[] = {-1, -1, -1, -1, -1, -1, -1};
        int controleet2[] = {-1, -1, -1, -1, -1, -1, -1};
        int controleet2y[] = {-1, -1, -1, -1, -1, -1, -1};
        int controleet3x[] = {-1, -1, -1, -1, -1, -1};
        int controleet3y[] = {-1, -1, -1, -1, -1, -1};

        Shot[] shot = new Shot[5];  // cria o vetor de 5 tiros
        int shotSize = 0; // cria  a variavel pra controlar o vetor

        //zcria todos os tiros e seta na posição  -1, fora do frame
        for (int i = 0; i < shot.length; i++) {
            shot[i] = new Shot();
            shot[i].x = -1;
        }

        // cria o vetor de inimigos do tipo 1
        Inimigo1[] et1 = new Inimigo1[7];
        int sorteira_et1 = 70, sorteira_et11 = 200;

        for (int x = 0; x < et1.length; x++) {
            et1[x] = new Inimigo1();
            et1[x].x = (int) (sorteira_et1 * Math.random() + sorteira_et11);
            et1[x].y = (int) (72 * Math.random() + 1);
            sorteira_et1 = sorteira_et1 + 60;
            sorteira_et11 = sorteira_et11 + 70;
        }
        //cria o vetor de inimigos do tipo 2
        Inimigo2[] et2 = new Inimigo2[7];
        int sorteira_et2 = 70, sorteira_et22 = 230;

        for (int x = 0; x < et2.length; x++) {
            et2[x] = new Inimigo2();
            et2[x].x = (int) (sorteira_et2 * Math.random() + sorteira_et22);
            et2[x].y = (int) (72 * Math.random() + 1);
            sorteira_et2 = sorteira_et2 + 80;
            sorteira_et22 = sorteira_et22 + 100;
        }
        // cria o vetor de inimigos do tipo 3
        Inimigo3[] et3 = new Inimigo3[6];
        int sorteira_et3 = 80, sorteira_et33 = 250;

        for (int x = 0; x < et3.length; x++) {
            et3[x] = new Inimigo3();
            et3[x].x = (int) (sorteira_et3 * Math.random() + sorteira_et33);
            et3[x].y = (int) (72 * Math.random() + 1);
            sorteira_et3 = sorteira_et3 + 70;
            sorteira_et33 = sorteira_et33 + 100;
        }

        // inicializa o frame
        GameZone.init();
        // variavel para execução do jogo
        boolean play = true;

        // variavel para controlar o pause do jogo
        boolean pause = false;

        while (play == true) {
            // apertar ESC ele retorna para o jogo
            if (GameZone.apertouEsc()) {
                pause = false;
            }
            // salvar jogo
            if (GameZone.apertouS()) {
                salvajogo sv = new salvajogo();
                sv.metodo_salvar(nave, et1, et2, et3, seg, digitseg, min, vida_nave);

            }
            // Carregar jogo salvo
            if (GameZone.apertouL()) {
                int definevariaveis[] = new int[4];
                definevariaveis = salvajogo.seta_nave(nave, et1, et2, et3, seg, digitseg, min, vida_nave);
                seg = definevariaveis[0];
                digitseg = definevariaveis[1];
                min = definevariaveis[2];

                vida_nave = definevariaveis[3];
            }

            while (pause == false) {
                // metodo para verificar colisão dos boneco et1, et2, et3 com a nave

                vida_nave = colisao_tanque_bonecoet1(nave, et1, vida_nave);
                vida_nave = colisao_tanque_bonecoet2(nave, et2, vida_nave);
                vida_nave = colisao_tanque_bonecoet3(nave, et3, vida_nave);
                // define vida da nave, conforme é diminuido (vida_nave) quando executado o metodo
                if (vida_nave > 90) {
                    define_life = 0;
                }
                if (vida_nave <= 90 && vida_nave > 60) {
                    define_life = 1;
                }
                if (vida_nave <= 60 && vida_nave > 30) {
                    define_life = 2;
                }
                if (vida_nave <= 30 && vida_nave > 0) {
                    define_life = 3;
                }
                // finaliza o jogo quando a vida termina 
                if (vida_nave <= 0) {
                    define_life = 4;
                    GameZone.gameOver();
                    play = false;
                    pause = true;
                }

                if (delaytime == 21) {
                    delaytime = 0;
                    //conta os segundos
                    seg++;

                    // se os segundos chegarem a 10
                    // zera os segundos e acrescenta os digitos auxiliar
                    if (seg == 10) {
                        seg = 0;
                        digitseg++;
                    }

                    //se chegar aos 59 segundos acrescenta o min e zera os
                    // digitos dos segundos
                    if (digitseg == 5 && seg == 9) {
                        seg = 0;
                        digitseg = 0;
                        min++;
                    }
                    // se chegar no 1 min e 30 segundos
                    // a vida zera, 
                    // chama o metodo gameover e sai dos whiles
                    if (min == 1 && (digitseg == 3 && seg == 0)) {
                        define_life = 4;
                        GameZone.gameOver();
                        play = false;
                        pause = true;
                    }

                } else {
                    delaytime++;
                }
                /*
                     *  movimentação da nave
                     * 
                 */

                if (GameZone.apertouFrente()) {
                    nave.y--;
                }
                if (GameZone.apertouEsquerda()) {
                    nave.x--;
                }
                if (GameZone.apertouDireita()) {
                    nave.x++;
                }
                if (GameZone.apertouBaixo()) {
                    nave.y++;
                }
                
                if (GameZone.apertouT()) {
                    nave.y++;
                }

                // apertar o P,  e cai fora  do while onde o jogo é executado
                if (GameZone.apertouP()) {
                    pause = true;
                }

                /* tiros */
                if (GameZone.apertouEspaco()) {
                    shot[shotSize].x = nave.x + 12;
                    shot[shotSize].y = nave.y + 5;
                    shotSize++;

                    if (shotSize == 5) {
                        shotSize = 0;
                    }
                }
                /*
             * for que quando algum tiro chega na posição 120, ele é setado para a posição 1000 
             * assim se nenhum boneco for atingido até que ele chegue no limite do frame 
             * não continue até acertar algum inimigo
                 */
                for (int st = 0; st < shot.length; st++) {
                    if (shot[st].x == 120) {
                        shot[st].x = -1;
                    }
                }

                // passando valores +1 para os tiros andarem a frente (direita)
                for (int adicionatiro = 0; adicionatiro < shot.length; adicionatiro++) {
                    if (shot[adicionatiro].x >= 0) {
                        shot[adicionatiro].x++;
                    }
                }
                // verificar colisão de tiros com inimigos
                tiro_tanqueet1(et1, shot);
                tiro_tanque_et2(et2, shot);
                tiro_tanque_et3(et3, shot);

                /* colisoes nave */
                if (nave.y <= 0) {
                    nave.y = 0;
                }
                if (nave.x <= 0) {
                    nave.x = 0;
                }
                if (nave.x >= 120 - 14) {
                    nave.x = 120 - 14;
                }
                if (nave.y >= 80 - 11) {
                    nave.y = 80 - 11;
                }

                //mostrar inimigos do tipo et1 na tela 
                for (int et11 = 0; et11 < et1.length; et11++) {
                    controleet1[et11] = mov(et1, et11, controleet1[et11]);
                }

                //mostrar inimigos do tipo et3 na tela, setar suas posições
                for (int et33 = 0; et33 < et3.length; et33++) {
                    int recebe_metodo[] = new int[2];
                    recebe_metodo = movetet3_vertical_horizontal(et3, et33, controleet3x[et33], controleet3y[et33]);
                    controleet3x[et33] = recebe_metodo[0];
                    controleet3y[et33] = recebe_metodo[1];
                }

                // mostrar inimigos do tipo et2 na tela setar suas posições
                for (int et22 = 0; et22 < et2.length; et22++) {
                    int recebe_metodo[] = new int[2];
                    recebe_metodo = move_vertical_horizontal(et2, et22, controleet2[et22], controleet2y[et22]);
                    controleet2[et22] = recebe_metodo[0];
                    controleet2y[et22] = recebe_metodo[1];
                }

                /*
                     * metodo clear Limpa a tela
                 */
                GameZone.clear();

                /*
                     * metodo  para mostrar os tiros existentes
                 */
                GameZone.setMatrix(shot[0].x, shot[0].y, shot[0].getMatrix());
                GameZone.setMatrix(shot[1].x, shot[1].y, shot[1].getMatrix());
                GameZone.setMatrix(shot[2].x, shot[2].y, shot[2].getMatrix());
                GameZone.setMatrix(shot[3].x, shot[3].y, shot[3].getMatrix());
                GameZone.setMatrix(shot[4].x, shot[4].y, shot[4].getMatrix());

                /*
                     * metodo para mostrar os inimigos de tipo 1
                 */
                GameZone.setMatrix(et1[0].x, et1[0].y, et1[0].getMatrix());
                GameZone.setMatrix(et1[1].x, et1[1].y, et1[1].getMatrix());
                GameZone.setMatrix(et1[2].x, et1[2].y, et1[2].getMatrix());
                GameZone.setMatrix(et1[3].x, et1[3].y, et1[3].getMatrix());
                GameZone.setMatrix(et1[4].x, et1[4].y, et1[4].getMatrix());
                GameZone.setMatrix(et1[5].x, et1[5].y, et1[5].getMatrix());
                GameZone.setMatrix(et1[6].x, et1[6].y, et1[6].getMatrix());

                /*
                     * metodo para mostrar os inimigos de tipo 2
                 */
                GameZone.setMatrix(et2[0].x, et2[0].y, et2[0].getMatrix());
                GameZone.setMatrix(et2[1].x, et2[1].y, et2[1].getMatrix());
                GameZone.setMatrix(et2[2].x, et2[2].y, et2[2].getMatrix());
                GameZone.setMatrix(et2[3].x, et2[3].y, et2[3].getMatrix());
                GameZone.setMatrix(et2[4].x, et2[4].y, et2[4].getMatrix());
                GameZone.setMatrix(et2[5].x, et2[5].y, et2[5].getMatrix());
                GameZone.setMatrix(et2[6].x, et2[6].y, et2[6].getMatrix());

                /*
                     *  metodo para mostrar os inimigos de tipo 3
                 */
                GameZone.setMatrix(et3[0].x, et3[0].y, et3[0].getMatrix());
                GameZone.setMatrix(et3[1].x, et3[1].y, et3[1].getMatrix());
                GameZone.setMatrix(et3[2].x, et3[2].y, et3[2].getMatrix());
                GameZone.setMatrix(et3[3].x, et3[3].y, et3[3].getMatrix());
                GameZone.setMatrix(et3[4].x, et3[4].y, et3[4].getMatrix());
                GameZone.setMatrix(et3[5].x, et3[5].y, et3[5].getMatrix());

                /*
                     * metodo para mostrar a nave
                 */
                GameZone.setMatrix(nave.x, nave.y, nave.getMatrix());


                /*
                     * metodo que mostram o display da vida e a vida da nave
                 */
                GameZone.setMatrix(0, 0, life.lifedisplay);
                GameZone.setMatrix(16, 0, life.sizeLife(define_life));

                /*
                    * metodo que desenha todos os acima na tela
                 */
                GameZone.desenha();
            }
        }
    }

    /*
     *  metodo para a colisão do tiro com o tipo de inimingo 1
     *  
     */
    static void tiro_tanqueet1(Inimigo1[] et1, Shot shot[]) {

        for (int ett = 0; ett < et1.length; ett++) {
            int resp = ett;
            for (int tirro = 0; tirro < shot.length; tirro++) {
                if (shot[tirro].x >= et1[resp].x && shot[tirro].y <= (et1[resp].y + 8) && shot[tirro].y >= (et1[resp].y)) {
                    System.out.println("Tiro: " + tirro + "Matou o inimigo: " + resp);
                    et1[resp].x = 230;
                    et1[resp].y = (int) (72 * Math.random() + 1);
                    shot[tirro].x = -1;
                }
            }
        }
    }

    /*
     *  metodo para a colisão do tiro com o tipo de inimingo 2
     *  
     */
    final static void tiro_tanque_et2(Inimigo2[] et2, Shot shot[]) {

        for (int ett2 = 0; ett2 < et2.length; ett2++) {
            int resposta = ett2;
            for (int tirroet2 = 0; tirroet2 < shot.length; tirroet2++) {
                if (shot[tirroet2].x >= et2[resposta].x && shot[tirroet2].x <= et2[resposta].x + 12 && shot[tirroet2].y <= (et2[resposta].y + 12) && shot[tirroet2].y >= (et2[resposta].y)) {
                    System.out.println("Tiro: " + tirroet2 + "Matou o inimigo: " + resposta);
                    et2[resposta].x = 230;
                    et2[resposta].y = (int) (72 * Math.random() + 1);
                    shot[tirroet2].x = -1;
                }
            }
        }
    }

    /*
     *  metodo para a colisão do tiro com o tipo de inimingo 3
     *  
     */
    final static void tiro_tanque_et3(Inimigo3[] et3, Shot shot[]) {

        for (int ett3 = 0; ett3 < et3.length; ett3++) {
            int resposta = ett3;
            for (int tirroet3 = 0; tirroet3 < shot.length; tirroet3++) {
                if (shot[tirroet3].x >= et3[resposta].x && shot[tirroet3].x <= et3[resposta].x + 8 && shot[tirroet3].y <= (et3[resposta].y + 8) && shot[tirroet3].y >= (et3[resposta].y)) {
                    System.out.println("Tiro: " + tirroet3 + "Matou o inimigo: " + resposta);
                    et3[resposta].x = 230;
                    et3[resposta].y = (int) (72 * Math.random() + 1);
                    shot[tirroet3].x = -1;
                }
            }
        }
    }

    /*
     *  metodo para o movimento do inimigo 1 na horizontal
     */
    static int mov(Inimigo1[] et1, int x, int ct) {
        if (et1[x].getX() == 109) {
            ct = -1;
        }
        if (et1[x].getX() == 0) {
            ct = +1;
        }
        if (ct == -1) {
            et1[x].x--;
        }
        if (ct == +1) {
            et1[x].x++;
        }
        return ct;
    }

    /*
     *  metodo para o movimento do inimigo na vertical e horizontal
     *  
     */
    static int[] move_vertical_horizontal(Inimigo2[] et2, int x, int ctx, int cty) {
        int[] retorno = new int[2];

        if (et2[x].getX() == 110) {
            ctx = -1;
        }
        if (et2[x].getX() == 0) {
            ctx = +1;
        }
        if (ctx == -1) {
            et2[x].x--;
        }
        if (ctx == +1) {
            et2[x].x++;
        }
        if (et2[x].getY() == 1) {
            cty = -1;
        }
        if (et2[x].getY() == 72) {
            cty = +1;
        }
        if (cty == +1) {
            et2[x].y--;
        }
        if (cty == -1) {
            et2[x].y++;
        }

        retorno[0] = ctx;
        retorno[1] = cty;

        return retorno;
    }

    /*
     *  metodo para o movimento do inimigo 3 na horizontal e vertical
     *  
     */
    static int[] movetet3_vertical_horizontal(Inimigo3[] et3, int xt3, int ctx3, int cty3) {
        int[] retornoet3 = new int[2];

        if (et3[xt3].getX() == 111) {
            ctx3 = -1;
        }
        if (et3[xt3].getX() == 0) {
            ctx3 = +1;
        }
        if (ctx3 == -1) {
            et3[xt3].x--;
        }
        if (ctx3 == +1) {
            et3[xt3].x++;
        }
        if (et3[xt3].getY() == 0) {
            cty3 = -1;
        }

        if (et3[xt3].getY() == 72) {
            cty3 = +1;
        }
        if (cty3 == +1) {
            et3[xt3].y--;
        }
        if (cty3 == -1) {
            et3[xt3].y++;
        }

        retornoet3[0] = ctx3;
        retornoet3[1] = cty3;
        return retornoet3;
    }

    /*
     *  metodo para colisão da nave com o inimigo de tipo 1
     *  
     */
    static int colisao_tanque_bonecoet1(Nave nave, Inimigo1[] et1, int vidanave) {
        for (int et11 = 0; et11 < et1.length; et11++) {
            int resposta = et11;

            if ((nave.x <= et1[et11].x) && et1[et11].x <= (nave.x + 14)
                    && nave.y <= et1[et11].y && et1[et11].y <= (nave.y + 11)) {
                vidanave--;
            }
        }
        return vidanave;
    }

    /*
     *  metodo para colisão da nave com o inimigo de tipo 2
     *  
     */
    static int colisao_tanque_bonecoet2(Nave nave, Inimigo2[] et2, int vidanave) {
        for (int et11 = 0; et11 < et2.length; et11++) {
            int resposta = et11;

            if ((nave.x <= et2[et11].x) && et2[et11].x <= (nave.x + 14)
                    && nave.y <= et2[et11].y && et2[et11].y <= (nave.y + 11)) {
                vidanave--;
            }
        }
        return vidanave;
    }

    /*
     *  metodo para colisão da nave com o inimigo de tipo 3
     *  
     */
    static int colisao_tanque_bonecoet3(Nave nave, Inimigo3[] et3, int vidanave) {
        for (int et11 = 0; et11 < et3.length; et11++) {
            int resposta = et11;

            if ((nave.x <= et3[et11].x) && et3[et11].x <= (nave.x + 14)
                    && nave.y <= et3[et11].y && et3[et11].y <= (nave.y + 11)) {
                vidanave--;
            }
        }
        return vidanave;
    }
}
