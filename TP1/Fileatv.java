import java.io.*;
import java.nio.charset.*;
import java.text.DecimalFormat;

public class Fileatv {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    static PrintStream out = new PrintStream(System.out, true, Charset.forName("UTF-8"));

    public static float readFloat() {
        float d = -1;
        try {
            d = Float.parseFloat(in.readLine().trim().replace(",", "."));
        } catch (Exception e) {
        }
        return d;
    }

    static long siz = 4;

    public static void main(String[] args) {

        try {
            RandomAccessFile flp = new RandomAccessFile("buff.txt", "rw");
            int n = (int) readFloat();

            for (double i = 0; i < n; i++) {
                flp.writeFloat(readFloat());
            }
            flp.close();

            DecimalFormat form = new DecimalFormat();

            RandomAccessFile flp2 = new RandomAccessFile("buff.txt", "r");
            for (int i = n - 1; i >= 0; i--) {
                flp2.seek(siz * i);
                out.println(form.format(flp2.readFloat()));
            }
            flp2.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
