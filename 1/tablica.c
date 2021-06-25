#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

typedef int typ; // typ wartosci przechowywanej w tablicy - mozna zmienic, ale wymaga to zmian w kilku miejscach kodu
static int L=INT_MAX, P=INT_MIN; //przedzial indeksow, ograniczony jest wielkosciami inta, w raie potrzeby mozna zmienic latwo na long long

// tablice przechowuje jako drzewo BST, o kluczach - indeksach i wartosciach w wezlach
typedef struct Tablica
{
    int ix; //indeks
    typ wart; //przechowywana wartosc
    struct Tablica *lewy;
    struct Tablica *prawy;
} Tablica;

Tablica *nowa_tablica() //inicjalizuje drzewo jako indeks 0 bez wartosci
{
    Tablica *t = malloc(sizeof(Tablica));
    if(t == NULL)
    {
        printf("blad: nie udalo sie stworzyc tablicy\n");
        return NULL;
    }
    t->ix = (typ)0;
    t->lewy = NULL;
    t->prawy = NULL;

    return t;
}

void usun_tablice(Tablica *t)
{
    if(t == NULL) return;
    usun_tablice(t->lewy);
    usun_tablice(t->prawy);
    free(t);

    return;
}

static Tablica *add(Tablica *t, int indeks, typ wartosc) //funkcja pomocnicza do funkcji dodaj()
{
    if(t == NULL)
    {
        Tablica *n = malloc(sizeof(Tablica));
        if(n == NULL)
        {
            printf("blad: nie udalo sie dodac wartosci\n");
            return NULL;
        }
        n->ix=indeks;
        n->wart=wartosc;
        n->lewy = NULL;
        n->prawy = NULL;
        return n;
    }
    else if(t->ix > indeks)t->lewy = add(t->lewy, indeks, wartosc);
    else if(t->ix < indeks)t->prawy = add(t->prawy, indeks, wartosc);
    else t->ix = indeks;
    return t;
}

void dodaj (Tablica *t, int indeks, typ wartosc)
{
    if(indeks < L)L = indeks;
    if(indeks > P)P = indeks;
    //printf("aktualny przedzial: %d  %d\n", L, P);

    if(t == NULL)
    {
        printf("blad: podano zla tablice\n");
        return;
    }
    else if(t->ix > indeks)t->lewy = add(t->lewy, indeks, wartosc);
    else if(t->ix < indeks)t->prawy = add(t->prawy, indeks, wartosc);
    else t->ix = indeks;
    return;
}

typ indeks(Tablica *t, int x)
{
    if(t == NULL)return (typ)0; //nic nie bylo przypisane do szukanego indeksu, domyslnie zwracam 0
    else if(x < L || x > P)
    {
        printf("blad: indeks jest poza tablica     " );
        return (typ)-1; // nie ladne
    }
    else if (t->ix == x) return t->wart;
    else if(x < t->ix)
        return indeks(t->lewy, x);
    else
        return indeks(t->prawy, x);
}

