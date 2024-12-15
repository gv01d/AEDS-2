using System;

class Program
{
    public static String poliTester(String Tester)
    {
        for (int i = Tester.Length - 1; i >= 0; i--)
        {
            if (Tester[i] != Tester[Tester.Length - 1 - i])
            {
                return "NAO";
            }
        }
        return "SIM";
    }
    public static void Main()
    {
        String Tester = Console.ReadLine();

        while (!Equals(Tester, "FIM"))
        {

            Console.WriteLine(poliTester(Tester));
            Tester = Console.ReadLine();
        }
    }
}