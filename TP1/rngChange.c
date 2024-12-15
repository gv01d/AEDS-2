#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

void change(char A, char B, char *t, int size, int i)
{
    if (i >= size)
        return;

    if (t[i] == A)
    {
        t[i] = B;
        change(A, B, t, size, i + 1);
    }
    change(A, B, t, size, i + 1);
}

void rngChange(char A, char B, char *t)
{
    change(A, B, t, strlen(t), 0);
}

int main()
{

    char *tester = (char *)malloc(1000 * sizeof(char));

    scanf(" %*[^\n]%*c", tester);

    while (strcmp(tester, "FIM") != 0)
    {
        srand(time(NULL));
        int A = 'a' + abs(rand() % 26);
        int B = 'a' + abs(rand() % 26);

        rngChange(A, B, tester);
        printf("%s\n", tester);

        scanf(" %[^\n]%*c", tester);
    }
}