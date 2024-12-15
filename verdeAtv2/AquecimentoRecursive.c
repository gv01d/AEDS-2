#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int tester(char *testing)
{

    if (testing[0] != '\0')
    {
        int t = testing[strlen(testing) - 1];
        testing[strlen(testing) - 1] = '\0';

        if (t <= 90 && t >= 65)
        {
            return 1 + tester(testing);
        }
        else
        {
            return 0 + tester(testing);
        }
    }
    return 0;
}

int main()
{

    char *test = (char *)malloc(100 * sizeof(char));
    scanf(" %100[^\n]", test);

    while (strcmp(test, "FIM") != 0)
    {

        printf("%d\n", tester(test));

        scanf(" %100[^\n]", test);
    }

    return 0;
}