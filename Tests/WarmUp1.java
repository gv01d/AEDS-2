import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class WarmUp1 {

    static class M {
        int[] hC;
        int[] hS;
        int size;

        M(int size) {
            this.size = size;
            hC = new int[size];
            hS = new int[size];
        }
    }

    static class Pilha {
        PNode root;
        int maxL;
        int length;

        class PNode {
            int val;
            PNode prox;
        }

        Pilha(int maxL) {
            root = null;
            this.maxL = maxL;
            length = 0;
        }
    }

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));

    static boolean test(M hash, int max) {
        for (int i = 0; i < hash.size; i++) {
            int maxDetect = 0;
            for (int j = 0; j < hash.size; j++) {
                if (i != j) {
                    // Algum horario de Chegada < Horario de chegada (chegou antes) e
                    // Algum horario de Saida > Horario de entrada (saiu depois da entrada)
                    if (hash.hC[i] > hash.hC[j] && hash.hC[i] < hash.hS[j]) {
                        maxDetect++;
                    }
                    // Algum Horario de Chegada > Horario de Chegada (Chegou depois) e
                    // Este horario de saida > Horario de Saida (Saiu depois) e
                    // Este horario de chegada < Horario de saida (Chegou antes da saida)
                    if (hash.hC[j] > hash.hC[i] && hash.hS[j] > hash.hS[i] && hash.hC[j] < hash.hS[i]) {
                        return false;
                    }
                }
            }
            if (maxDetect > max)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        String[] buffer = in.readLine().split(" ");
        int N = Integer.parseInt(buffer[0]);
        int K = Integer.parseInt(buffer[1]);

        while (N != 0 && K != 0) {
            M hash = new M(N);
            Pilha garage = new Pilha(K);
            for (int i = 0; i < N; i++) {
                buffer = in.readLine().split(" ");
                hash.hC[i] = Integer.parseInt(buffer[0]);
                hash.hS[i] = Integer.parseInt(buffer[1]);
            }
            boolean resp = test(hash, K);
            System.out.println(resp ? "Sim" : "Nao");

            buffer = in.readLine().split(" ");
            N = Integer.parseInt(buffer[0]);
            K = Integer.parseInt(buffer[1]);
        }
    }
}
