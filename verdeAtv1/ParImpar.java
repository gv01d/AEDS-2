import java.util.*;
import java.io.*;
import java.nio.charset.*;
import java.net.*;

public class ParImpar {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tester = scanner.nextInt();
        Boolean test;

        while (tester != 0) {
            MyIO.println((tester % 2 == 0) ? "P" : "I");

            tester = scanner.nextInt();
        }

    }
}
