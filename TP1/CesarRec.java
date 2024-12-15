import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class CesarRec {

    private static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

    private static PrintStream out = new PrintStream(System.out, true, Charset.forName("ISO-8859-1"));

    public static String ces(String s, int n) {
        if (s.charAt(n) == '\n')
            return "";
        return ((char) (s.charAt(n) + 3)) + ces(s, n + 1);
    }

    public static String ces(String s) {
        s += '\n';
        return ces(s, 0);
    }

    public static void main(String[] args) {
        try {
            String testing = in.readLine();
            while (!testing.equals("FIM")) {

                out.println(ces(testing));

                testing = in.readLine();
            }
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

    }

}
