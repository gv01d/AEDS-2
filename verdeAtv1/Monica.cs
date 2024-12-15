using System;

class Program
{
    public static void main()
    {
        int M = int.Parse(Console.ReadLine());
        if (M < 40 || M > 110) return;

        int A = int.Parse(Console.ReadLine());
        if (A < 1 || A > M) return;

        int B = int.Parse(Console.ReadLine());
        if (B < 1 || B > M) return;
        if (A == B) return;

        M -= A + B;

        Console.WriteLine(M);
    }

}
