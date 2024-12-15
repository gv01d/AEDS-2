package Tests;

import org.w3c.dom.Node;

public class Doidona {

    public class Celula2 {
        String palavra;
        Celula2 prox;
    }

    public class Celula3 {
        String palavra;
        Celula3 prox;
    }

    public class No {
        char letra;
        Celula2 inicio, fim;
        No esq, dir;
    }

    public class T2 {
        No raizes[];
    }

    public class T3 {
        String palavras[];
        Celula3 inicio;
    }

    public class T1 {
        String[] palavras;
        T2 t2;
        T3 t3;
    }

    T1 t1;

    boolean pesquisar(String palavra) {
        int h1 = hashT1(palavra.charAt(0));
        if (t1.palavras[h1].equals(palavra)) {
            return true;
        } else {
            int reH = hashVirtual(palavra.charAt(0));
            if (reH == 0) {
                int h2 = hashT2(palavra.charAt(1));
                No tmp = t1.t2.raizes[h2];

                Celula2 tmp2 = pArv(tmp, palavra.charAt(0));
                if (tmp2 == null)
                    return false;

                while (tmp2 != null) {
                    if (tmp2.palavra.equals(palavra)) {
                        return true;
                    }
                    tmp2 = tmp2.prox;
                }
                return false;
            } else {
                int h3 = hashT3(palavra.charAt(1));
                if (t1.t3.palavras[h3].equals(palavra)) {
                    return true;
                }
                h3 = rehashT3(palavra.charAt(1));
                if (t1.t3.palavras[h3].equals(palavra)) {
                    return true;
                }
                Celula3 tmp = t1.t3.inicio;
                while (tmp != null) {
                    if (tmp.palavra.equals(palavra)) {
                        return true;
                    }
                    tmp = tmp.prox;
                }
                return false;
            }
        }
    }

    Celula2 pArv(No nd, char c) {
        if (nd == null) {
            return null;
        }
        if (c > nd.letra) {
            return pArv(nd.dir, c);
        } else if (c < nd.letra) {
            return pArv(nd.esq, c);
        }
        return nd.inicio;
    }
}
