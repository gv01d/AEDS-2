#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool poliTester(char *tester, int i, int size)
{
    if (size - i < i)
        return true;

    if (tester[i] != tester[size - 1 - i])
        return false;

    return poliTester(tester, i + 1, size);
}
bool poli(char *tester)
{
    if (tester == NULL || *tester == '\0')
    {
        return true;
    }
    size_t f = strlen(tester);
    return poliTester(tester, 0, f);
}

int main()
{

    char *tester = (char *)malloc(1000 * sizeof(char));

    scanf(" %*[^\n]%*c", tester);

    while (strcmp(tester, "FIM") != 0)
    {
        printf("%s\n", poli(tester) ? "SIM" : "NAO");

        scanf(" %[^\n]%*c", tester);
    }
    free(tester);
    return 0;
}