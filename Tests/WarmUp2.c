#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int *val;
    int height;

} PNode;
typedef struct
{
    PNode *pilha;

} LNode;

int main()
{
    int N = 0, P = 0;
    scanf("%d %d", &N, &P);
    while (N != 0 && P != 0)
    {
        LNode list;
        list.pilha = (PNode *)malloc(P * sizeof(PNode));
        int sTmp = 0, tmp = 0;
        for (size_t i = 0; i < P; i++)
        {
            scanf("%d", &sTmp);
            list.pilha[i].height = sTmp;
            list.pilha[i].val = (int *)malloc(sTmp * sizeof(int));
            for (size_t j = 0; j < sTmp; j++)
            {
                scanf("%d", list.pilha[i].val[j]);
            }
            
        }
    }
}