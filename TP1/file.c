#include <stdlib.h>
#include <stdio.h>

int main()
{
    FILE *flp;
    flp = fopen("buff.txt", "w");
    if (flp == NULL)
    {
        printf("nullFile Creation");
        return 0;
    }

    long int siz = sizeof(float);

    int n;
    scanf("%d", &n);

    float f;
    for (size_t i = 0; i < n; i++)
    {
        scanf("%f", &f);
        fwrite(&f, sizeof(float), 1, flp);
    }
    fclose(flp);

    flp = fopen("buff.txt", "r");
    if (flp == NULL)
    {
        printf("nullFile Opening");
        return 0;
    }
    fseek(flp, -siz, SEEK_END);
    for (size_t i = 0; i < n; i++)
    {
        fread(&f, siz, 1, flp);
        printf("%g\n", f);
        fseek(flp, -2.0 * siz, SEEK_CUR);
    }
}