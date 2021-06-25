#include<stdbool.h>
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

typedef long long typ;
// w razie potrzeby moge latwo zamienic typ liczb przechowywanych w ulamku na int, ale niedbale je mnoze i dziele, wiec wole miec wiekszy zakres

typedef struct Ulamki
{
    typ licznik;
    typ mianownik;
} Ulamki;

static typ NWD (typ a, typ b)
{
    if(a == (typ)0)return b; //liczba 0 to ulamek 0/1
    if(a < (typ)0)a = -a;
    if(b < (typ)0)b = -b;
    int pom;

    while(b != (typ)0)
    {
        pom = b;
        b = a % b;
        a = pom;
    }

    return a;
}

static void uprosc(Ulamki *u)
{
    if( (u->licznik < (typ)0 && u->mianownik < (typ)0) || (u->licznik > (typ)0 && u->mianownik < (typ)0) )
    {
        u->licznik = -u->licznik;
        u->mianownik = -u->mianownik;
    }; // jak ulamek jest ujemny to minus jest w liczniku, z kolei minusy w liczniku i mianowniku na raz usuwam

    typ gcd = NWD(u->licznik, u->mianownik);
    u->licznik = u->licznik/gcd;
    u->mianownik = u->mianownik/gcd;

    return;
}

Ulamki *nowy_ulamek(float num, float denom)
{
    if(denom == (typ)0)
    {
        printf("blad: 0 w mianowniku\n");
        return NULL;
    }

    //zamieniam float na liczbe calkowita
    while((float)((typ)(num)) != num || (float)((typ)(denom)) != denom)
    {
        num = num * 10.0;
        denom = denom * 10.0;
    }

    Ulamki *a = malloc(sizeof(Ulamki));
    if(a == NULL)
    {
        printf("blad: nie udalo sie stworzyc ulamka\n");
        return NULL;
    }
    a->licznik = num;
    a->mianownik = denom;

    uprosc(a);

    return a;
}
void usun_ulamek(Ulamki *u)
{
    free(u);
    return;
}

Ulamki *dodaj_new(Ulamki * a, Ulamki *b)
{
    Ulamki *c = malloc(sizeof(Ulamki));
    if(c == NULL)
    {
        printf("blad: zle przypisanie pamieci\n");
        return NULL;
    }
    c->licznik = (a->licznik * b->mianownik) + (b->licznik * a->mianownik);
    c->mianownik = a->mianownik * b->mianownik;
    uprosc(c);

    return c;
}

Ulamki *odejmij_new(Ulamki *a, Ulamki *b)
{
    Ulamki *c = malloc(sizeof(Ulamki));
    if(c == NULL)
    {
        printf("blad: zle przypisanie pamieci\n");
        return NULL;
    }
    c->licznik = (a->licznik * b->mianownik) - (b->licznik * a->mianownik);
    c->mianownik = a->mianownik * b->mianownik;
    uprosc(c);

    return c;
}

Ulamki *pomnoz_new(Ulamki *a, Ulamki *b)
{
    Ulamki *c = malloc(sizeof(Ulamki));
    if(c == NULL)
    {
        printf("blad: zle przypisanie pamieci\n");
        return NULL;
    }
    c->licznik = a->licznik * b->licznik;
    c->mianownik = a->mianownik * b->mianownik;
    uprosc(c);

    return c;
}

Ulamki *podziel_new(Ulamki *a, Ulamki *b)
{
    if(b->licznik == (typ)0)
    {
        printf("blad: dzielenie przez 0");
        return NULL;
    }
    Ulamki *c = malloc(sizeof(Ulamki));
    if(c == NULL)
    {
        printf("blad: zle przypisanie pamieci\n");
        return NULL;
    }
    c->licznik = a->licznik * b->mianownik;
    c->mianownik = a->mianownik * b->licznik;
    uprosc(c);

    return c;
}

void dodaj_old(Ulamki * a, Ulamki *b)
{
    typ num = (a->licznik * b->mianownik) + (b->licznik * a->mianownik);
    typ denom = a->mianownik * b->mianownik;
    b->licznik = num;
    b->mianownik = denom;
    uprosc(b);

    return;
}

void odejmij_old(Ulamki *a, Ulamki *b)
{
    typ num = (a->licznik * b->mianownik) - (b->licznik * a->mianownik);
    typ denom = a->mianownik * b->mianownik;
    b->licznik = num;
    b->mianownik = denom;
    uprosc(b);

    return;
}

void pomnoz_old(Ulamki *a, Ulamki *b)
{
    typ num = a->licznik * b->licznik;
    typ denom = a->mianownik * b->mianownik;
    b->licznik = num;
    b->mianownik = denom;
    uprosc(b);

    return;
}

void podziel_old(Ulamki *a, Ulamki *b)
{
    if(b->licznik == (typ)0)
    {
        printf("blad: dzielenie przez 0");
        return;
    }
    typ num = a->licznik * b->mianownik;
    typ denom = a->mianownik * b->licznik;
    b->licznik = num;
    b->mianownik = denom;
    uprosc(b);

    return;
}

void wypisz_ulamek(Ulamki * u)
{
    if(u == NULL)
    {
        printf("blad: brak ulamka");
        return;
    }
    printf("%lld/%lld \n", (long long)u->licznik, (long long)u->mianownik);
    //zutowanie na long long jest jakbym postanowil zmienic typ liczb na int zeby nie zmieniac tej funkcji dodatkowo
    return;
}
