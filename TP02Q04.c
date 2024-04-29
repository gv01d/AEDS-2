#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <string.h>
#include <stdarg.h>

// ignore || (char *)malloc(100 * sizeof(char))

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

/*
 _          _______    ______     _______
( (    /|  (  ___  )  (  __  \   (  ____ \
|  \  ( |  | (   ) |  | (  \  )  | (    \/
|   \ | |  | |   | |  | |   ) |  | (__
| (\ \) |  | |   | |  | |   | |  |  __)
| | \   |  | |   | |  | |   ) |  | (
| )  \  |  | (___) |  | (__/  )  | (____/\
|/    )_)  (_______)  (______/   (_______/

*/

//
typedef struct node
{
    void *data;
    struct node *top;
    struct node *bottom;
} Node;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

/*
 _         _________   _______   _________
( \        \__   __/  (  ____ \  \__   __/
| (           ) (     | (    \/     ) (
| |           | |     | (_____      | |
| |           | |     (_____  )     | |
| |           | |           ) |     | |
| (____/\  ___) (___  /\____) |     | |
(_______/  \_______/  \_______)     )_(

*/

//
typedef struct list
{
    size_t size;
    Node *sky;
    Node *base;
} List;

Node *find_index(List *list, size_t index)
{

    Node *selected;

    if (index <= list->size / 2)
    {
        selected = list->sky;
        for (size_t i = 0; i < index; i++)
        {
            selected = selected->bottom;
        }
    }
    else
    {
        selected = list->base;
        for (size_t i = 0; i < index; i++)
        {
            selected = selected->top;
        }
    }

    return selected;
}

List *create_list()
{
    List *new_list = (List *)malloc(sizeof(List));
    new_list->size = 0;
    new_list->sky = NULL;
    new_list->base = NULL;
    return new_list;
}

/*
    █████╗   ██████╗   ██████╗
   ██╔══██╗  ██╔══██╗  ██╔══██╗
   ███████║  ██║  ██║  ██║  ██║
   ██╔══██║  ██║  ██║  ██║  ██║
   ██║  ██║  ██████╔╝  ██████╔╝
   ╚═╝  ╚═╝  ╚═════╝   ╚═════╝
*/

void add_on_top(List *list, void *data)
{
    Node *data_node = (Node *)malloc(sizeof(List));

    data_node->top = NULL;
    data_node->data = data;
    data_node->bottom = list->sky;

    if (list->size > 0)
    {
        list->sky->top = data_node;
    }
    else
    {
        list->base = data_node;
    }

    list->sky = data_node;
    list->size += 1;
}
void add_on_bottom(List *list, void *data)
{
    Node *data_node = (Node *)malloc(sizeof(List));

    data_node->top = list->base;
    data_node->data = data;
    data_node->bottom = NULL;

    if (list->size > 0)
    {
        list->base->bottom = data_node;
    }
    else
    {
        list->sky = data_node;
    }

    list->base = data_node;
    list->size += 1;
}
int add_on_index(List *list, void *data, size_t index)
{
    if (index > list->size - 1)
        return -1;
    if (index = 0)
    {
        add_on_top(list, data);
        return 0;
    }
    if (index = list->size - 1)
    {
        add_on_bottom(list, data);
        return 0;
    }

    Node *data_node = (Node *)malloc(sizeof(List));
    data_node->data = data;

    Node *selected = find_index(list, index);

    Node *top = selected->top;

    top->bottom = data_node;
    selected->top = data_node;

    data_node->top = top;
    data_node->bottom = selected;

    list->size += 1;
}

/*
   ██████╗   ███████╗  ███╗   ███╗   ██████╗   ██╗   ██╗  ███████╗
   ██╔══██╗  ██╔════╝  ████╗ ████║  ██╔═══██╗  ██║   ██║  ██╔════╝
   ██████╔╝  █████╗    ██╔████╔██║  ██║   ██║  ██║   ██║  █████╗
   ██╔══██╗  ██╔══╝    ██║╚██╔╝██║  ██║   ██║  ╚██╗ ██╔╝  ██╔══╝
   ██║  ██║  ███████╗  ██║ ╚═╝ ██║  ╚██████╔╝   ╚████╔╝   ███████╗
   ╚═╝  ╚═╝  ╚══════╝  ╚═╝     ╚═╝   ╚═════╝     ╚═══╝    ╚══════╝
*/

