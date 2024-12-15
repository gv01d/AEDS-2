int main()
{
    int n;
    scanf("%d", &n);

    while (n != 0)
    {

        printf("%c\n", (n % 2 == 0) ? 'P' : 'I');

        scanf("%d", &n);
    }
    return 0;
}