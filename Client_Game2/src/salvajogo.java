
import java.io.*;

public class salvajogo {

    public void metodo_salvar(Nave nave, Inimigo1[] et1, Inimigo2[] et2, Inimigo3[] et3, int seg, int digseg, int min, int life) {
        File arquivo = new File("salvar.txt");
        salvarjogo save = new salvarjogo();

        save.navex = nave.x;
        save.navey = nave.y;

        save.et11x = et1[0].x;
        save.et11y = et1[0].y;
        save.et12x = et1[1].x;
        save.et12y = et1[1].y;
        save.et13x = et1[2].x;
        save.et13y = et1[2].y;
        save.et14x = et1[3].x;
        save.et14y = et1[3].y;
        save.et15x = et1[4].x;
        save.et15y = et1[4].y;
        save.et16x = et1[5].x;
        save.et16y = et1[5].y;
        save.et17x = et1[6].x;
        save.et17y = et1[6].y;

        save.et21x = et2[0].x;
        save.et21y = et2[0].y;
        save.et22x = et2[1].x;
        save.et22y = et2[1].y;
        save.et23x = et2[2].x;
        save.et23y = et2[2].y;
        save.et24x = et2[3].x;
        save.et24y = et2[3].y;
        save.et25x = et2[4].x;
        save.et25y = et2[4].y;
        save.et26x = et2[5].x;
        save.et26y = et2[5].y;
        save.et27x = et2[6].x;
        save.et27y = et2[6].y;

        save.et31x = et3[0].x;
        save.et31y = et3[0].y;
        save.et32x = et3[1].x;
        save.et32y = et3[1].y;
        save.et33x = et3[2].x;
        save.et33y = et3[2].y;
        save.et34x = et3[3].x;
        save.et34y = et3[3].y;
        save.et35x = et3[4].x;
        save.et35y = et3[4].y;
        save.et36x = et3[5].x;
        save.et36y = et3[5].y;

        save.ultseg = seg;
        save.seg = digseg;
        save.ultmin = min;

        save.vida = life;

//        pes.altura = Entrada.leiaInt("Informe a altura da pessoas em CM");
//        pes.peso = Entrada.leiaDouble("Informe o peso da pessoa KG");
        try {
            /*
       * Verifica se o arquivo existe!
             */
            if (!arquivo.exists()) {
                //cria um arquivo (vazio)
                arquivo.createNewFile();
            }

            //cria t�nel para escrita
            FileWriter fw = new FileWriter(arquivo, false);
            //cria buffer para a escrita      
            BufferedWriter bw = new BufferedWriter(fw);

            //escreve no arquivo
//      bw.write("--------------- Jogo --------------");
//      bw.newLine(); 
            bw.write("" + save.navex);
            bw.newLine();
            bw.write("" + save.navey);
            bw.newLine();

            bw.write("" + save.et11x);
            bw.newLine();
            bw.write("" + save.et11y);
            bw.newLine();
            bw.write("" + save.et12x);
            bw.newLine();
            bw.write("" + save.et12y);
            bw.newLine();
            bw.write("" + save.et13x);
            bw.newLine();
            bw.write("" + save.et13y);
            bw.newLine();
            bw.write("" + save.et14x);
            bw.newLine();
            bw.write("" + save.et14y);
            bw.newLine();
            bw.write("" + save.et15x);
            bw.newLine();
            bw.write("" + save.et15y);
            bw.newLine();
            bw.write("" + save.et16x);
            bw.newLine();
            bw.write("" + save.et16y);
            bw.newLine();
            bw.write("" + save.et17x);
            bw.newLine();
            bw.write("" + save.et17y);
            bw.newLine();

            bw.write("" + save.et21x);
            bw.newLine();
            bw.write("" + save.et21y);
            bw.newLine();
            bw.write("" + save.et22x);
            bw.newLine();
            bw.write("" + save.et22y);
            bw.newLine();
            bw.write("" + save.et23x);
            bw.newLine();
            bw.write("" + save.et23y);
            bw.newLine();
            bw.write("" + save.et24x);
            bw.newLine();
            bw.write("" + save.et24y);
            bw.newLine();
            bw.write("" + save.et25x);
            bw.newLine();
            bw.write("" + save.et25y);
            bw.newLine();
            bw.write("" + save.et26x);
            bw.newLine();
            bw.write("" + save.et26y);
            bw.newLine();
            bw.write("" + save.et27x);
            bw.newLine();
            bw.write("" + save.et27y);
            bw.newLine();

            bw.write("" + save.et31x);
            bw.newLine();
            bw.write("" + save.et31y);
            bw.newLine();
            bw.write("" + save.et32x);
            bw.newLine();
            bw.write("" + save.et32y);
            bw.newLine();
            bw.write("" + save.et33x);
            bw.newLine();
            bw.write("" + save.et33y);
            bw.newLine();
            bw.write("" + save.et34x);
            bw.newLine();
            bw.write("" + save.et34y);
            bw.newLine();
            bw.write("" + save.et35x);
            bw.newLine();
            bw.write("" + save.et35y);
            bw.newLine();
            bw.write("" + save.et36x);
            bw.newLine();
            bw.write("" + save.et36y);
            bw.newLine();

            bw.write("" + save.ultseg);
            bw.newLine();
            bw.write("" + save.seg);
            bw.newLine();

            bw.write("" + save.ultmin);
            bw.newLine();

            bw.write("" + save.vida);

            //IMPORTANTE, ap�s escrever FECHA o arquivo
            bw.close();
            fw.close();

            //tratar possiveis erros
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static class salvarjogo {

        int navex, navey;

        int et11x, et11y, et12x, et12y, et13x, et13y, et14x, et14y, et15x, et15y, et16x, et16y, et17x, et17y;
        int et21x, et21y, et22x, et22y, et23x, et23y, et24x, et24y, et25x, et25y, et26x, et26y, et27x, et27y;
        int et31x, et31y, et32x, et32y, et33x, et33y, et34x, et34y, et35x, et35y, et36x, et36y;
        int seg, min, ultseg, ultmin;
        int vida;

    }

    public static int[] seta_nave(Nave nave, Inimigo1[] et1, Inimigo2[] et2, Inimigo3[] et3, int seg, int digseg, int min, int vida) {
        int vetor[] = new int[4];
        try {
            File arquivo = new File("salvar.t"
                    + "xt");

            //leitura do arquivo
            FileReader fr = new FileReader(arquivo);
            //buffer para leitura
            BufferedReader br = new BufferedReader(fr);

            //passando o valor de todas linhas do arquivo e passando para cada variavel corretamente, linha por linha
            nave.x = Integer.parseInt(br.readLine());
            nave.y = Integer.parseInt(br.readLine());
            et1[0].x = Integer.parseInt(br.readLine());
            et1[0].y = Integer.parseInt(br.readLine());
            et1[1].x = Integer.parseInt(br.readLine());
            et1[1].y = Integer.parseInt(br.readLine());
            et1[2].x = Integer.parseInt(br.readLine());
            et1[2].y = Integer.parseInt(br.readLine());
            et1[3].x = Integer.parseInt(br.readLine());
            et1[3].y = Integer.parseInt(br.readLine());
            et1[4].x = Integer.parseInt(br.readLine());
            et1[4].y = Integer.parseInt(br.readLine());
            et1[5].x = Integer.parseInt(br.readLine());
            et1[5].y = Integer.parseInt(br.readLine());
            et1[6].x = Integer.parseInt(br.readLine());
            et1[6].y = Integer.parseInt(br.readLine());
            et2[0].x = Integer.parseInt(br.readLine());
            et2[0].y = Integer.parseInt(br.readLine());
            et2[1].x = Integer.parseInt(br.readLine());
            et2[1].y = Integer.parseInt(br.readLine());
            et2[2].x = Integer.parseInt(br.readLine());
            et2[2].y = Integer.parseInt(br.readLine());
            et2[3].x = Integer.parseInt(br.readLine());
            et2[3].y = Integer.parseInt(br.readLine());
            et2[4].x = Integer.parseInt(br.readLine());
            et2[4].y = Integer.parseInt(br.readLine());
            et2[5].x = Integer.parseInt(br.readLine());
            et2[5].y = Integer.parseInt(br.readLine());
            et2[6].x = Integer.parseInt(br.readLine());
            et2[6].y = Integer.parseInt(br.readLine());
            et3[0].x = Integer.parseInt(br.readLine());
            et3[0].y = Integer.parseInt(br.readLine());
            et3[1].x = Integer.parseInt(br.readLine());
            et3[1].y = Integer.parseInt(br.readLine());
            et3[2].x = Integer.parseInt(br.readLine());
            et3[2].y = Integer.parseInt(br.readLine());
            et3[3].x = Integer.parseInt(br.readLine());
            et3[3].y = Integer.parseInt(br.readLine());
            et3[4].x = Integer.parseInt(br.readLine());
            et3[4].y = Integer.parseInt(br.readLine());
            et3[5].x = Integer.parseInt(br.readLine());
            et3[5].y = Integer.parseInt(br.readLine());
            seg = Integer.parseInt(br.readLine());
            digseg = Integer.parseInt(br.readLine());
            min = Integer.parseInt(br.readLine());
            vida = Integer.parseInt(br.readLine());
            vetor[0] = seg;
            vetor[1] = digseg;
            vetor[2] = min;
            vetor[3] = vida;
            //fechar arquico após ler
            br.close();
            fr.close();

            //tratamento de erro !
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return vetor;

    }
}
