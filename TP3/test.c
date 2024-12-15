#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main()
{
    char c;
    do
    {
        c = getchar();
        printf("[%d]", c);
    } while (c != EOF);
}