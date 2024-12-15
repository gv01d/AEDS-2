import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class IsRec {
    private static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

    private static PrintStream out = new PrintStream(System.out, true, Charset.forName("ISO-8859-1"));

    static char[] vowels = {
            '\u0041', '\u0045', '\u0049', '\u004F', '\u0055', // A, E, I, O, U
            '\u0061', '\u0065', '\u0069', '\u006F', '\u0075', // a, e, i, o, u
            '\u00C0', '\u00C8', '\u00CC', '\u00D2', '\u00D9', // À, È, Ì, Ò, Ù
            '\u00E0', '\u00E8', '\u00EC', '\u00F2', '\u00F9', // à, è, ì, ò, ù
            '\u00C1', '\u00C9', '\u00CD', '\u00D3', '\u00DA', // Á, É, Í, Ó, Ú
            '\u00E1', '\u00E9', '\u00ED', '\u00F3', '\u00FA', // á, é, í, ó, ú
            '\u00C2', '\u00CA', '\u00CE', '\u00D4', '\u00DB', // Â, Ê, Î, Ô, Û
            '\u00E2', '\u00EA', '\u00EE', '\u00F4', '\u00FB', // â, ê, î, ô, û
            '\u00C3', '\u00D5', '\u00E3', '\u00F5', // Ã, Õ, ã, õ
            '\u00C4', '\u00CB', '\u00CF', '\u00D6', '\u00DC', // Ä, Ë, Ï, Ö, Ü
            '\u00E4', '\u00EB', '\u00EF', '\u00F6', '\u00FC', // ä, ë, ï, ö, ü
            '\u00C5', '\u00E5', // Å, å
            '\u00C6', '\u00E6', // Æ, æ
            '\u0152', '\u0153', // Œ, œ
            '\u00D8', '\u00F8' // Ø, ø
    };
    static String vow = new String(vowels);

    static char[] consonants = {
            '\u0042', '\u0043', '\u0044', '\u0046', '\u0047', '\u0048', '\u004A', '\u004B', '\u004C', '\u004D',
            '\u004E', '\u0050', '\u0051', '\u0052', '\u0053', '\u0054', '\u0056', '\u0057', '\u0058', '\u0059',
            '\u005A', // B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, W, X, Y, Z
            '\u0062', '\u0063', '\u0064', '\u0066', '\u0067', '\u0068', '\u006A', '\u006B', '\u006C', '\u006D',
            '\u006E', '\u0070', '\u0071', '\u0072', '\u0073', '\u0074', '\u0076', '\u0077', '\u0078', '\u0079',
            '\u007A', // b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z
            '\u00C7', '\u00E7', // Ç, ç
            '\u00D1', '\u00F1', // Ñ, ñ
            '\u0152', '\u0153', // Œ, œ
            '\u00DF' // ß
    };
    static String con = new String(consonants);

    static Boolean vowelTest(String s) {
        s += "\n";
        return vowelTest(s, 0);
    }

    static Boolean vowelTest(String test, int i) {
        if (test.charAt(i) == '\n')
            return true;

        if (!vow.contains(test.charAt(i) + ""))
            return false;

        return vowelTest(test, i + 1);
    }

    static Boolean consonantTest(String s) {
        s += "\n";
        return consonantTest(s, 0);
    }

    static Boolean consonantTest(String test, int i) {
        if (test.charAt(i) == '\n')
            return true;

        if (!con.contains(test.charAt(i) + ""))
            return false;

        return vowelTest(test, i + 1);
    }

    static int valueTest(String s) {
        return valueTest(s, 0, 0);
    }

    static int valueTest(String test, int i, int n) {
        if (i >= test.length()) {
            if (n == 0) {
                return 0;
            }
            return 1;
        }
        char c = test.charAt(i);
        if (c < 48 || c > 57) {
            if (c == ',' || c == '.') {
                if (n > 0)
                    return -1;
                n++;
            } else {
                return -1;
            }
        }
        return valueTest(test, i + 1, n);
    }

    public static void main(String[] args) {

        try {

            String Tester = in.readLine();
            while (!Tester.equals("FIM")) {

                out.print(vowelTest(Tester) ? "SIM " : "NAO ");
                out.print(consonantTest(Tester) ? "SIM " : "NAO ");
                int v = valueTest(Tester);

                if (v == 0)
                    out.print("SIM ");
                else
                    out.print("NAO ");

                if (v >= 0)
                    out.println("SIM");
                else
                    out.println("NAO");

                Tester = in.readLine();
            }

        } catch (Exception e) {

            System.err.println(e);
        }

    }
}
