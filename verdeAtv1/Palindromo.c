#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool poliTester(char *tester)
{
    if (tester == NULL || *tester == '\0')
    {
        return true;
    }

    size_t f = strlen(tester);
    for (int n = f - 1; n >= f / 2; n--)
    {
        if (tester[n] != tester[f - 1 - n])
            return false;
    }
    return true;
}

int main()
{

    char *tester = (char *)malloc(1000 * sizeof(char));

    scanf(" %*[^\n]%*c", tester);

    while (strcmp(tester, "FIM") != 0)
    {
        printf("%s\n", poliTester(tester) ? "SIM" : "NAO");

        scanf(" %[^\n]%*c", tester);
    }
    free(tester);
    return 0;
}