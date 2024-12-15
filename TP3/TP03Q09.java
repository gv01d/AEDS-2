import java.io.*;
import java.nio.charset.Charset;
import java.lang.*;

public class TP03Q09 {
    static class Matriz {
        No start;
        No end;

        class No {
            No next, prev, up, down;
            int val;

            No() {
                next = prev = up = down = null;
                val = 0;
            }
        }

        Matriz() {
            start = end = new No();
        }

        Matriz(int r, int c) {
            No made[][] = new No[r][c];
            if (made[r - 1][c - 1] == null) {
            }
            start = build(made, c, c, 0, 0);
        }

        No build(No made[][], int mx, int my, int x, int y) {
            if (x >= mx || y >= my) {
                return null;
            }
            if (made[x][y] != null) {
                return made[x][y];
            }

            No selected = new No();
            made[x][y] = selected;
            selected.next = build(made, mx, my, x + 1, y);
            selected.down = build(made, mx, my, x, y + 1);
            if (x > 0) {
                selected.prev = made[x - 1][y];
            }
            if (y > 0) {
                selected.up = made[x][y - 1];
            }
            if (x == mx - 1 && y == my - 1) {
                end = selected;
            }
            return selected;

        }

        void inserir(int x, int y, int val) {
            No selected = start;
            for (int i = 0; i < x; i++) {
                selected = selected.next;
            }
            for (int j = 0; j < y; j++) {
                selected = selected.down;
            }
            selected.val = val;
        }

        void printDiag() {
            No selected = start;
            while (selected != null) {
                System.out.print(selected.val + " ");
                selected = selected.next;
                if (selected == null) {
                    break;
                }
                selected = selected.down;
            }
            System.out.println();
        }

        void printReverseDiag(int s) {
            No col = start;
            No selected = start;
            int i = s - 1, j = 0;
            while (col != null) {
                selected = col;
                i = s - 1;
                while (selected != null) {
                    if (i == j)
                        System.out.print(selected.val + " ");
                    selected = selected.next;
                    i--;
                }
                col = col.down;
                j++;
            }
            System.out.println();
        }

        void Printsum(Matriz m2) {
            No col = start;
            No col2 = m2.start;
            No selected = start;
            No selected2 = m2.start;
            while (col != null && col2 != null) {
                selected = col;
                selected2 = col2;
                while (selected != null && selected2 != null) {
                    System.out.print((selected.val + selected2.val) + " ");
                    selected = selected.next;
                    selected2 = selected2.next;
                }
                col = col.down;
                col2 = col2.down;
                System.out.println();
            }
        }

        void mult(Matriz m1, Matriz m2) {
            No col = start;
            No col1 = m1.start;
            No col2 = m2.start;
            No selected = start;
            No selected1 = m1.start;
            No selected2 = m2.start;
            while (col1 != null) {
                col2 = m2.start;
                selected = col;
                while (col2 != null) {
                    selected1 = col1;
                    selected2 = col2;
                    while (selected1 != null && selected2 != null) {
                        selected.val += (selected1.val * selected2.val);
                        selected1 = selected1.next;
                        selected2 = selected2.down;
                    }
                    System.out.print(selected.val + " ");
                    selected = selected.next;
                    col2 = col2.next;
                }
                System.out.println();
                col1 = col1.down;
                col = col.down;
            }
        }

    }

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));

    static int readInt() throws Exception {
        char tmp = (char) in.read();
        while (tmp <= 47 || tmp >= 58) {
            tmp = (char) in.read();
        }
        int ret = 0;
        while (tmp > 47 && tmp < 58) {
            ret = (ret * 10) + (tmp - '0');
            tmp = (char) in.read();
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        int n = readInt();
        for (int i = 0; i < n; i++) {
            // Create M1
            int mx = readInt();
            int my = readInt();
            Matriz m1 = new Matriz(mx, my);
            for (int j = 0; j < my; j++) {
                for (int j2 = 0; j2 < mx; j2++) {
                    m1.inserir(j2, j, readInt());
                }
            }

            // Create M2
            mx = readInt();
            my = readInt();
            Matriz m2 = new Matriz(mx, my);
            for (int j = 0; j < my; j++) {
                for (int j2 = 0; j2 < mx; j2++) {
                    m2.inserir(j2, j, readInt());
                }
            }

            // Output
            // Diagonais
            m1.printDiag();
            m1.printReverseDiag(mx);
            // Soma
            m1.Printsum(m2);
            // mult
            Matriz mult = new Matriz(mx, my);
            mult.mult(m1, m2);
        }
    }
}