void *remove_from_top(List *list);
void *remove_from_index(List *list, size_t index);
void *remove_from_bottom(List *list);

void *remove_from_top(List *list)
{
    if (list->size < 1)
        return NULL;

    Node *temp = list->sky;
    list->sky = temp->bottom;

    if (list->size > 1)
    {
        list->sky->top = NULL;
    }
    else
    {
        list->base = NULL;
    }

    list->size -= 1;
    void *dt = temp->data;
    free(temp);

    return dt;
}

void *remove_from_bottom(List *list)
{
    if (list->size < 1)
        return NULL;

    Node *temp = list->base;
    list->base = temp->top;

    if (list->size > 1)
    {
        list->base->bottom = NULL;
    }
    else
    {
        list->base->top = NULL;
    }

    list->size -= 1;
    void *dt = temp->data;
    free(temp);

    return dt;
}

void *remove_from_index(List *list, size_t index)
{
    if (index > list->size - 1)
        return NULL;
    if (index = 0)
        return remove_from_top(list);
    if (index = list->size - 1)
        return remove_from_bottom(list);

    Node *selected = find_index(list, index);

    Node *top = selected->top;
    Node *bot = selected->bottom;

    if (top != NULL)
        top->bottom = bot;
    if (bot != NULL)
        bot->top = top;

    list->size += 1;
    void *val = selected->data;
    free(selected);

    return val;
}
/*
   ███████╗  ███████╗  ████████╗
   ██╔════╝  ██╔════╝  ╚══██╔══╝
   ███████   █████╗       ██║
   ╚════██║  ██╔══╝       ██║
   ███████║  ███████╗     ██║
   ╚══════╝  ╚══════╝     ╚═╝
*/

void set_top(List *list, void *data)
{
    list->sky->data = data;
}
void set_bottom(List *list, void *data)
{
    list->base->data = data;
}

size_t set_index(List *list, void *data, size_t index)
{
    if (index > list->size - 1)
        return -1;
    if (index = 0)
    {
        set_top(list, data);
        return 0;
    }
    if (index = list->size - 1)
    {
        set_bottom(list, data);
        return 0;
    }

    Node *selected = find_index(list, index);

    selected->data = data;
}
/*
    ██████╗   ███████╗  ████████╗
   ██╔════╝   ██╔════╝  ╚══██╔══╝
   ██║  ███╗  █████╗       ██║
   ██║   ██║  ██╔══╝       ██║
   ╚██████╔╝  ███████╗     ██║
    ╚═════╝   ╚══════╝     ╚═╝
*/

void *get_top(List *list);
void *get_index(List *list, size_t index);
void *get_bottom(List *list);

void *get_top(List *list)
{
    return list->sky->data;
}

void *get_bottom(List *list)
{
    return list->base->data;
}

void *get_index(List *list, size_t index)
{
    if (index > list->size - 1)
        return NULL;
    if (index = 0)
        return get_top(list);
    if (index = list->size - 1)
        return get_bottom(list);

    Node *selected = find_index(list, index);

    return selected->data;
}

