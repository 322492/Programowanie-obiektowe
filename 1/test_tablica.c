#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "tablica.h"

int main()
{
    Tablica *t = nowa_tablica();

    srand(time(NULL));

    for(int i=0; i<20; i++)
    {
        int r = rand()%(2*1000*1000)-1000000; //liczba z zakresu (-10^6, 10^6);
        dodaj(t, r, r); //na losowym ineksie ustawiam wartosc tego indeksu
        printf("indeks = %d, wartosc = %d \n", r, indeks(t, r) );
    }

    printf("\n\nteraz troche losowych indeksow, (wiekszosc wartosci powinna byc domyslnymi zerami): \n");

    for(int i=0; i<20; i++)
    {
        int r = rand()%(2*1000*1000)-1000000; //liczba z zakresu (-10^6, 10^6);
        printf("indeks = %d, wartosc = %d \n", r, indeks(t, r) );
    }

    usun_tablice(t);

    return 0;
}
