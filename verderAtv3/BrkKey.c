#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>

char *home(char *start, char *text)
{
    size_t t = strlen(text);
    size_t s = strlen(start);
    for (size_t i = 0; i < t; i++)
    {
        start[s + i] = text[i];
    }

    return start;
}

char *parser(char *text)
{
    size_t lenght = strlen(text);
    bool end = true;
    char *buf = (char *)malloc(100 * sizeof(char));
    char *result = (char *)malloc(100 * sizeof(char));

    size_t b = 0;
    size_t r = 0;
    memset(buf, 0, strlen(buf));
    memset(result, 0, strlen(result));

    for (size_t i = 0; i < lenght; i++)
    {
        if (text[i] == '[')
            end = false;
        else if (text[i] == ']')
        {
            r += b;
            strcpy(result, home(buf, result));
            memset(buf, 0, strlen(buf));
            end = true;
            b = 0;
        }
        else if (end)
        {
            result[r] = text[i];
            r++;
        }
        else
        {
            buf[b] = text[i];
            b++;
        }
    }
    strcpy(text, result);
    return result;
}

int main()
{

    char *text = (char *)malloc(100 * sizeof(char));

    while (fgets(text, 100, stdin) != NULL)
    {
        printf("%s", parser(text));
    }

    return 0;
}