List *stringArrayToList(char **text, size_t size)
{
    List *list = create_list();

    for (size_t i = 0; (i < size) && (text[i][0] != '\0'); i++)
    {
        add_on_bottom(list, (void *)text[i]);
    }

    return list;
}
List *print_list(List *list)
{
    Node *selected = list->sky;

    if (list->size > 0)
    {
        for (size_t i = 0; i < list->size; i++)
        {
            printf("%s", (char *)selected->data);
            selected = selected->bottom;
            if (i < list->size - 1)
            {
                printf(",");
            }
        }
    }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

/*
    _________  _________   _______    _______
    \__   __/  \__   __/  (       )  (  ____ \
       ) (        ) (     | () () |  | (    \/
       | |        | |     | || || |  | (__
       | |        | |     | |(_)| |  |  __)
       | |        | |     | |   | |  | (
       | |     ___) (___  | )   ( |  | (____/\
       )_(     \_______/  |/     \|  (_______/
*/

//

typedef struct time
{
    int Yday;
    int Month;
    int Year;
} Time;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

/*
 _______    _______    _______    _______    _______    _          _______    _______    _______    _______
(  ____ )  (  ____ \  (  ____ )  (  ____ \  (  ___  )  ( (    /|  (  ___  )  (  ____ \  (  ____ \  (       )
| (    )|  | (    \/  | (    )|  | (    \/  | (   ) |  |  \  ( |  | (   ) |  | (    \/  | (    \/  | () () |
| (____)|  | (__      | (____)|  | (_____   | |   | |  |   \ | |  | (___) |  | |        | (__      | || || |
|  _____)  |  __)     |     __)  (_____  )  | |   | |  | (\ \) |  |  ___  |  | | ____   |  __)     | |(_)| |
| (        | (        | (\ (           ) |  | |   | |  | | \   |  | (   ) |  | | \_  )  | (        | |   | |
| )        | (____/\  | ) \ \__  /\____) |  | (___) |  | )  \  |  | )   ( |  | (___) |  | (____/\  | )   ( |
|/         (_______/  |/   \__/  \_______)  (_______)  |/    )_)  |/     \|  (_______)  (_______/  |/     \|

*/

//

typedef struct Personagens
{
    char *id;
    char *name;
    List *alternate_names;
    char *house;
    char *ancestry;
    char *species;
    char *patronus;
    bool hogwartsStaff;
    bool hogwartsStudent;
    char *actorName;
    bool alive;
    List *alternate_actors;
    Time dateOfBirth;
    size_t yearOfBirth;
    char *eyeColour;
    char *gender;
    char *hairColour;
    bool wizard;

} Personagens;

/*
███████╗  ███████╗  ████████╗
██╔════╝  ██╔════╝  ╚══██╔══╝
███████   █████╗       ██║
╚════██║  ██╔══╝       ██║
███████║  ███████╗     ██║
╚══════╝  ╚══════╝     ╚═╝
*/

void set_id(Personagens *p, char *value)
{
    p->id = strdup(value);
}
void set_name(Personagens *p, char *value)
{
    p->name = strdup(value);
}
void set_alternative_names_string(Personagens *p, char *value)
{
    char **altN = (char **)malloc(30 * sizeof(char *));
    for (size_t i = 0; i < 30; i++)
    {
        altN[i] = (char *)malloc(30 * sizeof(char));
    }

    char C;
    size_t j = 0;
    size_t z = 0;
    for (size_t i = 0; i < strlen(value); i++)
    {
        C = value[i];

        if (C == ',')
        {
            j++;
            z = 0;
        }
        else if (C != '\"' && C != '\'' && C != '[' && C != ']')
        {
            altN[j][z] = C;
            z++;
        }
    }

    p->alternate_names = stringArrayToList(altN, j + 2);
}
void set_house(Personagens *p, char *value)
{
    p->house = strdup(value);
}
void set_ancestry(Personagens *p, char *value)
{
    p->ancestry = strdup(value);
}
void set_species(Personagens *p, char *value)
{
    p->species = strdup(value);
}
void set_patronous(Personagens *p, char *value)
{
    p->patronus = strdup(value);
}
void set_hogwartsStaff_string(Personagens *p, char *value)
{
    p->hogwartsStaff = (strcmp(value, "VERDADEIRO") == 0);
}
void set_hogwartsStudent_string(Personagens *p, char *value)
{
    p->hogwartsStudent = (strcmp(value, "VERDADEIRO") == 0);
}
void set_actorName(Personagens *p, char *value)
{
    p->actorName = strdup(value);
}
void set_alive_string(Personagens *p, char *value)
{
    p->alive = (strcmp(value, "VERDADEIRO") == 0);
}

void set_alternate_actors_string(Personagens *p, char *value)
{
    if (strcmp(value, " ") == 0)
    {
        p->alternate_actors = NULL;
        return;
    }

    char **altN = (char **)malloc(30 * sizeof(char *));
    for (size_t i = 0; i < 30; i++)
    {
        altN[i] = (char *)malloc(30 * sizeof(char));
    }

    char C;
    size_t j = 0;
    size_t z = 0;
    for (size_t i = 0; i < strlen(value); i++)
    {
        C = value[i];

        if (C == ',')
        {
            j++;
            z = 0;
        }
        else if (C != '\"' && C != '\'' && C != '[' && C != ']')
        {
            altN[j][z] = C;
            z++;
        }
    }
    p->alternate_actors = stringArrayToList(altN, j + 2);
}

void set_dateOfBirth_string(Personagens *p, char *tim)
{
    size_t j[] = {0, 0, 0};
    size_t z = 0;
    for (size_t i = 0; i < strlen(tim); i++)
    {
        if (tim[i] == '-')
        {
            z++;
        }
        else
        {
            j[z] = (j[z] * 10) + (tim[i] - '0');
        }
    }

    p->dateOfBirth.Year = j[z];
    z--;
    p->dateOfBirth.Month = j[z];
    z--;
    p->dateOfBirth.Yday = j[z];
}
void set_yearOfBirth_string(Personagens *p, char *value)
{
    p->yearOfBirth = atoi(value);
}
void set_eyeColour(Personagens *p, char *value)
{
    p->eyeColour = strdup(value);
}
void set_gender(Personagens *p, char *value)
{
    p->gender = strdup(value);
}
void set_hairColour(Personagens *p, char *value)
{
    p->hairColour = strdup(value);
}
void set_wizard_string(Personagens *p, char *value)
{
    p->wizard = (strcmp(value, "VERDADEIRO") == 0);
}

typedef void (*setter_func)(Personagens *, char *);

typedef struct
{
    char *name;
    setter_func func;
} setter_entry;

setter_entry setters[] = {
    {"id", set_id},
    {"name", set_name},
    {"alternate_names", set_alternative_names_string},
    {"house", set_house},
    {"ancestry", set_ancestry},
    {"species", set_species},
    {"patronus", set_patronous},
    {"hogwartsStaff", set_hogwartsStaff_string},
    {"hogwartsStudent", set_hogwartsStudent_string},
    {"actorName", set_actorName},
    {"alive", set_alive_string},
    {"alternate_actors", set_alternate_actors_string},
    {"dateOfBirth", set_dateOfBirth_string},
    {"yearOfBirth", set_yearOfBirth_string},
    {"eyeColour", set_eyeColour},
    {"gender", set_gender},
    {"hairColour", set_hairColour},
    {"wizard", set_wizard_string}};

/*
    ██████╗   ███████╗  ████████╗
   ██╔════╝   ██╔════╝  ╚══██╔══╝
   ██║  ███╗  █████╗       ██║
   ██║   ██║  ██╔══╝       ██║
   ╚██████╔╝  ███████╗     ██║
    ╚═════╝   ╚══════╝     ╚═╝
*/

/*
   ██████╗   ██████╗   ██╗  ███╗   ██╗  ████████╗
   ██╔══██╗  ██╔══██╗  ██║  ████╗  ██║  ╚══██╔══╝
   ██████╔╝  ██████╔╝  ██║  ██╔██╗ ██║     ██║
   ██╔═══╝   ██╔══██╗  ██║  ██║╚██╗██║     ██║
   ██║       ██║  ██║  ██║  ██║ ╚████║     ██║
   ╚═╝       ╚═╝  ╚═╝  ╚═╝  ╚═╝  ╚═══╝     ╚═╝
*/

char *separator = " ## ";

void print_id(Personagens *p)
{
    printf("%s%s", p->id, separator);
}

void print_name(Personagens *p)
{
    printf("%s%s", p->name, separator);
}

// Assuming List is a list of strings
void print_alternate_names(Personagens *p)
{
    // You need to implement print_list function
    printf("{");
    print_list(p->alternate_names);
    printf("}%s", separator);
}

void print_house(Personagens *p)
{
    printf("%s%s", p->house, separator);
}

void print_ancestry(Personagens *p)
{
    printf("%s%s", p->ancestry, separator);
}

void print_species(Personagens *p)
{
    printf("%s%s", p->species, separator);
}

void print_patronus(Personagens *p)
{
    printf("%s%s", p->patronus, separator);
}

void print_hogwartsStaff(Personagens *p)
{
    printf("false%s", separator);
    // printf("%s%s", p->hogwartsStaff ? "true" : "false", separator);
}

void print_hogwartsStudent(Personagens *p)
{
    printf("false%s", separator);
    // printf("%s%s", p->hogwartsStudent ? "true" : "false", separator);
}

void print_actorName(Personagens *p)
{
    printf("%s%s", p->actorName, separator);
}

void print_alive(Personagens *p)
{
    printf("false%s", separator);
    // printf("%s%s", p->alive ? "true" : "false", separator);
}

// Assuming List is a list of strings
void print_alternate_actors(Personagens *p)
{
    // You need to implement print_list function
    print_list(p->alternate_actors);
    printf("%s", separator);
}

void print_dateOfBirth(Personagens *p)
{
    if ((p->dateOfBirth.Yday < 10))
        printf("0%d-", p->dateOfBirth.Yday);
    else
        printf("%d-", p->dateOfBirth.Yday);

    if ((p->dateOfBirth.Month < 10))
        printf("0%d-", p->dateOfBirth.Month);
    else
        printf("%d-", p->dateOfBirth.Month);

    printf("%d%s", p->dateOfBirth.Year, separator);
}

void print_yearOfBirth(Personagens *p)
{
    printf("%ld%s", p->yearOfBirth, separator);
}

void print_eyeColour(Personagens *p)
{
    printf("%s%s", p->eyeColour, separator);
}

void print_gender(Personagens *p)
{
    printf("%s%s", p->gender, separator);
}

void print_hairColour(Personagens *p)
{
    printf("%s%s", p->hairColour, separator);
}

void print_wizard(Personagens *p)
{
    printf("%s", p->wizard ? "true" : "false");
}
void printAllPersonagens(Personagens *p)
{
    printf("[");
    print_id(p);
    print_name(p);
    print_alternate_names(p);
    print_house(p);
    print_ancestry(p);
    print_species(p);
    print_patronus(p);
    print_hogwartsStaff(p);
    print_hogwartsStudent(p);
    print_actorName(p);
    print_alive(p);
    // print_alternate_actors(p);
    print_dateOfBirth(p);
    print_yearOfBirth(p);
    print_eyeColour(p);
    print_gender(p);
    print_hairColour(p);
    print_wizard(p);
    printf("]\n");
}

/*
   ██████╗   ███████╗   █████╗   ██████╗
   ██╔══██╗  ██╔════╝  ██╔══██╗  ██╔══██╗
   ██████╔╝  █████╗    ███████║  ██║  ██║
   ██╔══██╗  ██╔══╝    ██╔══██║  ██║  ██║
   ██║  ██║  ███████╗  ██║  ██║  ██████╔╝
   ╚═╝  ╚═╝  ╚══════╝  ╚═╝  ╚═╝  ╚═════╝
*/

struct tm *testtm;

void call_setter(char *name, Personagens *p, char *value)
{

    for (size_t i = 0; i < sizeof(setters) / sizeof(setter_entry); i++)
    {
        if (strcmp(name, setters[i].name) == 0)
        {
            setters[i].func(p, value);
            return;
        }
    }
}

char **firstLine(char *fline)
{
    char **order = (char **)malloc(50 * sizeof(char *));
    for (size_t i = 0; i < 50; i++)
    {
        order[i] = (char *)calloc(100, sizeof(char));
    }

    char C = ' ';
    size_t j = 0;
    size_t z = 0;

    for (size_t i = 3; i < strlen(fline); i++)
    {
        C = fline[i];
        if (C == ';')
        {
            j++;
            z = 0;
        }
        else if (C != '\"' && C != '\'' && C != '[' && C != ']' && C != '\r' && C != '\n')
        {
            order[j][z] = C;
            z++;
        }
    }
    return order;
}

void lineToClass(char *text, char **order, Personagens *p)
{
    char *temp = (char *)calloc(200, sizeof(char));

    size_t mode = 0;
    char C = ' ';
    size_t j = 0;
    size_t z = 0;
    for (size_t i = 0; i < strlen(text); i++)
    {
        C = text[i];
        if (C == ';' && mode == 0)
        {
            call_setter(order[z], p, temp);
            z++;
            j = 0;
            memset(temp, '\0', 200);
        }
        else if (C == '[' || C == ']')
        {
            if (mode == 1)
            {
                mode = 0;
            }
            else
            {
                if (text[i + 1] == ']')
                    temp[j] = '\0';
                mode = 1;
            }
        }
        else if (C != '\"' && C != '\'' && C != '\r' && C != '\n')
        {
            temp[j] = C;
            j++;
        }
    }

    call_setter(order[z], p, temp);

    free(temp);
}

void read(char *filename, Personagens p[500])
{
    if (p == NULL)
    {
        printf("Erro na alocação de memória para p.\n");
        exit(1);
    }

    FILE *f = fopen(filename, "r");
    if (f == NULL)
    {
        printf("Erro na abertura do arquivo %s.\n", filename);
        exit(1);
    }

    char *temp = (char *)calloc(1000, sizeof(char));
    if (temp == NULL)
    {
        printf("Erro na alocação de memória para temp.\n");
        exit(1);
    }

    if (fgets(temp, 1000, f) == NULL)
    {
        printf("Error in fgets");
    };
    char **order = firstLine(temp);

    size_t i = 0;
    while (fgets(temp, 1000, f) != NULL)
    {
        lineToClass(temp, order, &p[i]);
        i++;
    }

    free(temp);
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

/*
 _______    _______    _______   _________
(  ____ \  (  ___  )  (  ____ )  \__   __/
| (    \/  | (   ) |  | (    )|     ) (
| (_____   | |   | |  | (____)|     | |
(_____  )  | |   | |  |     __)     | |
      ) |  | |   | |  | (\ (        | |
/\____) |  | (___) |  | ) \ \__     | |
\_______)  (_______)  |/   \__/     )_(
*/

//

void swapString(char **p1, char **p2)
{
    char *tmp = *p1;
    *p1 = *p2;
    *p2 = *tmp;
}

void quicksort(char *p[404], int left, int right)
{
    int i = left, j = right, pivot = (left + right) / 2;
    while (i <= j)
    {
        while (strcmp(p[i], p[pivot]) < 0)
        {
            i++;
        }
        while (strcmp(p[j], p[pivot]) > 0)
        {
            j--;
        }
        if (i <= j)
        {
            swapString(p + i, p + j);
        }
    }
    if (left < j)
    {
        quicksort(p, left, j);
    }
    if (i < right)
    {
        quicksort(p, i, right);
    }
}

void sort(char *p[404], int len)
{
    quicksort(p, 0, len - 1);
}

bool binSearch(char *p[404],char *name,int len)
{
    bool resp = false;
    int dir = len - 1, esq = 0, meio;
    int comp;
    while (esq <= dir)
    {
        meio = (esq + dir) / 2;
        comp = strcmp(name,p[meio]);
        if (comp == 0)
        {
            resp = true;
            esq = len;
        }
        else if (comp > 0)
        {
            esq = meio + 1;
        }
        else
        {
            dir = meio - 1;
        }
    }
    return resp;
}

int main()
{
    Personagens p[404];
    read("/tmp/characters.csv", p);

    char *r = (char *)malloc(500 * sizeof(char));
    if (r == NULL)
    {
        printf("Erro na alocação de memória para r.\n");
        exit(1);
    }

    scanf("%s", r);
    r[strcspn(r, "\n")] = 0;
    Personagens a[404];
    int asize = 0;

    while (strcmp(r, "FIM") != 0)
    {
        asize++;
        for (size_t i = 0; i < 404; i++)
        {
            if (strcmp(p[i].id, r) == 0)
            {
                a[i] = p[i];
                break;
            }
        }
        scanf("%s", r);
        r[strcspn(r, "\n")] = 0;
    }

    sort(a, asize);

    scanf("%s", r);
    r[strcspn(r, "\n")] = 0;
    while (strcmp(r, "FIM") != 0)
    {
        asize++;
        for (size_t i = 0; i < 404; i++)
        {
            if (binSearch(a,r,asize))
            {
                printf("SIM");
            }
            else printf("NAO");
        }
        scanf("%s", r);
        r[strcspn(r, "\n")] = 0;
    }
}