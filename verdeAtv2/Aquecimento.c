#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{

    char *test = (char *)malloc(100 * sizeof(char));
    scanf(" %100[^\n]", test);

    while (strcmp(test, "FIM") != 0)
    {

        int c = 0;

        for (int i = strlen(test); i >= 0; i--)
        {
            int t = test[i];
            if (t <= 90 && t >= 65)
            {
                c++;
            }
        }
        printf("%d\n", c);

        scanf(" %100[^\n]", test);
    }

    return 0;
}