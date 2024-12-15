import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class PalindRec {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    static PrintStream out = new PrintStream(System.out, true, Charset.forName("UTF-8"));

    static Boolean isPalind(String s) {
        return isPalind(0, s, s.length());
    }

    static Boolean isPalind(int i, String s, int size) {
        if (size - i < i) {
            return true;
        }
        if (s.charAt(i) != s.charAt(size - 1 - i))
            return false;

        return isPalind(i + 1, s, size);
    }

    public static void main(String[] args) {
        try {
            String s = in.readLine();
            while (!s.equals("FIM")) {
                out.println(isPalind(s) ? "SIM" : "NAO");

                s = in.readLine();
            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
