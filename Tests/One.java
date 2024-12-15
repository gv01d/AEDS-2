package Tests;

public class One {

    static public class CharHash {
        TNode[] nd;

        CharHash() {
            nd = new TNode[256];
        }

        public TNode getNd(char val) {
            if (nd[val] == null) {
                nd[val] = new TNode(val);
            }
            return nd[val];
        }
    }

    static public class TNode {
        boolean end;
        char value;
        CharHash next;

        TNode(char val) {
            this.value = val;
            next = new CharHash();
        }

        public TNode getNext(char val) {
            return next.getNd(val);
        }

        public void insert(TNode nd, char val) {
            next.nd[val] = nd;
        }

    }

    static public class Trie {
        CharHash start;

        CharHash insert(String S) {
            if (start == null) {
                start = new CharHash();
            }
            start.nd[S.charAt(0)] = insert(S, 1, start.getNd(S.charAt(0)));
            return start;
        }

        TNode insert(String S, int pos, TNode nd) {
            if (pos >= S.length() - 1) {
                nd.value = S.charAt(pos);
                return nd;
            }

            nd.insert(insert(S, pos + 1, nd.getNext(S.charAt(0))), S.charAt(pos));
            return nd;
        }

        public Trie() {
            start = null;
        }
    }

    public static void main(String[] args) {
        Trie tester = new Trie();

        tester.insert("HAHAE");
        tester.insert("HAgg");
        tester.insert("UAUAUAUA");
    }

    void mostrar() {

    }

    char[] mostrar(Calula cel, char[] c, int i) {

        String s = new String();
        s += 'a';
        Celula tmp;
        c[i] = cel;
        while (tmp != null) {

        }
    }

}
